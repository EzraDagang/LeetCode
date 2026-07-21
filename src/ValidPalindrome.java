public class ValidPalindrome {
    public static boolean isPalindrome(String s) {

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
}
