package dp;

public class MinCostTicket {
    public int mincostTickets(int[] days, int[] costs) {
        int [] dp = new int [days[days.length-1]+1];
        int index =0;
        dp[0]=0;
        for(int i=1; i<dp.length;++i){
            if(days[index]==i){
                int one = dp[i-1]+ costs[0];
                int seven = dp[Math.max(0, i-7)] + costs[1];
                int thirty = dp[Math.max(0, i-30)] + costs[2];
                dp[i]= Math.min(one, Math.min(seven, thirty));
                index++;
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        MinCostTicket costTicket = new MinCostTicket();
        System.out.println(costTicket.mincostTickets(new int[]{1,4,6,7,8,20},
                new int[] {2,7,15}));
    }
}
