package flight.reservation.order;
import java.util.ArrayList;
import java.util.List;

public interface OrderDetailsComponent {
    void add(OrderDetailsComponent orderComponent);
    void remove(OrderDetailsComponent orderComponent);
    List<OrderDetailsComponent> getChildren();
    double getPrice();
}