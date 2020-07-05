public class KthGrammer {
    public int kthGrammar(int n, int k) {
        String s = helper("0", 1, n);
        return Character.getNumericValue(s.charAt(k-1));
    }

    private String helper(String s, int index, int n) {
        if(index==n)
            return s;
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c=='0')
                sb.append("01");
            else
                sb.append("10");
        }
        return helper(sb.toString(), ++index, n);
    }

    public static void main(String[] args) {
        KthGrammer grammer = new KthGrammer();
        System.out.println(grammer.kthGrammar(3,2));
    }
}
