package edu.neu.csye7374;

public class FinancialStock extends StockAPI {
    public FinancialStock(String id, double price, String description) {
        super(id, price, description);
    }

    @Override
    public void setBid(Bid bid) {
        bids.add(bid);
        price = calculateNewPrice(bid.getBidPrice());
    }

    @Override
    protected double calculateNewPrice(double bidPrice) {
        return price * 0.8 + bidPrice * 0.2;
    }

    @Override
    public int getMetric() {
        if (bids.isEmpty()) return 0;
        double avgBid = bids.stream()
                .mapToDouble(Bid::getBidPrice)
                .average()
                .orElse(0.0);
        return (int)((avgBid - price) * 100);
    }
}

