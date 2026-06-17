class Solution {
    public String getHint(String secret, String guess) {
     int bulls = 0;
        int cows = 0;
        
        // Array to keep track of the frequency balance of digits 0-9
        int[] counts = new int[10];
        
        for (int i = 0; i < secret.length(); i++) {
            int sDigit = secret.charAt(i) - '0';
            int gDigit = guess.charAt(i) - '0';
            
            if (sDigit == gDigit) {
                bulls++;
            } else {
                // If counts[sDigit] < 0, it means guess has seen this digit before 
                // without a matching bull, so it's a cow.
                if (counts[sDigit] < 0) {
                    cows++;
                }
                // If counts[gDigit] > 0, it means secret has seen this digit before
                // without a matching bull, so it's a cow.
                if (counts[gDigit] > 0) {
                    cows++;
                }
                
                // Track the digit frequencies
                counts[sDigit]++;
                counts[gDigit]--;
            }
        }
        
        return bulls + "A" + cows + "B";
    }   
    
}