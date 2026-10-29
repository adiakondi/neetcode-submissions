class Solution {
    public boolean isPalindrome(String s) {
        String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean isPalindrome = true;
        int left = 0;
        int right = clean.length()-1;

        while(left < right && isPalindrome == true) {
            if(clean.charAt(left) != clean.charAt(right)) {
                isPalindrome = false;
            }
            else{
                left++;
                right--;
            }
        }
        return isPalindrome;
    }
}
