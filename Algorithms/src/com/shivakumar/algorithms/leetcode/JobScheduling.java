package com.shivakumar.algorithms.leetcode;
import java.util.Arrays;
import java.util.TreeMap;

class JobScheduling {
    private class Job{
        int start;
        int end;
        int value;

        Job(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
    private boolean isJobsOverlap(Job j1, Job j2){
        if ( j1.start < j2.start ){
            if(j1.end > j2.start) return true ;
            else return false ;
        }else{
            if(j2.end > j1.start) return true ;
            else return false ;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        Job[] jobs = new Job[startTime.length] ;

        for(int i = 0; i<startTime.length; i++){
            jobs[i] = new Job(startTime[i],endTime[i], profit[i]);
        }

        Arrays.sort(jobs,(a,b)-> a.end - b.end );
        TreeMap<Integer,Integer> dp = new TreeMap<>();
        dp.put(0,0);
        for(int i=0;i<jobs.length;i++){
            int val = jobs[i].value + dp.floorEntry(jobs[i].start).getValue();
            System.out.println(dp);
            if(val > dp.lastEntry().getValue()){
                dp.put(jobs[i].end,val);
            }
            System.out.println(dp);
            System.out.println("----------");
        }


        return dp.lastEntry().getValue();
    }

    public static void main(String[] args) {
        JobScheduling js = new JobScheduling();
        int[] start = new int[]{1, 2, 3, 3};
        int[] end = new int[]{3, 4, 5, 6};
        int[] profit = new int[]{50, 10, 40, 70};

        int val = js.jobScheduling(start, end, profit);
        System.out.println(val);
    }

}