package sort;

public class BubbleSort {
    public static void Sort(int[] array, int length) {
        boolean flag = true;
        for (int i = 0; i < length && flag; i++) {
            flag = false;
            for (int j = length - 1; j > i; j--) {
                if (array[j-1] > array[j]) {
                    swap(array[j-1],array[j]);
                    flag = true;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void swap(int a, int b) {
        var temp = a;
        a = b;
        b = temp;
    }
}
