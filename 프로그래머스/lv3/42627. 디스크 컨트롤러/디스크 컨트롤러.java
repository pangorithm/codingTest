import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        ArrayList<Integer[]> jobList = new ArrayList<>();
        for(int i = 0; i < jobs.length; i++){
            Integer[] arr = new Integer[2];
            arr[0] = jobs[i][0];
            arr[1] = jobs[i][1];
            jobList.add(arr);
        }
        Collections.sort(jobList, (j1, j2) -> j1[0] - j2[0]);
        
        int answer = 0;
        int time = 0;
        while(jobList.size() > 0){
            ArrayList<Integer[]> list = new ArrayList<>();
            for(int i = 0; i < jobList.size(); i++){                
                if(jobList.get(i)[0] > time){
                    break;
                } else {
                    list.add(jobList.get(i));
                }
            }
            if(list.size() == 0){
                time = jobList.get(0)[0];
            } else {
                Integer[] minJob = new Integer[2];
                minJob[1] = Integer.MAX_VALUE;
                for(int i = 0; i < list.size(); i++){
                    Integer[] job = list.get(i);
                    if(minJob[1] > job[1]){
                        minJob = job;
                    }
                }
                jobList.remove(minJob);
                answer += time + minJob[1] - minJob[0];
                time += minJob[1];
            }
        }
        
        return answer / jobs.length;
    }
}