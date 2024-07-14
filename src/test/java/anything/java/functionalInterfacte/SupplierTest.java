package anything.java.functionalInterfacte;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class SupplierTest {

    @Test
    void supplier() {

        // 단순히 제공
        // integer

        // 익명함수
        Supplier<Integer> supplier = () -> 1;

        Integer i = supplier.get();
        Assertions.assertThat(i).isEqualTo(1);

        Supplier<String> supplier1 = () -> "haha";
        String s = supplier1.get();
        Assertions.assertThat(s).isEqualTo("haha");

    }


}
