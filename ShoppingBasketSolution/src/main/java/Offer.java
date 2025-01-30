import java.util.List;

@FunctionalInterface
public interface Offer {

    int apply(List<Item> items);
}
