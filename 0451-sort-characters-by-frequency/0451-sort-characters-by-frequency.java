import java.util.*;
class Solution {
    public String frequencySort(String s) {
        StringBuilder res = new StringBuilder();
        HashMap<Character, Integer> mpp = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            mpp.put(s.charAt(i), mpp.getOrDefault(s.charAt(i),0)+1);
        }
        ArrayList<Map.Entry<Character,Integer>> list = new ArrayList<>(mpp.entrySet());
        Collections.sort(list,(a,b) -> b.getValue().compareTo(a.getValue()));
        for(Map.Entry<Character,Integer> entry: list) {
            int freq = entry.getValue();
            char ch = entry.getKey();
            for(int i=0; i<freq; i++) {
                res.append(ch);
            }
        }
        return res.toString();

    }
}