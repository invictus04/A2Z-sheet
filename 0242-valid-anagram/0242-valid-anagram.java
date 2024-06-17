import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap <Character, Integer> mpp = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            mpp.put(s.charAt(i), mpp.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0; i<t.length(); i++){
            mpp.put(t.charAt(i), mpp.getOrDefault(t.charAt(i),0)-1);
        }
        
        for(int val: mpp.values()){
            if(val !=0) return false;
        }
        return true;
        
    }
}