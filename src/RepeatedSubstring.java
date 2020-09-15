public class RepeatedSubstring {
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).substring(1, 2*s.length()-1).contains(s);
    }

    public static void main(String[] args) {
        RepeatedSubstring substring = new RepeatedSubstring();
        System.out.println(substring.repeatedSubstringPattern("abcabcabcabc"));
    }
}
