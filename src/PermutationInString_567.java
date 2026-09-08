import java.util.HashMap;

public class PermutationInString_567 {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> s1Frequency = new HashMap<>();
        HashMap<Character, Integer> windowFrequency = new HashMap<>();
        int matches = 0;

        for (int i = 0; i < s1.length(); i++) {
            char newChar = s1.charAt(i);
            if (!s1Frequency.containsKey(newChar)) s1Frequency.put(newChar, 1);
            else s1Frequency.put(newChar, s1Frequency.get(newChar) + 1);
        }

        for (int right = 0; right < s1.length(); right++) {
            char newChar = s2.charAt(right);

            if (!windowFrequency.containsKey(newChar)) {
                windowFrequency.put(newChar, 1);
            } else {
                windowFrequency.put(newChar, windowFrequency.get(newChar) + 1);
            }
        }

        for (Character c : s1Frequency.keySet()) {
            if (s1Frequency.get(c).equals(windowFrequency.get(c))) {
                matches++;
            }
        }

        if (matches == s1Frequency.size()) {
            return true;
        }

        for (int right = s1.length(); right < s2.length(); right++) {

            char newChar = s2.charAt(right);
            char removeChar = s2.charAt(right - s1.length());

            // ----- Remove old character -----

            if (s1Frequency.containsKey(removeChar) &&
                    windowFrequency.get(removeChar).equals(s1Frequency.get(removeChar))) {
                // Was this character matching before removal?
                matches--;
            }

            windowFrequency.put(removeChar, windowFrequency.get(removeChar) - 1);

            if (s1Frequency.containsKey(removeChar) &&
                    windowFrequency.get(removeChar).equals(s1Frequency.get(removeChar))) {
                // does this character match after removal?
                matches++;
            }

            // ----- Add new character -----

            // Was this character matching before addition?
            if (s1Frequency.containsKey(newChar) && s1Frequency.get(newChar).equals(windowFrequency.get(newChar))) {
                matches--;
            }

            if (!windowFrequency.containsKey(newChar)) {
                windowFrequency.put(newChar, 1);
            } else {
                windowFrequency.put(newChar, windowFrequency.get(newChar) + 1);
            }

            if (s1Frequency.containsKey(newChar) && s1Frequency.get(newChar).equals(windowFrequency.get(newChar))) {
                // Does it match after addition?
                matches++;
            }

            if (matches == s1Frequency.size()) return true;

        }

        return false;
    }
}

/*
s1Frequency hashmap stores the frequency for each unique character.

 windowHashmap stores the frequency for each unique character in the window.
 */