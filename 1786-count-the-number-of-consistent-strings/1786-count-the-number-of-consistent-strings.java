class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for(Character ch: allowed.toCharArray()){
            hash.put(ch,1);
        }
        int count=0;
        for(int i=0; i<words.length; i++){
            boolean isConsistent = true;
            int j=0;
            while(j<words[i].length()){
                if(!hash.containsKey(words[i].charAt(j++))){
                    isConsistent = false;
                    break;
                } 
            }
            if(isConsistent) count++;
            
        }
        return count;
    }
}