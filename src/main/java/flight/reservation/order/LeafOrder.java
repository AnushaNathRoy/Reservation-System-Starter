package flight.reservation.order;
import java.util.ArrayList;
import java.util.List;

public class LeafOrder implements OrderDetailsComponent {

   public double price;

    public LeafOrder(double price) {
        this.price = price;
    }

    public void add(OrderDetailsComponent orderDetailsComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(OrderDetailsComponent orderDetailsComponent) {
        throw new UnsupportedOperationException();
    }

    public List<OrderDetailsComponent> getChildren() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        return this.price;
    }
} 
