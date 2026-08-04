public class ValidPalindrome_125 {
    public static boolean isPalindrome(String s) {
        if(s == null) return false;

        s = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();

        if (s.isEmpty()) return true;

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else return false;
        }

        return true;
    }
}




















/*
{

        if (s == null ) return false;

        if (s.isEmpty()) return true;

        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left, right = s.length() / 2;

        //even number of string
        if (s.length() % 2 == 0) {
            left = s.length() / 2 - 1;
        } else {
            left = right;
        }

        //Need to check both > 0 and < .length() for concurrency situations where left will reach -1 first.
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }

        return true;
    }
 */