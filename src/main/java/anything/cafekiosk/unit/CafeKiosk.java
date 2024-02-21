package anything.cafekiosk.unit;

import anything.cafekiosk.unit.beverage.Beverage;
import anything.cafekiosk.unit.order.Order;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CafeKiosk {

    private final List<Beverage> beverages = new ArrayList<>();

    public void add(Beverage beverage) {
        beverages.add(beverage);
    }

    public void delete(Beverage beverage) {
        beverages.remove(beverage);
    }

    public void deleteAll() {
        beverages.clear();
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;

        for (Beverage b : beverages) {
            totalPrice += b.getPrice();
        }

        return totalPrice;
    }

    public Order createOrder() {
        return new Order(LocalDateTime.now(), beverages);
    }
}
