import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
class ProductMockTest {

    // mocking product price interface
    @Mock
    ProductPricingService productPrice;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        when(productPrice.price(Mockito.anyString(), Mockito.anyString())).thenReturn(10000.00);
        when(productPrice.price(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(15000.00);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public  void testMock() {
        verify(productPrice).price("exc","tic");
        verify(productPrice).price("exc","tic", 11, 2020);
    }
}