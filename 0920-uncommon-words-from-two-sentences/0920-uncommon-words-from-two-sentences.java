class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
       HashMap<String, Integer> count = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        for(String word: s1.split(" ")){
            count.put(word,count.getOrDefault(word,0)+1);
        }
        for(String word: s2.split(" ")){
            count.put(word,count.getOrDefault(word,0)+1);
        }
        for(String word: count.keySet()){
            if(count.get(word) == 1){
                ans.add(word);
            }
        }
        

        String[] arr = ans.toArray(new String[0]); 
        return arr;

    }
}