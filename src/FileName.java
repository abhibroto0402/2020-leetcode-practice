import java.util.*;

public class FileName {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap<>();

        String res[] = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            if (map.containsKey(names[i])) {
                Integer val = map.get(names[i]);
                StringBuilder sb = new StringBuilder(names[i]);
                sb.append('(');
                sb.append(val);
                sb.append(')');
                while (map.containsKey(sb.toString())) {
                    val++;
                    sb = new StringBuilder(names[i]);
                    sb.append('(');
                    sb.append(val);
                    sb.append(')');
                }
                res[i] = sb.toString();
                map.put(sb.toString(), 1);
                map.put(names[i], val + 1);
            } else {
                res[i] = names[i];
                map.put(names[i], 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] test = {"kaido","kaido(1)","kaido","kaido(1)", "kaido(2)"};
        FileName name = new FileName();
        System.out.println(Arrays.toString(name.getFolderNames(test)));
    }

}
