class Solution {

    public boolean equalFrequency(String word) {

        int[] freq = new int[26];

        
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        
        for (int i = 0; i < 26; i++) {

            if (freq[i] == 0)
                continue;

            freq[i]--;

            if (allEqual(freq))
                return true;

            freq[i]++;
        }

        return false;
    }

    public boolean allEqual(int[] freq) {

        int expected = 0;

        for (int f : freq) {

            if (f == 0)
                continue;

            if (expected == 0)
                expected = f;

            else if (f != expected)
                return false;
        }

        return true;
    }
}