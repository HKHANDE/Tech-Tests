import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    private final List<Item> items = new ArrayList<>();
    private final PricingRules pricingRule = new PricingRules();

    public ShoppingBasket() {
        initializeOffers();
    }

    // Initialize offers
    private void initializeOffers() {
        pricingRule.addOffer("Apple", items -> items.size() * 35);
        pricingRule.addOffer("Banana", items -> items.size() * 20);

        // Buy one get one free for Melons
        pricingRule.addOffer("Melon", items -> {
            int count = items.size();
            return (count / 2 + count % 2) * 50;
        });

        // Three for the price of two for Limes
        pricingRule.addOffer("Lime", items -> {
            int count = items.size();
            return ((count / 3) * 2 + count % 3) * 15;
        });
    }

    // Add item to the basket
    public void addItem(String name, int price) {
        items.add(new Item(name, price));
    }

    // Calculate total cost of the basket
    public int calculateTotal() {
        return pricingRule.calculateTotal(items);
    }

    public static void main(String[] args) {
        ShoppingBasket basket = new ShoppingBasket();

        basket.addItem("Apple", 35);
        basket.addItem("Apple", 35);
        basket.addItem("Banana", 20);
        basket.addItem("Melon", 50);
        basket.addItem("Melon", 50);
        basket.addItem("Lime", 15);
        basket.addItem("Lime", 15);
        basket.addItem("Lime", 15);

        int totalCost = basket.calculateTotal();
        System.out.println("Total cost: " + totalCost + "p");
    }

}
