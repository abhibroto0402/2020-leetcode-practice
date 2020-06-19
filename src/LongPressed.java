import java.util.*;

public class LongPressed {

    class Node{
        int num;
        char c;
        Node(int num, char c){
            this.c=c;
            this.num=num;
        }
    }

    public boolean isLongPressedName(String name, String typed) {
        List<Node> typ_grp = groupify(typed);
        List<Node> name_grp = groupify(name);
        if(typ_grp.size()!=name_grp.size()) return false;
        for(int i=0; i<typ_grp.size();i++){
            Node t_node = typ_grp.get(i);
            Node n_node = name_grp.get(i);
            if(t_node.num<n_node.num|| t_node.c!=n_node.c)
                return false;
        }
        return true;

    }

    private List<Node> groupify(String s){
        List<Node> result = new ArrayList<>();
        for(int i=0; i<s.length();i++){
            int count =1;
            for(int j=i+1; j<s.length();j++){
                if(s.charAt(i)!=s.charAt(j)){
                    break;
                }
                count++;
                i=j;
            }
            result.add(new Node(count,s.charAt(i)));
        }

        return result;
    }
    public static void main(String[] args) {
        LongPressed longPressed = new LongPressed();
        System.out.println(longPressed.isLongPressedName("alex","aaleex"));
        System.out.println(longPressed.isLongPressedName("saeed","ssaaedd"));
        System.out.println(longPressed.isLongPressedName("leelee","lleeelee"));
        System.out.println(longPressed.isLongPressedName("laiden","laiden"));
        System.out.println(longPressed.isLongPressedName("xnhtq","xhhttqq"));
        System.out.println(longPressed.isLongPressedName("pyplrz","ppyypllr"));
    }
}
