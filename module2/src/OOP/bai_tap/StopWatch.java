package OOP.bai_tap;


import java.util.Arrays;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    void startTime() {
        startTime = System.currentTimeMillis();
    }

    void endTime() {
        endTime = System.currentTimeMillis();
    }

    long getElapsedTime() {
        return endTime - startTime;
    }

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