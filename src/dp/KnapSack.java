package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapSack {

    public int getMaxValue(List<Item> itemsList, int maxWeight ){
        int [] [] valueMat = new int[itemsList.size()][maxWeight+1];
        for(int[] v: valueMat){
            Arrays.fill(v, -1);
        }
        return helper(itemsList, maxWeight, valueMat, itemsList.size()-1);
    }

    private int helper(List<Item> itemsList, int availableCapacity, int[][] valueMat, int k) {
        if(k<0){
            return 0;
        }
        if(valueMat[k][availableCapacity]==-1){
            int withoutCurrItem = helper(itemsList, availableCapacity, valueMat, k-1);
            int withCurrItem = availableCapacity>=itemsList.get(k).weight ? itemsList.get(k).value+
                    helper(itemsList, availableCapacity-itemsList.get(k).weight, valueMat, k-1) : 0;
            valueMat[k][availableCapacity]=Math.max(withCurrItem, withoutCurrItem);
        }
        return valueMat[k][availableCapacity];
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(5,10));
        items.add(new Item(2,5));
        items.add(new Item(3,1));
        items.add(new Item(10,20));
        KnapSack sack = new KnapSack();
        System.out.println(sack.getMaxValue(items, 15));


    }

}

class Item{
    int value;
    int weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
