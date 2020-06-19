public class JumpsGreedy {
    public boolean canJump(int[] nums) {
        int index = nums.length-1;
        boolean [] flags = new boolean[index+1];
        flags[index] = true;
        int lastTrueIndex= index;
        --index;
        while (index>=0){
            if(index+nums[index]>=lastTrueIndex){
                flags[index]=true;
                lastTrueIndex=index;
            }
            else
                flags[index]=false;
            index--;

        }
        return flags[0];
    }

    public static void main(String[] args) {
        JumpsGreedy greedy = new JumpsGreedy();
        int[] arr = {2,3,1,1,4};
        System.out.println(greedy.canJump(arr));
    }
}
