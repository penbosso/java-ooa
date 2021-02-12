public class Futures extends Product{
    private String exchange, ticker, contractCode;
    private int month, year;

    Futures(String productId) {
        super(productId);
    }

    Futures(String productId, String exchange, String ticker, String contractCode, int month, int year) {
        super(productId);
        this.exchange = exchange;
        this.ticker = ticker;
        this.contractCode = contractCode;
        this.month = month;
        this.year = year;
    }

    private void setCurrentPrice() {
        super.setValue(price(exchange, ticker));
    }

    @Override
    public double price(String exchange, String contractCode, int month, int year) {
        return super.price(exchange, contractCode, month, year);
    }
}
