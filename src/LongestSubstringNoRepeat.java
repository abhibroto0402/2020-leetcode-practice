import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeat {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len<=1) return len;
        Map<Character, Integer> map = new HashMap<>();
        int count=0;
        int max=1;
        for(int i=0;i<len; ++i){
            Character c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,i);
                count++;
            }else{
                max = Math.max(count, max);
                i=map.get(c);
                map= new HashMap<>();
                count=0;
            }
        }
        return Math.max(count, max);
    }

    public static void main(String[] args) {
        LongestSubstringNoRepeat substringNoRepeat = new LongestSubstringNoRepeat();
        System.out.println(substringNoRepeat.lengthOfLongestSubstring("abcabcaa"));
    }
}
