import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int length = s.length();
        if(t.length()> length) return "";
        if(t.length()==1 && s.contains(t)) return t;
        List<Pair<Integer, Character>> filter = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        Set<Character> t_set = new HashSet<>();
        for (char c: t.toCharArray()){
            t_set.add(c);
        }
        for(int i=0; i<length; ++i){
            if(t_set.contains(s.charAt(i))){
                filter.add(new Pair<>(i, s.charAt(i)));
            }
        }
        int min=Integer.MAX_VALUE;
        String res="";
        if(filter.size()==0) return res;
        for(int i=0; i<filter.size()-1;++i){
            Pair<Integer, Character> p = filter.get(i);
            visited.add(p.getValue());
            int startIndex= p.getKey();
            int endIndex=0;
            for(int j=i+1; j<filter.size();++j){
                visited.add(filter.get(j).getValue());
                if(visited.equals(t_set)) {
                    endIndex = filter.get(j).getKey();
                    break;
                }
            }
            String candidate = s.substring(startIndex, endIndex+1);
            if(candidate.length()<min){
                res = candidate;
                min=candidate.length();
            }
            if(endIndex+1>=s.length()) break;
            visited= new HashSet<>();
        }

        return res;
    }


    public static void main(String[] args) {
        MinimumWindowSubstring windowSubstring = new MinimumWindowSubstring();
        System.out.println(windowSubstring.minWindow("ab", "a"));
    }
}