package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public abstract class StockAPI implements Tradable {
    protected String id;
    protected double price;
    protected String description;
    protected List<Bid> bids;

    public StockAPI(String id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.bids = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("%s: $%.2f (Metric: %d)",
                id, price, getMetric());
    }

    protected abstract double calculateNewPrice(double bidPrice);
}

