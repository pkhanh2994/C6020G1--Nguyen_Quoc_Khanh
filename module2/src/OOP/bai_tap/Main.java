package OOP.bai_tap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[]arr=new int[1000000];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*1000000+1);
        }
        StopWatch stopWatch=new StopWatch();
        stopWatch.startTime();
        Arrays.sort(arr);
        stopWatch.endTime();
        System.out.println(stopWatch.getElapsedTime());
    }
}
