package anything.java.functionalInterfacte;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class FunctionTest {

    @Test
    void functionTest() {

        Function<String, Integer> function = s -> {
            if (s.equals("haha")) {
                return -1;
            }
            return 0;
        };

        Integer haha = function.apply("haha");
        Assertions.assertThat(haha).isEqualTo(-1);

        Integer haha1 = function.apply("haha1");
        Assertions.assertThat(haha1).isEqualTo(0);

    }
}
