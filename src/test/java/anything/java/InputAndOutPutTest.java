package anything.java;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

class InputAndOutPutTest {

//    private static final Scanner sc = new Scanner(System.in);

    @Test
    void println_nextInt() {

        String input = "123 456 \n 789";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.printf("%d %d %d", a, b, c);
        Assertions.assertThat(a).isEqualTo(123);
        Assertions.assertThat(b).isEqualTo(456);
        Assertions.assertThat(c).isEqualTo(789);

    }

    @Test
    void printf_nextInt_exception() {
        String input = "123 abc";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);

        int a = sc.nextInt();
        Assertions.assertThat(a).isEqualTo(123);
        Assertions.assertThatThrownBy(() -> sc.nextInt()).isInstanceOf(InputMismatchException.class)
                .hasMessage(null);
    }

}
