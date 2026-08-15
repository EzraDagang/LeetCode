public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static int lengthOfLongestSubstring(String s) {

        if(s == null||s.isEmpty()) return 0;

        int left = 0;
        int longestLengthSubstring = 0;

        for (int right = 0; right <= s.length() - 1; right++){
            longestLengthSubstring = Math.max(longestLengthSubstring, right - left + 1);

            while( right + 1 <= s.length() - 1 && s.substring(left, right + 1).indexOf(s.charAt(right + 1)) > -1){
                left++;
            }
        }

        return longestLengthSubstring;
    }
}