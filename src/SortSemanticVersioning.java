import java.util.*;

public class SortSemanticVersioning {
    public static void main(String[] args) {
        List<String> versions = new ArrayList<>();
        Random random = new Random();
        for(int i=0; i<10; ++i){
            versions.add(random.nextInt(3)+"."+random.nextInt(100)+"."+random.nextInt(100));
        }
        System.out.println(versions);

        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
        for(String str: versions){
            maxH.add(Integer.valueOf(str.substring(0,str.indexOf('.'))));
        }
        List<String> sorted = new ArrayList<>();
        for(int i=0; i<versions.size();++i){
            sorted.add(i, maxH.poll() +".");
        }
        System.out.println(sorted);
        for(String str: versions){
            maxH.add(Integer.valueOf(str.substring(str.indexOf('.')+1, str.lastIndexOf('.'))));
        }
        for(int i=0; i<versions.size();++i){
            sorted.add(i, sorted.get(i)+ maxH.poll()+".");
        }

        for(String str: versions){
            maxH.add(Integer.valueOf(str.substring(str.lastIndexOf('.')+1)));
        }
        for(int i=0; i<versions.size();++i){
            sorted.add(i, sorted.get(i)+ maxH.poll());
        }
        System.out.println(sorted);
    }
}
