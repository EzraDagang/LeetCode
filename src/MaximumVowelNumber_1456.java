/*
return the maximum number of vowel letters in substring of s with length k.
 */


public class MaximumVowelNumber_1456 {
    public static int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int currentCount = 0;

        for(int i = 0; i <= k - 1; i++){
            if(vowels.indexOf(s.charAt(i)) != -1) currentCount++;
        }

        int maxCount = currentCount;

        for(int i = 0 + k; i <= s.length() - 1; i++){
            if(vowels.indexOf(s.charAt(i - k)) != -1) currentCount -= 1;

            if(vowels.indexOf(s.charAt(i)) != -1) currentCount++;

            if(currentCount > maxCount) maxCount = currentCount;
        }

        return maxCount;
    }
}
