import java.util.HashMap;

public class HashMapQs_36 {
        public static boolean anagramString(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();

        // storing the different char and their freq in map for str1
        for (int i = 0; i < str1.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
        }

        // comparing the stored values with char of str2 
        for (int i = 0; i < str2.length(); i++) {
            char x = str2.charAt(i);

            if (map.get(x) == null) { 
                return false;
            }
            else {
                if (map.get(x) == 1) { 
                    map.remove(x);
                }
                else { // each time char matches reduce freeq by 1 and remove when freq is 1 
                    map.put(x, map.get(x) - 1); 
                }
            }
        }

        return map.isEmpty(); // if by the end of the loop the map isnt empty then str1 had some extra chars
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 130); 
        map.put("USA", 50); 
        map.put("China", 110); 
        map.put("Germany", 30); 

        // iterating using key (iterator) // or just print the map in sout
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }


        String str1 = "jfe";
        String str2 = "efj";

        System.out.println(anagramString(str1, str2));
        
    }

}
