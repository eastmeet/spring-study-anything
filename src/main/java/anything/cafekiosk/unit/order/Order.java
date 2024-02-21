package anything.cafekiosk.unit.order;

import anything.cafekiosk.unit.beverage.Beverage;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Order {

    private final LocalDateTime orderDateTime;

    private final List<Beverage> beverages;

    public Order(LocalDateTime orderDateTime, List<Beverage> beverages) {
        this.orderDateTime = orderDateTime;
        this.beverages = beverages;
    }
}
