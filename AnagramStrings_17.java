import java.util.Arrays;

public class AnagramStrings_17 {
    public static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        char [] arr1 = s1.toCharArray();
        char [] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr2.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String s1 = "race";
        String s2 = "carf";

        System.out.println(isAnagram(s1, s2));
    }
}
