import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleRecur {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascal = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        pascal.add(0,temp);
        createPascalTriangleUpto(pascal, 1, rowIndex);
        return pascal.get(rowIndex);
    }

    public void createPascalTriangleUpto(List<List<Integer>> pascal, int startIndex, int endIndex){
        if(startIndex>endIndex)
            return;
        List<Integer> prev = pascal.get(startIndex-1);
        List<Integer> curr = new ArrayList<>();
        for(int i=0;i<=startIndex;++i){
            int sum =0;
            if(i-1>=0){
                sum+=prev.get(i-1);
            }
            if(i<prev.size()){
                sum+=prev.get(i);
            }
            curr.add(i, sum);
        }
        pascal.add(curr);
        createPascalTriangleUpto(pascal, ++startIndex, endIndex);
    }

    public List<Integer> getRowRe(int rowIndex) {
        if(rowIndex==0)
            return new ArrayList<>(Arrays.asList(1));
        if(rowIndex==1)
            return new ArrayList<>(Arrays.asList(1,1));
        List<Integer> list = new ArrayList<>(rowIndex+1);
        list.add(1);
        List<Integer> temp = getRowRe(rowIndex-1);
        for(int i=1; i<rowIndex; ++i){
            list.add(temp.get(i-1)+ temp.get(i));
        }
        list.add(1);
        return list;

    }

    public static void main(String[] args) {
        PascalTriangleRecur pascalTriangleRecur = new PascalTriangleRecur();
        System.out.println(pascalTriangleRecur.getRowRe(4));
    }
}
