import java.util.*;

public class HashSetQs_36 {
    public static int union(int[] arr1, int[] arr2) {
        HashSet<Integer> unionSet = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            unionSet.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            unionSet.add(arr2[i]);
        }

        return unionSet.size();
    }

    public static int intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> intersectionSet = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            intersectionSet.add(arr1[i]);
        }

        int count = 0;

        for (int i = 0; i < arr2.length; i++) {
            if (intersectionSet.contains(arr2[i])) {
                count++;
                intersectionSet.remove(arr2[i]);
            }
        }

        return count;
    }

    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> reverseMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            reverseMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if (reverseMap.containsKey(key) == false) {
                return key;
            }
        }

        return null;
    }

    public static void itineraryOfTicket(HashMap<String, String> tickets) {
        String startKey = getStart(tickets);

        System.out.print(startKey);
        for (int i = 0; i < tickets.size(); i++) {
            System.out.print("->" + tickets.get(startKey));
            startKey = tickets.get(startKey);
        }
        System.out.println();
    }

    public static int subarrayWithZeroSum(int[] arr) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0, size = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                size = i + 1;
                continue;
            }
            if (sumMap.containsKey(sum)) {
                size = Math.max(i - sumMap.get(sum), size);
            } else {
                sumMap.put(sum, i);
            }
        }

        return size;
    }

    public static int subarrayWithKSum(int[] arr, int k) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0, size = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                size = i + 1;
            }

            int rem = sum - k;
            if (sumMap.containsKey(rem)) {
                size = Math.max(i - sumMap.get(rem), size);
            }
            if (sumMap.get(sum) == null) {
                sumMap.put(sum, i);
            }
        }

        return size;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5, 6 };
        int[] arr2 = { 2, 5, 6, 7, 8, 9 };

        System.out.println("union set size: " + union(arr1, arr2));
        System.out.println("intersection set size: " + intersection(arr1, arr2));

        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");
        itineraryOfTicket(tickets);

        int[] arr3 = { 15, 2, -2, -8, 1, 7, 10, 5, 5, 2, 4, 4 };
        int[] arr4 = { 2, 5, 10, 5, 2, 3, -5, 4, 3, 7, 6, 13 };

        System.out.println(subarrayWithZeroSum(arr3));
        System.out.println(subarrayWithKSum(arr4, 7));
    }

}
