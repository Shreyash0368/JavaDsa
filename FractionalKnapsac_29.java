import java.util.*;


public class FractionalKnapsac_29 {
    public static void main(String[] args) {
        int [] weight = {10,20,30};
        int [] profit = {60,100,120};

        float [][] goods = new float[weight.length][4];

        for (int i = 0; i < goods.length; i++) {
            goods[i][0] = i; // this is only useful when we want to know which goods were included and which weren't
            goods[i][1] = weight[i];
            goods[i][2] = profit[i];
            goods[i][3] = (weight[i]/(float)profit[i]);            
        }
        
        Arrays.sort(goods, Comparator.comparingDouble(o -> o[3])); // sorting based on weight/profit ratio

        int bag = 50; // bag capacity given 
        float maxProfit = 0;

        for (int i = 0; i < goods.length; i++) {
            
            if (goods[i][1] <= bag) { // if total weight less than max capacity of bag add entire stock to bag
                maxProfit += goods[i][2];
                bag -= goods[i][1];  // remove weight of good from capacity
            }
            else { // else only add the amount of goods which is same as the remaining capacity and calculate the profit accordingly
                maxProfit += (goods[i][2] * bag/(float)goods[i][1]);
                bag = 0;
            }
        }

        System.out.println("max profit: " + maxProfit);
    }

}
