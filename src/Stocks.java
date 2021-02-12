public class Stocks extends Product{

    Stocks(String productId) {
        super(productId);
    }

    @Override
    public double price(String exchange, String ticker) {
        return super.price(exchange, ticker);
    }
}
