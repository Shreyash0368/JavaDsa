import java.util.*;

public class ContainerWithMostWater_24 {
    public static int ContainerWithMostWater(ArrayList<Integer> array) {
        int leftWall = 0, rightWall = array.size() - 1;
        int waterStored = Math.min(array.get(leftWall), array.get(rightWall)) * (rightWall - leftWall);
        int maxCap = waterStored;

        while (leftWall < rightWall) {
            if (array.get(leftWall) <= array.get(rightWall)) {
                leftWall++;
            }
            else {
                rightWall--;
            }
            waterStored =  Math.min(array.get(leftWall), array.get(rightWall)) * (rightWall - leftWall);
            maxCap = Math.max(waterStored, maxCap);
        }

        return maxCap;
    }

    public static void main(String[] args) {       
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(ContainerWithMostWater(height));
        
    }
}
