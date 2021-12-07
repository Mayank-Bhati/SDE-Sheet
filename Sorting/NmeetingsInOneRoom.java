package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NmeetingsInOneRoom {
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        System.out.println(maxMeetings(start,end,start.length));
    }
    public static int maxMeetings(int start[], int end[], int n) {
        myCmparator mc =  new myCmparator();
        int ans = 1;
        ArrayList<meeting> data = new ArrayList<>();
        for(int i = 0; i < n;i++){
            data.add(new meeting(i,start[i],end[i]));
        }
        Collections.sort(data,mc);
        int prev = data.get(0).end;
        for(int i = 1; i < data.size(); i++){
            if(data.get(i).start > prev){
                ans++;
                prev = data.get(i).end;
            }
        }
        return ans;
    }
     static class myCmparator implements Comparator<meeting> {

        @Override
        public int compare(meeting o1, meeting o2) {
            if(o1.end != o2.end)
                return o1.end - o2.end;
            else
                return o1.pos - o2.pos;
        }
    }
    static class  meeting{
        int pos, start, end;
        meeting(int pos, int start, int end){
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }
}
