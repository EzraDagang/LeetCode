public class LongestPalindrome {
    public static String getLongestPalindrome(String s) {

        //This is to check for null/empty string
        if (s == null || s.isEmpty()) return "";

        //this is to store the longest palindrome
        String longest = "";

        for (int i = 0; i < s.length(); i++) { //this is the loop to go through each character in the string

            // Situation 1: Odd length palindromes (Center is a single character)
            String oddPalindrome = expandFromCenter(s, i, i);
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }

            // Situation 2: Even length palindromes (Center is between two characters)
            String evenPalindrome = expandFromCenter(s, i, i + 1);
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }

        return longest;
    }

    // This is your while loop mechanism pulled into a reusable function
    public static String expandFromCenter(String s, int left, int right) {

        // Expand outward as long as characters match and we are inside bounds\
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Return the substring that matched.
        // (left + 1 because the loop decremented left one time too many before exiting)
        return s.substring(left + 1, right);
    }
}
