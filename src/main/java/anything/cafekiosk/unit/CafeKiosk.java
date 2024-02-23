package anything.cafekiosk.unit;

import anything.cafekiosk.unit.beverage.Beverage;
import anything.cafekiosk.unit.order.Order;
import lombok.Getter;
import org.aspectj.apache.bcel.generic.LOOKUPSWITCH;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CafeKiosk {

    public static final LocalTime SHOP_OPEN_TIME = LocalTime.of(10, 0);

    public static final LocalTime SHOP_CLOSE_TIME = LocalTime.of(22, 0);

    private final List<Beverage> beverages = new ArrayList<>();

    public void add(Beverage beverage) {
        beverages.add(beverage);
    }

    public void add(Beverage beverage, int count) {

        if (count <= 0) {
            throw new IllegalArgumentException("음료 1잔 이상 필수");
        }

        for (int i = 0; i < count; i++) {
            beverages.add(beverage);
        }
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

    public Order createOrder(LocalDateTime currentDateTime) {
        LocalTime currentTime = currentDateTime.toLocalTime();

        if (currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
            throw new IllegalArgumentException("운영시간이 아닙니다");
        }

        return new Order(currentDateTime, beverages);
    }
}
