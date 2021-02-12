import exceptions.ProductAlreadyRegisteredException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradedProducts implements MontrealTradedProducts{
    public List<Product> getProductList() {
        return productList;
    }

    public Map<Product, Integer> getProductTradeMap() {
        return productTradeMap;
    }

    private List<Product> productList = new ArrayList<Product>();
    private Map<Product, Integer> productTradeMap = new HashMap<Product, Integer>();

    /**
     * Adds a new product to the system that
     * the class will track statistics for
     *
     * @param product add a product available for trading
     * @throws ProductAlreadyRegisteredException thrown
     *                                           when a product is registered twice
     */
    @Override
    public void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        if(productList.contains(product)) {
            throw new ProductAlreadyRegisteredException();
        } else {
            this.productList.add(product);
        }
    }

    /**
     * Books a quantity against the product traded. If the product
     * has not been registered, no quantity is recorded as
     * it is not a product we are required to track.
     *
     * @param product  the product traded
     * @param quantity the quantity traded
     */
    @Override
    public void trade(Product product, int quantity) {
        if(this.productList.contains(product)) {
            this.productTradeMap.put(product, quantity);
        }
    }

    /**
     * Calculates the total quantity of all the registered
     * traded products so far today
     *
     * @return the total quantity traded
     */
    @Override
    public int totalTradeQuantityForDay() {
        return (int) this.productList.stream().mapToDouble(product -> productTradeMap.get(product)).sum();
    }

    /**
     * Calculates the total value of all the registered traded products
     * so far today. This is done by multiplying the value by the quantity
     * traded.
     *
     * @return the total value of today's traded products that are
     * registered in the system
     */
    @Override
    public double totalValueOfDaysTradedProducts() {
        return 0;
    }
}
