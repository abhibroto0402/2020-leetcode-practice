import java.util.HashMap;

public class CowsAndBulls {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> actual = new HashMap<>();
        HashMap<Character, Integer> guessSet = new HashMap<>();
        int Acount=0, Bcount=0;
        for(int i=0; i<secret.length(); ++i){
            char secretChar = secret.charAt(i);
            char guessChar = guess.charAt(i);
            if(secretChar==guessChar){
                ++Acount;
            }else{
                int temp = actual.getOrDefault(secretChar, 0);
                ++temp;
                actual.put(secretChar, temp);
                temp = guessSet.getOrDefault(guessChar, 0);
                ++temp;
                guessSet.put(guessChar, temp);
            }
        }
        System.out.println(guessSet);
        for(Character c: actual.keySet()){
            if(guessSet.containsKey(c)){
                Bcount += Math.min(actual.get(c), guessSet.get(c));
            }

        }

        return Acount+"A"+Bcount+"B";
    }

    public static void main(String[] args) {
        CowsAndBulls cowsAndBulls = new CowsAndBulls();
        System.out.println(cowsAndBulls.getHint("1122", "2211"));
    }
}
