import java.util.*;

public class SpecialSortString {
    public String customSortString(String s, String t) {
        int len = t.length();
        if(len==0) return t;
        Set<Character> dict = new HashSet<>();
        for(char c: s.toCharArray()){
            dict.add(c);
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length();++i){
            char sc = s.charAt(i);
            for (char tc: t.toCharArray()){
                if(sc==tc)
                    sb.append(sc);
            }
        }
        for(char c: t.toCharArray()){
            if(!dict.contains(c))
                sb.append(c);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        SpecialSortString sortString = new SpecialSortString();
        System.out.println(sortString.customSortString("cba", "abcd"));
    }
}
