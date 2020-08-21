package thuat_toan_tim_kiem.bai_tap;

public class SearcbyBinary {

    private static int searching(int arr[], int low, int hight, int value) {
        if (hight >= low) {
            int mid = low + (hight - low) / 2;
            if (arr[mid] == value) {
                return mid;
            }
            if (arr[mid] > value)
                return searching(arr, low, mid - 1, value);
            return searching(arr, mid + 1, hight, value);
        }
        return -1;


    }

    public static void main(String[] args) {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        System.out.println(searching(list, 0, 12, 4));
        System.out.println(searching(list, 0, 12, 10));
        System.out.println(searching(list, 0, 12, 200));
    }

}
