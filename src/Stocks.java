public class Stocks extends Product{
    private String exchange, ticker;

    Stocks(String productId) {
        super(productId);
    }

    Stocks(String productId, String exchange, String ticker) {
        super(productId);
        this.exchange = exchange;
        this.ticker = ticker;
    }

    private void setCurrentPrice() {
        super.setValue(price(exchange, ticker));
    }

    @Override
    public double price(String exchange, String ticker) {
        return super.price(exchange, ticker);
    }
}
