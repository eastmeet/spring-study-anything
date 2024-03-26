package anything.study.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortTest {

    @Test
    void bubbleSort() {

        int[] array = new int[]{5, -2, 3, 25, 21, -55, 27, -30};

        boolean swapped;
        for (int i = array.length - 1; i > 0; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }

    private static void swap(int[] array, int j) {
        int temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
    }


}
