package anything.cafekiosk.unit;

import anything.cafekiosk.unit.beverage.Americano;
import anything.cafekiosk.unit.beverage.Latte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CafeKioskRunner {

    private static Logger log = LoggerFactory.getLogger(CafeKioskRunner.class);

    public static void main(String[] args) {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());
        log.info(">>> 아메리카노 추가");

        cafeKiosk.add(new Latte());
        log.info(">>> 라떼 추가");

        int totalPrice = cafeKiosk.calculateTotalPrice();
        log.info(">>> 총 주문가격 : {} ", totalPrice);
    }
}
