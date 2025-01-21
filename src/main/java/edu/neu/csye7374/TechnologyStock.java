package edu.neu.csye7374;

public class TechnologyStock extends StockAPI {
    public TechnologyStock(String id, double price, String description) {
        super(id, price, description);
    }

    @Override
    public void setBid(Bid bid) {
        bids.add(bid);
        price = calculateNewPrice(bid.getBidPrice());
    }

    @Override
    protected double calculateNewPrice(double bidPrice) {
        return (price + bidPrice) / 2;
    }

    @Override
    public int getMetric() {
        if (bids.isEmpty()) return 0;
        double lastBid = bids.get(bids.size() - 1).getBidPrice();
        return (int)((lastBid - price) * 100);
    }
}

