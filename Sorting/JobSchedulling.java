package Sorting;

import java.util.*;

public class JobSchedulling {
    public static void main(String[] args) {
        Job[] arr = {new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30)};
        int[] out = JobScheduling(arr,arr.length);
        for(int i : out)
            System.out.print(i + "    ");
    }

    static int[] JobScheduling(Job arr[], int n) {
        int p = 0, jobs = 0;
        MyComparator mc = new MyComparator();
        List<Job> l = new ArrayList<>();
        for(Job j : arr)
            l.add(j);
        Collections.sort(l,mc);
        int[] a = new int[101];
        Arrays.fill(a,-1);
        for(Job j : l){
            int ind = j.deadline;
            if(a[ind] == -1){
                a[ind] = j.id;
                p += j.profit;
                jobs++;
            }
            else{
                while(ind > 0 && a[ind] != -1)
                    ind--;
                if(ind <= 0)
                    continue;
                a[ind] = j.id;
                p += j.profit;
                jobs++;
            }
        }
        int[] out = {jobs,p};
        return out;
    }

    static class MyComparator implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            if (o1.profit != o2.profit)
                return o2.profit - o1.profit;
            else
                return
                        o1.deadline - o2.deadline;
        }
    }

    static class Job {
        int id, deadline, profit;

        Job() {
        }

        ;

        Job(int i, int d, int p) {
            this.id = i;
            this.deadline = d;
            this.profit = p;
        }
    }
}
