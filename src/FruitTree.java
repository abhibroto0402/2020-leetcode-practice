public class FruitTree {
    public int totalFruit(int[] tree) {
        if(tree.length<=2) return tree.length;
        int max = 0;
        int first=0;
        int second=1;
        int count =1;
        for(int i=1; i<tree.length; i++){
            if(tree[first]==tree[second]){
                count++;
                second=i+1;
                continue;
            }
            else {
                while (i < tree.length) {
                    if (tree[i] != tree[second]) {
                        if (tree[i] == tree[first]) {
                            first = i;
                            count++;
                            i++;
                        } else {
                            break;
                        }
                    } else {
                        second = i;
                        count++;
                        i++;
                    }
                }
                if(first<second){
                    first=getFirst(first, tree);
                }
                else{
                    first=second+1;
                }
                second=i;
                --i;

            }
            max=Math.max(max, count);
            count=second-first;
        }

        return max;
    }

    private int getFirst(int first, int[] tree) {
        for(int i=first+1;i<tree.length;i++){
            if(tree[i]!=tree[first]){
                break;
            }
            first=i;
        }
        return ++first;
    }

    public static void main(String[] args) {
        FruitTree tree = new FruitTree();
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(tree.totalFruit(arr));
        int [] ar= {0,1,6,6,4,4,6};
        System.out.println(tree.totalFruit(ar));
        int [] ar2= {1,1,6,5,6,6,1,1,1,1};
        System.out.println(tree.totalFruit(ar2));
    }
}
