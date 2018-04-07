import sort.BubbleSort;

public class Main {
    int[] array = {2,3};

    public static void main(String[] args) {
        //int[] array = {0,4,5,3,6,1,7,2};
        //BubbleSort.Sort(array,array.length);
        Main main = new Main();
        System.out.println(main.array[0]);
        Main.Test(main);
        System.out.println(main.array[0]);
    }

    public static void Test(Main main) {
        main.array[0] = 5;
    }
}
