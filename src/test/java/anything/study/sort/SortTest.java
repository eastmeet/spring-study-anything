package anything.study.sort;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class SortTest {

    int[] array = new int[]{5, -2, 3, 25, 21, -55, 27, -30};

    @Test
    @Order(1)
    @DisplayName("버블정렬 O(n^2), Stable, Swapping neighbors")
    void bubbleSort() {

        boolean swapped;
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            swapped = false;
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        Assertions.assertThat(array).isSorted();
    }

    @Test
    @Order(2)
    @DisplayName("선택정렬 O(n^2), Unstable, Identify-and-place")
    void selectionSort() {

        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            int largest = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (array[i] > array[largest]) {
                    largest = i;
                }
            }

            swap(array, largest, lastUnsortedIndex);

        }

        Assertions.assertThat(array).isSorted();
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
