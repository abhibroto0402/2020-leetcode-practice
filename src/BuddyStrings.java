public class  BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            /*
                At least one character should be repeated if both strings are same
             */
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c: count)
                if (c > 1) return true;
            return false;
        } else {
            /*
                Exactly two characters should differ
             */
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1)
                        first = i; // Store the first unmatched index
                    else if (second == -1)
                        second = i; //Store the second unmatched index
                    else
                        return false;
                }
            }
            /*
                Two different characters should be exchangeable
             */
            return (second != -1 && A.charAt(first) == B.charAt(second) &&
                    A.charAt(second) == B.charAt(first));
        }
    }
    public static void main(String[] args) {
        BuddyStrings buddyStrings = new BuddyStrings();
        System.out.println(buddyStrings.buddyStrings("abab", "abab"));
    }
}
