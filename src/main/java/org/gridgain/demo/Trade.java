package org.gridgain.demo;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.sql.Timestamp;

public class Trade {

    @QuerySqlField(index = true)
    private final String symbol;

    @QuerySqlField
    private int order_quantity;
    @QuerySqlField
    private final double bid_price;
    @QuerySqlField
    private final String trade_type;
    @QuerySqlField
    private final Timestamp order_date;
    private long timestamp;

    public Trade(String symbol, int order_quantity, double bid_price, String trade_type, Timestamp order_date) {
        this.symbol = symbol;
        this.order_quantity = order_quantity;
        this.bid_price = bid_price;
        this.trade_type = trade_type;
        this.order_date = order_date;
        this.timestamp = order_date.getTime();
    }

    public String getSymbol() {
        return symbol;
    }

    public int getOrderQuantity() {
        return order_quantity;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }

    public double getBidPrice() {
        return bid_price;
    }

    public String getTradeType() {
        return trade_type;
    }

    public Timestamp getOrderDate() {
        return order_date;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public enum TRADE_TYPE {BUY, SELL}
}

