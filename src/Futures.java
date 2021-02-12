public class Futures extends Product{
    Futures(String productId) {
        super(productId);
    }

    @Override
    public double price(String exchange, String contractCode, int month, int year) {
        return super.price(exchange, contractCode, month, year);
    }
}
