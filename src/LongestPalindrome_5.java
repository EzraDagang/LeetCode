/*The logical steps of this question.

- create the basic mechanism of charAt(left) == charAt(right)
- include the checks for left >=0 && right < .length() to prevent out of bounds in mechanism
- Then, since the question wants to find "ANY" palindrome inside the string, then have to loop through EACH character in the string
- But, there are 2 possible cases for a palindrome:
    # Even palindrome with center between 2 characters (left = center first half, right = center second half)
    # Odd palindrome with center is 1 character (left = center - 1, right = center + 1)
- Then, since I have to return the longest palindrome need to have a:
    # temp variable to store the palindrome at the specific center
    # variable to store the longest palindrome
    # checking between temp and longest variable
- If null and empty string, return "".
 */

public class LongestPalindrome_5 {
    public static String getLongestPalindrome(String s) {
        if (s.isEmpty()) return s;

        String evenPalindrome, oddPalindrome, longestPalindrome = "";
        int left, right;

        for (int i = 0; i < s.length(); i++) {

            oddPalindrome = getPalindrome(s, i, i);

            if (oddPalindrome.length() > longestPalindrome.length())
                longestPalindrome = oddPalindrome;

            evenPalindrome = getPalindrome(s, i, i + 1);

            if (evenPalindrome.length() > longestPalindrome.length())
                longestPalindrome = evenPalindrome;
        }

        return longestPalindrome;
    }

    public static String getPalindrome(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }


//    {
//
//        if (s == null || s.isEmpty()) return "";
//
//        String longest = "", stringRange = "";
//
//        for (int i = 0; i < s.length(); i++) {
//            //if charAt(i) is the center of an odd palindrome
//            int left = i - 1, right = i + 1;
//
//            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//                left--;
//                right++;
//            }
//
//            stringRange = s.substring(left + 1, right);
//
//            if (stringRange.length() > longest.length()) {
//                longest = stringRange;
//            }
//
//            //If charAt(i) is the first center half of an even palindrome
//            left = i;
//            right = i + 1;
//
//            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//                left--;
//                right++;
//            }
//
//            stringRange = s.substring(left + 1, right);
//
//            if (stringRange.length() > longest.length()) {
//                longest = stringRange;
//            }
//        }
//
//        return longest;
//    }
    //=============================
    // Simplified & Reduced Code Duplication Version
    //=============================

//        //This is to check for null/empty string
//        if (s == null || s.isEmpty()) return "";
//
//        //this is to store the longest palindrome
//        String longest = "";
//
//        for (int i = 0; i < s.length(); i++) { //this is the loop to go through each character in the string
//
//            // Situation 1: Odd length palindromes (Center is a single character)
//            String oddPalindrome = expandFromCenter(s, i, i);
//            if (oddPalindrome.length() > longest.length()) {
//                longest = oddPalindrome;
//            }
//
//            // Situation 2: Even length palindromes (Center is between two characters)
//            String evenPalindrome = expandFromCenter(s, i, i + 1);
//            if (evenPalindrome.length() > longest.length()) {
//                longest = evenPalindrome;
//            }
//        }
//
//        return longest;
//    }
//

//    public static String expandFromCenter(String s, int left, int right) {
//
//        // Expand outward as long as characters match and we are inside bounds\
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            left--;
//            right++;
//        }
//
//        // (left + 1 because the loop decremented left one time too many before exiting)
//        return s.substring(left + 1, right);
//    }
}
