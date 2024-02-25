package anything.cafekiosk.unit;

import anything.cafekiosk.unit.beverage.Americano;
import anything.cafekiosk.unit.beverage.Latte;
import anything.cafekiosk.unit.order.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class CafeKioskTest {

    @Test
    void add_manual_test() {

        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());

        System.out.println(">>> 담김 음료 수: " + cafeKiosk.getBeverages().size());
        System.out.println(">>> 담김 음료 : " + cafeKiosk.getBeverages().get(0).getName());
    }

    @Test
    void add_test() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());

        Assertions.assertThat(cafeKiosk.getBeverages()).hasSize(1);
        Assertions.assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    void addSeveralBeverages() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        cafeKiosk.add(americano, 2);

        Assertions.assertThat(cafeKiosk.getBeverages().get(0)).isEqualTo(americano);
        Assertions.assertThat(cafeKiosk.getBeverages().get(1)).isEqualTo(americano);
    }

    @Test
    void addZeroBeverages() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        Assertions.assertThatThrownBy(
                        () -> cafeKiosk.add(americano, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음료 1잔 이상 필수");
    }

    @Test
    void remove() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        cafeKiosk.add(americano);

        Assertions.assertThat(cafeKiosk.getBeverages()).hasSize(1);

        cafeKiosk.delete(americano);
        Assertions.assertThat(cafeKiosk.getBeverages()).isEmpty();
    }

    @Test
    void clear() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        Latte latte = new Latte();

        cafeKiosk.add(americano);
        cafeKiosk.add(latte);
        Assertions.assertThat(cafeKiosk.getBeverages()).hasSize(2);

        cafeKiosk.deleteAll();
        Assertions.assertThat(cafeKiosk.getBeverages()).isEmpty();
    }

    @Test
    void calculateTotalPrice() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        Latte latte = new Latte();

        cafeKiosk.add(americano);
        cafeKiosk.add(latte);

        int totalPrice = cafeKiosk.calculateTotalPrice();

        Assertions.assertThat(totalPrice).isEqualTo(9500);
    }





    @Test
    void createOrder() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        cafeKiosk.add(americano);

        Order order = cafeKiosk.createOrder(LocalDateTime.now());

        Assertions.assertThat(order.getBeverages()).hasSize(1);
        Assertions.assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    void createOrderWithCurrentTime() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        cafeKiosk.add(americano);

        Order order = cafeKiosk.createOrder(LocalDateTime.of(2023, 1, 17, 10, 0));

        Assertions.assertThat(order.getBeverages()).hasSize(1);
        Assertions.assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    void createOrderWithOutSideOpenTime() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        cafeKiosk.add(americano);

        Assertions.assertThatThrownBy(
                        () -> cafeKiosk.createOrder(LocalDateTime.of(2023, 1, 17, 9, 59))
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("운영시간이 아닙니다");
    }

}