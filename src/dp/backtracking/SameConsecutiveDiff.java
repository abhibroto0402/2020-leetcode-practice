package dp.backtracking;

import java.util.*;

public class SameConsecutiveDiff {
    int[] digits = {0,1,2,3,4,5,6,7,8,9};
    List<String> ans = new ArrayList<>();
    public int[] numsSameConsecDiff(int N, int K) {
        if(N==1)
            return digits;
        backtracking(0, N, K, new StringBuilder());
        int [] res = new int [ans.size()];
        for(int i=0; i<ans.size(); ++i){
            res[i]= Integer.parseInt(ans.get(i));
        }
        return res;
    }

    private void backtracking(int pos, int size, int diff, StringBuilder tempAns) {
        if(tempAns.length()==size){
            ans.add(new String(tempAns));
            return;
        }
        for(int i: digits){
            if(canBePlaced(i, pos, diff, tempAns)){
                tempAns.append(i);
                backtracking(pos+1, size, diff, tempAns);
                tempAns.deleteCharAt(tempAns.length()-1);
            }
        }
    }

    public String toGoatLatin(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        String [] words = s.split(" ");
        int index=1;
        for(String word: words){
            if(vowels.contains(word.toLowerCase().charAt(0))){
                sb.append(word);
            }else{
                sb.append(word.substring(1));
                sb.append(word.charAt(0));
            }
            sb.append("ma");
            fill(sb, index);
            index++;
            sb.append(" ");
        }
        return sb.substring(0, sb.length()-1);
    }
    private void fill(StringBuilder sb, int index){
        for(int i=0; i<index ;++i){
            sb.append('a');
        }
    }

    private boolean canBePlaced(int i, int pos, int diff, StringBuilder tempAns) {
        if(pos==0)
            return i!=0;
        int prev = Character.getNumericValue(tempAns.charAt(pos-1));
        return Math.abs(prev-i) == diff;
    }

    public static void main(String[] args) {
        SameConsecutiveDiff consecutiveDiff = new SameConsecutiveDiff();
        System.out.println(Arrays.toString(consecutiveDiff.numsSameConsecDiff(1, 2)));
    }
}
