public class DroneFlight {
    public int calcDroneMinEnergy(int[][] route) {
        int largestEnergyDeficit = 0;
        int energyBalance = 0;

        for(int i=1; i< route.length;++i){
            energyBalance = energyBalance + (route[i-1][2] - route[i][2]);
            if(energyBalance < largestEnergyDeficit){
                largestEnergyDeficit= energyBalance;
            }
        }
        return Math.abs(largestEnergyDeficit);
    }

    public static void main(String[] args) {
        DroneFlight flight = new DroneFlight();
        int [] [] arr ={
                {0,   2, 10},
                {3,   5,  0},
                {9,  20,  6},
                {10, 12, 9},
                {10, 10,  8}
        };
        int ans= flight.calcDroneMinEnergy(arr);
        System.out.println(ans);
    }
}
