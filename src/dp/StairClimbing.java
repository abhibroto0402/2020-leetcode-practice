package dp;

public class StairClimbing {
    public static int numberOfWaysToTop (int top , int maxSteps){
        return computeNumberOfWays(top, maxSteps, new int[top+1]);
    }

    private static int computeNumberOfWays(int a, int maxSteps, int[] numOfWays) {
        if(a<=1) return 1;

        if(numOfWays[a]==0){
            for(int i=1; i<=maxSteps && a-i>=0; i++){
                numOfWays[a]+= computeNumberOfWays(a-i, maxSteps, numOfWays);
            }
        }
        return numOfWays[a];
    }

    public static void main(String[] args) {
        System.out.println(numberOfWaysToTop(4,2));
    }
}
