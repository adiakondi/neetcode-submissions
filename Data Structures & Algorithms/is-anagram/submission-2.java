class Solution {
    public boolean isAnagram(String s, String t) {
    Hashtable<Character, Integer> tableS = new Hashtable<>();
    Hashtable<Character, Integer> tableT = new Hashtable<>();
        if(s.length() != t.length()) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            char letterS = s.charAt(i);
            char letterT = t.charAt(i);
            tableS.putIfAbsent(letterS, 1); 
            tableS.computeIfPresent(letterS, (key, val) -> val + 1); 

            tableT.putIfAbsent(letterT, 1); 
            tableT.computeIfPresent(letterT, (key, val) -> val + 1); 
        }

        return tableS.entrySet().equals(tableT.entrySet());
    }
}
