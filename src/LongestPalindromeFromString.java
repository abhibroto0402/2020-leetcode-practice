import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeFromString {
    public int longestPalindrome(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        boolean flag=false;
        for(char c: s.toCharArray()){
            int count = countMap.getOrDefault(c, 0);
            count++;
            countMap.put(c,count);
        }
        int ans=0;
        for(Character c: countMap.keySet()){
            if(countMap.get(c)%2==1 && !flag){
                flag=true;
                ans+=countMap.get(c);
            }else if(countMap.get(c)%2==0){
                ans+=countMap.get(c);
            }
            else{
                ans+=countMap.get(c)-1;
            }
        }
        return ans;
    }
}
