public class LongestRepeatingCharacterReplacement_424 {
    public static int characterReplacement(String s, int k){

        //=========== SAMPLE SOLUTION ===========//

        int[] charCounts = new int[26];
        int left = 0;
        int maxLength = 0;
        int maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {
            charCounts[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, charCounts[s.charAt(right) - 'A']);

            if ((right - left + 1) - maxFreq > k) {
                charCounts[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
