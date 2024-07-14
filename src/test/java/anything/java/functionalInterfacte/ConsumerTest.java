package anything.java.functionalInterfacte;

import jakarta.validation.constraints.Null;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class ConsumerTest {
    @Test
    void consumerTest() {
        Consumer<String> consumer = s -> {
            if (s == null) {
                throw new NullPointerException("Input string cannot be null");
            } else if ("haha".equals(s)) {
                throw new RuntimeException("consumer test");
            } else {
                System.out.println("s = " + s);
            }
        };

        Assertions.assertThatThrownBy(() -> consumer.accept(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Input string cannot be null");

        Assertions.assertThatThrownBy(() -> consumer.accept("haha"))
                .isInstanceOf(RuntimeException.class);

    }
}
