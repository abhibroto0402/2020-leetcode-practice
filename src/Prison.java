import java.util.*;

public class Prison {
    public int[] prisonAfterNDays(int[] cells, int n) {
        List<Integer> prev = new ArrayList<>();
        List<List<Integer>> allCombo = new ArrayList<>();
        Set<List<Integer>> set  = new HashSet<>();

        for(int i: cells){
            prev.add(i);
        }

        allCombo.add(prev);
        set.add(prev);

        for(int i=0; i<n;++i){
            List<Integer> curr = new ArrayList<>();
            curr.add(0);
            for(int j=1; j<7; ++j){
                if(prev.get(j-1)==1 && prev.get(j+1)==1)
                    curr.add(1);
                else if(prev.get(j-1)==0 && prev.get(j+1)==0)
                    curr.add(1);
                else
                    curr.add(0);
            }
            curr.add(0);
            prev=curr;
            if(!set.add(prev)){
                break;
            }
            allCombo.add(prev);
        }

        if(n<allCombo.size()){
            List<Integer> res =  allCombo.get(n);
            int [] ans = new int [8];
            for(int i=1; i<7; i++){
                ans[i]= res.get(i);
            }
            return ans;
        }
        int index = allCombo.indexOf(prev);
        List<List<Integer>> nonRep = allCombo.subList(index, allCombo.size());
        int res_index = (n-index) % nonRep.size() ;
        List<Integer> res =  nonRep.get(res_index);
        int [] ans = new int [8];
        for(int i=1; i<7; i++){
            ans[i]= res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Prison prison = new Prison();
        int [] arr = {1,0,0,1,0,0,1,0};
        System.out.println(Arrays.toString(prison.prisonAfterNDays(arr, 1000000000)));
    }
}
