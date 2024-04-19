package anything.java.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ConvertCaseTest {

    @Test
    void test_use_Character() {
        String input = "djgKLUOIHkAjHGYURrUHGUYU";
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            } else {
                c = Character.toUpperCase(c);
            }
            sb.append(c);
        }
        Assertions.assertThat(sb).hasToString("DJGkluoihKaJhgyurRuhguyu");
    }

    @Test
    void test_use_intValue() {
        String input = "dkieYOYOHKGhkgLKJLKJgBlkBlLJ";
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                // 대문자의 범위는 65~90
                c += 32;
            } else {
                // 소문자의 범위는 97~122
                c -= 32;
            }
            sb.append(c);
        }
        Assertions.assertThat(sb).hasToString("DKIEyoyohkgHKGlkjlkjGbLKbLlj");
    }
}
