import java.util.*;

public class Permutations {
    public List<int[]> permute(int[] nums) {
        List<int[]> result = new ArrayList<>();
        perm(nums, 0, result);
        return result;
    }

    private void perm(int[] arr, int start, List<int[]> results){
        if(start>=arr.length){
            results.add(arr.clone());
        }else {
            for(int i=start; i<arr.length;i++){
                swap(arr, start, i);
                perm(arr, start+1, results);
                swap(arr, start, i);
            }
        }

    }

    private void swap(int[] arr , int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public List<String> permutationString(String s){
        List<String> results = new ArrayList<>();
        permutations("", s,results);
        return results;
    }

    private void permutations(String prefix, String suffix, List<String> results){
        if(suffix.length()==0) {
            results.add(prefix);
        }
        else{
            for(int i=0; i<suffix.length();i++){
                permutations(prefix+suffix.charAt(i), suffix.substring(0,i)+suffix.substring(i+1), results);
            }
        }

    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int [] arr = {1,2,3,4};
        System.out.print("[");
        for(int[] a: permutations.permute(arr)){
            for(int x: a){
                System.out.print(x);
            }
            System.out.print(",");
        }
        System.out.println("]\n"+permutations.permutationString("abc"));
    }
}
