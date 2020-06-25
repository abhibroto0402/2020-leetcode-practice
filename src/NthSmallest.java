public class NthSmallest {
    public static int kMin(int [] arr, int k){
        return kMinHelper(arr, 0, arr.length-1, k);
    }

    private static int kMinHelper(int[] arr, int l, int r, int k) {
        if(k>0 && k<= r-l +1){
            int pos= partition(arr, l, r);
            if(pos-l==k-1)
                return arr[pos];
            if(pos-l>k-1)
                return kMinHelper(arr, l, pos-1, k);
            return kMinHelper(arr, pos+1, r, k-pos+l-1);
        }
        return Integer.MAX_VALUE;
    }

    private static int partition(int []arr, int l, int r){
        int pivot =arr[r];
        int i=l;
        for(int j=l;j<r;j++){
            if(arr[j]<=pivot){
                swap(arr, i, j);
                ++i;
            }
        }
        swap(arr,i,r);
        return i;
    }

    private static void swap(int[] arr, int n, int right) {
        int temp = arr[n];
        arr[n]= arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int [] input =  {1,4,3,9,5,8,7,2,6};
        System.out.println(kMin(input, 4));
    }
}
