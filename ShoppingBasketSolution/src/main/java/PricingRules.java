import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PricingRules {

    private final Map<String, Offer> offers = new HashMap<>();

    // Add offer to the pricing rules
    public void addOffer(String itemName, Offer offer) {
        offers.put(itemName, offer);
    }

    // Calculate total cost of the basket
    public int calculateTotal(List<Item> items) {
        Map<String, List<Item>> groupedItems = new HashMap<>();
        for (Item item : items) {
            groupedItems.putIfAbsent(item.getName(), new ArrayList<>());
            groupedItems.get(item.getName()).add(item);
        }

        int total = 0;

        for (Map.Entry<String, List<Item>> entry : groupedItems.entrySet()) {
            String itemName = entry.getKey();
            List<Item> itemGroup = entry.getValue();

            Offer offer = offers.getOrDefault(itemName, itemsList ->
                    itemsList.stream().mapToInt(Item::getPrice).sum()
            );

            total += offer.apply(itemGroup);
        }

        // Return total cost
        return total;
    }

}
