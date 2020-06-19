import java.util.HashSet;
import java.util.Set;

public class Rotatated {
    public int rotatedDigits(int N) {
        int count=0;
        int [] arr = new int[]{0, 1, 8, 2, 5, 6, 9};
        Set<Integer> validDigits = new HashSet<>();
        for(int a: arr){
            validDigits.add(a);
        }
        arr = new int[] {2,5,6,9};
        Set<Integer> rotable = new HashSet<>();
        for (int a: arr){
            rotable.add(a);
        }
        for(int i=1; i<=N; i++){
            int temp =i;
            boolean flag = false;
            while(temp!=0){
                int digit = temp%10;
                if(!validDigits.contains(digit)){
                    flag=false;
                    break;
                }
                if(rotable.contains(digit)) flag =true;
                temp=temp/10;
            }
            if(flag) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Rotatated rotatated = new Rotatated();
        System.out.println(rotatated.rotatedDigits(10));

        String s = "test.email+alex@leetcode.com";
        System.out.println(s.replace(".",""));
    }
}
