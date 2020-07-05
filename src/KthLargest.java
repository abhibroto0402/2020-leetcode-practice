public class KthLargest {
    public static int findKthElementByQuickSelect(int[] arr, int left, int right, int k) {
        if (k >= 0 && k <= right - left + 1) {
            int pos = partition(arr, left, right);
            if (pos - left == k) {
                return arr[pos];
            }
            if (pos - left > k) {
                return findKthElementByQuickSelect(arr, left, pos - 1, k);
            }
            return findKthElementByQuickSelect(arr, pos + 1, right, k - pos + left - 1);
        }
        return 0;
    }
    public static int partition(int[] arr, int l, int r) {
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
        int k = input.length-2;
        System.out.println(findKthElementByQuickSelect(input, 0, input.length-1, k));
    }
}
