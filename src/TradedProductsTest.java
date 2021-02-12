import exceptions.ProductAlreadyRegisteredException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TradedProductsTest {

    @BeforeEach
    void setUp() throws ProductAlreadyRegisteredException {
        Product stockProduct1 = new Stocks("1");
        Product stockProduct2 = new Stocks("2");
        Product stockProduct3 = new Stocks("3");

        TradedProducts sampleTradedProduct = new TradedProducts();
        sampleTradedProduct.addNewProduct(stockProduct1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addNewProduct()  throws ProductAlreadyRegisteredException {
        Product stockProduct1 = new Stocks("1");

        TradedProducts sampleTradedProduct = new TradedProducts();
        sampleTradedProduct.addNewProduct(stockProduct1);

        assertEquals("1",sampleTradedProduct.getProductList().get(0).getProductId());

    }

    @Test
    void addNewProductException()  throws ProductAlreadyRegisteredException {

        assertThrows(ProductAlreadyRegisteredException.class, () -> {

            Product stockProduct1 = new Stocks("1");

            TradedProducts sampleTradedProduct = new TradedProducts();
            sampleTradedProduct.addNewProduct(stockProduct1);
            sampleTradedProduct.addNewProduct(stockProduct1);
        });

    }

    @Test
    void trade() throws ProductAlreadyRegisteredException {
        Product stockProduct1 = new Stocks("1");
        Product stockProduct2 = new Stocks("2");

        TradedProducts sampleTradedProduct = new TradedProducts();
        sampleTradedProduct.addNewProduct(stockProduct1);

        sampleTradedProduct.trade(stockProduct1, 5);
        sampleTradedProduct.trade(stockProduct2,6);
        assertEquals(5, sampleTradedProduct.getProductTradeMap().get(stockProduct1));
        // will not contain second product since its not registered
        assertFalse(sampleTradedProduct.getProductTradeMap().containsKey(stockProduct2));
    }

    @Test
    void totalTradeQuantityForDay() throws ProductAlreadyRegisteredException {
        Product stockProduct1 = new Stocks("1");
        Product stockProduct2 = new Stocks("2");

        TradedProducts sampleTradedProduct = new TradedProducts();
        sampleTradedProduct.addNewProduct(stockProduct1);
        sampleTradedProduct.addNewProduct(stockProduct2);

        sampleTradedProduct.trade(stockProduct1, 5);
        sampleTradedProduct.trade(stockProduct2,6);
        assertEquals(11, sampleTradedProduct.totalTradeQuantityForDay());
    }

    @Test
    void totalValueOfDaysTradedProducts() {
    }
}