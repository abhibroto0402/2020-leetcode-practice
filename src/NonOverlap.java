import java.util.Arrays;
import java.util.Comparator;

public class NonOverlap {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <2) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        int [] prev = intervals[0];
        int count=0;
        for(int i=1; i<intervals.length;++i){
            if(intervals[i][0]< prev[1]){
                if(intervals[i][1] < prev[1])
                    prev= intervals[i];
                count++;
            }
            else
                prev = intervals[i];
        }
        return count;
    }


    public static void main(String[] args) {
        int [] [] matrix= {
                {1,2},
                {4,5},
                {1,3},
                {2,3}
        };
        NonOverlap overlap = new NonOverlap();
        System.out.println(overlap.eraseOverlapIntervals(matrix));
    }

}
