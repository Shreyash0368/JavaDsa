import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing_29 {
    public static class Job {
        int deadline;
        int id;
        int profit;

        public Job (int i, int d, int p) {
            deadline = d;
            id = i;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int jobInfo [][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);
        
        int time = 0;
        int profit = 0;

        for (int i = 0; i < jobs.size(); i++) {
            Job currJob = jobs.get(i);
            if (currJob.deadline > time) {
                System.out.print(currJob.id + " ");
                profit += currJob.profit;
                time++;
            }
        }
        System.out.println();
        System.out.println("max profit is: " + profit);
    }

}
