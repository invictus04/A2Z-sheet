class Solution {
    public int minimumPushes(String word) {
        int freq [] = new int[26];
        int push =0;
        int cnt=0;

       for(char ch: word.toCharArray()){
        freq[ch -'a']++;
       }

        Arrays.sort(freq);
        for(int i=25; i>=0; i--) {
            if(freq[i] == 0) break;
            push += (freq[i] * ((cnt/8)+1));
            cnt++;
        }
        
        return push;

    }
}