import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        // create an array of int of same length as s
        // start iteration over s with i,j=0 j keeps moving
        // update array1 with the array[j-1]+1 for every s[i]=s[j]
        //when s[i]!=j i=j change++
        // change <2 keep moving forward for every s[i]==s[j] update array[j] = ++count
        // when change == 2 array[j]= j-i+1 change =0
        // return array[n]
        int len = s.length();
        if (len <= 2) return len;
        int max = 0;
        int diff1 = 0;
        int diff2 = -1;
        int start = 0;
        int j=0;
        for (j = 0; j < len; ++j) {
            if (s.charAt(j) != s.charAt(diff1)) {
                if (diff2 != -1 && s.charAt(j) != s.charAt(diff2)) {
                    max = Math.max(max, j - start);
                    start = Math.min(diff1, diff2) + 1;
                    diff1 = Math.max(diff1, diff2);
                }
                diff2 = j;
            } else
                diff1 = j;
        }
        return Math.max(max, j - start);
    }

    public static void main(String[] args) {
        LongestSubstringTwoDistinct substringTwoDistinct = new LongestSubstringTwoDistinct();
        int x = substringTwoDistinct.lengthOfLongestSubstringTwoDistinct("eceba");
        System.out.println(x);
    }
}
