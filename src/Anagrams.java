import java.util.*;

public class Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> compMap = createMap(p);
        System.out.println(s.length());
        System.out.println(p.length());
        for (int i = 0; i < s.length(); i++) {
            if (i + p.length() > s.length()) break;
            String sub = s.substring(i, i + p.length());
            Map<String, Integer> map = createMap(sub);
            if (compMap.equals(map)) {
                result.add(i);
                while (i + p.length() < s.length() && s.charAt(i) == s.charAt(i + p.length())) {
                    result.add(++i);
                }
            } else
                i = i + getUnmatchedIndex(sub, compMap);
        }
        return result;
    }

    private int getUnmatchedIndex(String sub, Map<String, Integer> comp) {
        for (int i = 0; i < sub.length(); i++) {
            if (!comp.containsKey(String.valueOf(sub.charAt(i)))) return i;
        }
        return 0;
    }

    private Map<String, Integer> createMap(String p) {
        Map<String, Integer> tempMap = new HashMap<>();
        for (Character c : p.toCharArray()) {
            if (tempMap.containsKey(c.toString())) {
                tempMap.put(c.toString(), tempMap.get(c.toString()) + 1);
            } else tempMap.put(c.toString(), 1);
        }
        return tempMap;
    }


    public boolean checkAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] a = new int[26];
        int[] b = new int[26];
        for (char c : t.toCharArray()) {
            int index = c - 'a';
            a[index]++;
        }
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            b[index]++;
        }
        return equals(a, b);
    }

    private boolean equals(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.checkAnagram("abab", "baba"));
        int [] heights = {4,1,1,2,5};
        int[] original = new int[heights.length];
        System.arraycopy(heights, 0, original, 0, heights.length);
        Arrays.sort(heights);
        System.out.println(heights[0]);
        System.out.println(original[0]);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (original[i] != heights[i])
                count++;
        }
        System.out.println(count);
    }
}
