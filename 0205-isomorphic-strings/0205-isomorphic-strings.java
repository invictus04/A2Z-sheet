class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character, Character> smpp = new HashMap<>();
        for (int i =0; i<s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);
            if(!smpp.containsKey(original)) {
                if(!smpp.containsValue(replacement)){
                    smpp.put(original, replacement);
                } else {
                    return false;
                }
            } else {
                char mppchar = smpp.get(original);
                if(mppchar !=replacement){
                    return false;
                }
            }
        }
            return true;
    }
    
}