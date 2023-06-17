public class InidanCoins_29 {
    public static void main(String[] args) {
        int coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        int freq[] = new int[coins.length];
        int count = 0;
        int i = coins.length - 1;
        int amount = 121;

        while (amount > 0) {
            if (amount >= coins[i]) {
                freq[i]++;
                amount -= coins[i];
                count++;
            }
            else {
                i--;
            }
        }

        System.out.println("no of coins used: " + count);

        for (int j = 0; j < freq.length; j++) {
            System.out.println(coins[j] + " : " + freq[j]);
        }
    }

}
