package anything.java;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaOperationTest {

    @Test
    void priority() {
        int a = 3;
        int b = 4;

        double x = (double) (a + b) / 2;
        double y = (double)((a + b) / 2);
        Assertions.assertThat(x).isEqualTo(3.5);
        Assertions.assertThat(y).isEqualTo(3.0);
    }
}
