public class BubbleSort {


    public static void sort1(int arr[], int n) {
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((arr[j] > arr[j + 1])) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }

        }
    }

    public static void printArr(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");

        }
    }

    public static void main(String[] args) {
        int arr[] = {8, 5, 7, 4, 2, 9};
        int n = arr.length;
        sort1(arr, n);
        printArr(arr, n);
    }

}


