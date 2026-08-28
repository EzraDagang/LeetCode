import java.util.HashMap;

public class PermutationInString_567 {
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        boolean permutationExist = false;
        HashMap<Character, Integer> s1Frequency = new HashMap<>();
        HashMap<Character, Integer> windowFrequency = new HashMap<>();
        int matches = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (!s1Frequency.containsKey(s1.charAt(i))) s1Frequency.put(s1.charAt(i), 1);
            else s1Frequency.put(s1.charAt(i), s1Frequency.get(s1.charAt(i)) + 1);
        }
        
        for(int right = 0; right < s1.length(); right++){
            if (!windowFrequency.containsKey(s2.charAt(right))) windowFrequency.put(s2.charAt(right), 1);
            else windowFrequency.put(s2.charAt(right), windowFrequency.get(s2.charAt(right)) + 1);
        }

        for(Character key : s1Frequency.keySet()){
            if(!windowFrequency.containsKey(key)) break;
            if(!windowFrequency.get(key).equals(s1Frequency.get(key))) break;
            matches++;
            if(matches == s1Frequency.size()) return true;
        }

        //I stopped here. So basically the idea is that I just have to care about the number of matches, regardless
        //of the order because this is permutation, order doesn't matter. if order does matter, then it is a different
        //matter.

        for(int right = s1.length(); right < s2.length(); right++){
            if()
        }

    }
}

/*
s1Frequency hashmap stores the frequency for each unique character.

 windowHashmap stores the frequency for each unique character in the window.
 */