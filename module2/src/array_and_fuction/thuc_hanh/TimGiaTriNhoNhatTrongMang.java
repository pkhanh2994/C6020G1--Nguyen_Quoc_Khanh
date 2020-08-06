package array_and_fuction.thuc_hanh;
public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        System.out.println("The smallest element in the array is:"+"\t" + minValue(arr)+"\tat position:\t"+position(arr));
    }
    public static int minValue(int[] array){
        int min=array[0];

        for(int i=1;i<array.length-1;i++){
            if(min>array[i]){
                min=array[i];

            }
        }
        return min;
    }
    public static int position(int[] array1){
        int min1=array1[0];
        for(int i=1;i<array1.length-1;i++){
            if(min1>array1[i]){
                return i;

            }
        }
        return -1;
    }

}
