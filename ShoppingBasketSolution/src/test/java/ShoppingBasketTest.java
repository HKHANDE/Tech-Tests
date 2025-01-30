import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    @Test
    public void testTotalCost() {
        ShoppingBasket basket = new ShoppingBasket();

        basket.addItem("Apple", 35);
        basket.addItem("Apple", 35);
        basket.addItem("Banana", 20);
        basket.addItem("Melon", 50);
        basket.addItem("Melon", 50);
        basket.addItem("Lime", 15);
        basket.addItem("Lime", 15);
        basket.addItem("Lime", 15);

        assertEquals(210, basket.calculateTotal());
    }
}
