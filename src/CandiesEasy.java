import java.util.Arrays;

public class CandiesEasy {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        if (candies == 0) return res;

        for (int t = 0; t < num_people * 2 && candies > 0; ++t) {
            for (int i = 0; i < num_people; ++i) {
                int candies_req = ((i % num_people) + 1) + num_people * t;
                if (candies <= candies_req) {
                    res[i % num_people] = res[i % num_people] + candies;
                    candies = 0;
                    break;
                }
                candies -= candies_req;
                res[i % num_people] = res[i % num_people] + candies_req;
            }
        }
        return res;
    }

    public boolean lemonadeChange(int[] bills) {
        int five_counter = 0, ten_counter = 0;
        for (int bill : bills) {
            switch (bill){
                case 5:
                    ++five_counter;
                    break;
                case 10:
                    if (five_counter == 0) return false;
                    --five_counter;
                    ++ten_counter;
                    break;

                case 20:
                    if (five_counter >= 3 || (five_counter >= 1 && ten_counter >= 1)) {
                        if (ten_counter == 0) {
                            five_counter -= 3;
                        } else {
                            ten_counter--;
                            five_counter--;
                        }
                    } else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CandiesEasy easy = new CandiesEasy();
        System.out.println(Arrays.toString(easy.distributeCandies(10, 3)));
        System.out.println(easy.lemonadeChange(new int[] {5,5,5,10,20}));
    }
}
