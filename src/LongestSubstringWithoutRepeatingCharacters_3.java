import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;

        int longestSubstring = 0;
        int left = 0;
        Set<Character> window = new HashSet<>();

        for(int right = 0; right <= s.length() - 1; right++){
               while(window.contains(s.charAt(right))){
                   window.remove(s.charAt(left));
                   left++;
               }

               window.add(s.charAt(right));

               longestSubstring = Math.max(longestSubstring, right - left + 1);
        }

        return longestSubstring;
    }
}

//======================
// FIRST OWN IMPLEMENTATION
//======================

//
//        if (s == null || s.isEmpty()) return 0;
//
//        int left = 0;
//        int longestLengthSubstring = 0;
//
//        for (int right = 0; right <= s.length() - 1; right++) {
//            longestLengthSubstring = Math.max(longestLengthSubstring, right - left + 1);
//
//            while (right + 1 <= s.length() - 1 && s.substring(left, right + 1).indexOf(s.charAt(right + 1)) > -1) {
//                left++;
//            }
//        }
//
//        return longestLengthSubstring;