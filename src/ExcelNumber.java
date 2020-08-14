public class ExcelNumber {
    public int titleToNumber(String s) {
        int sum=0;
        for(int i=0, j=s.length()-1; i<s.length(); ++i, --j){
            sum+= Math.pow(26,j) * (s.charAt(i)-'A'+1);
        }
        return sum;
    }

    public static void main(String[] args) {
        ExcelNumber excelNumber = new ExcelNumber();
        System.out.println(excelNumber.titleToNumber("ZY"));
    }
}
