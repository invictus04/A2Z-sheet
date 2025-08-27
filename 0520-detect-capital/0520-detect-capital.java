class Solution {
    public boolean detectCapitalUse(String word) {
        String wordSmall = word.toLowerCase();
        String wordLarge = word.toUpperCase();
        if(word.equals(wordSmall)){
            return true;
        }else if(word.equals(wordLarge)){
            return true;
        } else if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            // System.out.println("Inside");
            for(int i=1; i<word.length(); i++){
                if(word.charAt(i) >= 'A' && word.charAt(i) <='Z') return false;
            }
            return true;
        }
       
        return false;
    }
}