package flight.reservation.order;
import java.util.ArrayList;
import java.util.List;

public class CompositeOrder implements OrderDetailsComponent {

    private List<OrderDetailsComponent> orderDetailsComponents = new ArrayList<>();

    public void add(OrderDetailsComponent orderDetailsComponent) {
        orderDetailsComponents.add(orderDetailsComponent);
    }

    public void remove(OrderDetailsComponent orderDetailsComponent) {
        orderDetailsComponents.remove(orderDetailsComponent);
    }

    public List<OrderDetailsComponent> getChildren() {
        return orderDetailsComponents;
    }

    public double getPrice() {
        double price = 0;
        for (OrderDetailsComponent OrderDetailsComponent : orderDetailsComponents) {
            price += OrderDetailsComponent.getPrice();
        }
        return price;
    }
} 
