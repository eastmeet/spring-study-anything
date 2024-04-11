package anything.java.string;

import jdk.jfr.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RemoveStringTest {


    @Test
    @DisplayName("글자 지우기0")
    @Description("O(N + M)")
    void string_remove_test_only_one_case() {

        String my_string = "apporoograpemmemprs";

        int[] indices = {1, 16, 6, 15, 0, 10, 11, 3};
        char[] array = my_string.trim().toCharArray();

        for (int i : indices) {
            array[i] = ' ';
        }

        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            if (c != ' ') {
                sb.append(c);
            }
        }

        String result = sb.toString();
        Assertions.assertThat(result).isEqualTo("programmers");
    }


    @Test
    @DisplayName("글자 지우기 flag 사용")
    @Description("O(N * M)")
    void string_remove_test_using_flag() {

        String my_string = "apporoograpemmemprs";
        int[] indices = {1, 16, 6, 15, 0, 10, 11, 3};
        StringBuilder builder = new StringBuilder();
        char[] array = my_string.toCharArray();

        for (int i = 0; i < array.length; i++) {

            boolean flag = true;

            for (int index : indices) {
                if (i == index) {
                    flag = false;
                }
            }

            if (flag) {
                builder.append(array[i]);
            }
        }
        String result = builder.toString();
        Assertions.assertThat(result).isEqualTo("programmers");
    }

    @Test
    @DisplayName("글자 지우기 flag 배열 사용")
    @Description("O(N + M)")
    void string_remove_test_using_flag_array() {

        String my_string = "apporoograpemmemprs";
        int[] indices = {1, 16, 6, 15, 0, 10, 11, 3};

        boolean[] skip = new boolean[my_string.length()];
        for (int index : indices) {
            skip[index] = true;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            if (!skip[i]) {
                builder.append(my_string.charAt(i));
            }
        }

        String result = builder.toString();
        Assertions.assertThat(result).isEqualTo("programmers");
    }

    @Test
    @DisplayName("글자 지우기 String builder 메소드 사용")
    @Description("O(n + m log m + m)")
    void string_remove_test_using_string_builder_method() {

        String my_string = "apporoograpemmemprs";
        int[] indices = {1, 16, 6, 15, 0, 10, 11, 3};
        Arrays.sort(indices);

        StringBuilder builder = new StringBuilder(my_string);

        for (int i = indices.length - 1; i >= 0; i--) {
            builder.deleteCharAt(indices[i]);
        }

        String result = builder.toString();
        Assertions.assertThat(result).isEqualTo("programmers");
    }

    @Test
    @DisplayName("글자 지우기 String builder 메소드 사용")
    @Description("O(N + M)")
    void string_remove_test_using_string_builder_() {

        String my_string = "apporoograpemmemprs";
        int[] indices = {1, 16, 6, 15, 0, 10, 11, 3};

        char[] chars = my_string.toCharArray();
        int length = chars.length;

        // indices 배열을 오름차순으로 정렬
        Arrays.sort(indices);

        // 삭제할 문자의 개수
        int deleteCount = indices.length;

        // 결과 문자 배열 생성
        char[] result = new char[length - deleteCount];

        // 삭제할 인덱스를 제외한 문자들을 결과 배열에 복사
        int sourceIndex = 0;
        int destinationIndex = 0;
        for (int i = 0; i < length; i++) {
            if (destinationIndex < deleteCount && i == indices[destinationIndex]) {
                destinationIndex++;
            } else {
                result[sourceIndex++] = chars[i];
            }
        }

        String string = new String(result);
        Assertions.assertThat(string).isEqualTo("programmers");
    }


}