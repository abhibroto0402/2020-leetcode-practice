package dp.backtracking;

import java.util.LinkedList;
import java.util.Queue;

public class CombinationIterator {
    Queue<String> queue = new LinkedList<>();
    public CombinationIterator(String characters, int combinationLength) {
        backtracking(characters, combinationLength, 0, new StringBuilder());
    }

    private void backtracking(String s, int k, int index, StringBuilder temp) {
        if(temp.length()==k){
            queue.add(new String(temp));
        }
        for(int i=index; i<s.length();++i){
            temp.append(s.charAt(i));
            backtracking(s, k, i+1, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public String next() {
       return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("chp", 1);
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.hasNext());
    }
}
