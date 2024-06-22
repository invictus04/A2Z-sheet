class Solution {
    public void generate(List<String> ans, String digits, StringBuilder temp, HashMap<Character,String> mpp, int ind){
        if(ind == digits.length()){
            ans.add(temp.toString());
            return;
        }
        String letters = mpp.get(digits.charAt(ind));
        for(char letter: letters.toCharArray()){
            temp.append(letter);
            generate(ans,digits,temp,mpp,ind+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0 || digits == null){
            return ans;    
        }
        HashMap<Character, String> mpp = new HashMap<>();
        mpp.put('2',"abc");
        mpp.put('3',"def");
        mpp.put('4',"ghi");
        mpp.put('5',"jkl");
        mpp.put('6',"mno");
        mpp.put('7',"pqrs");
        mpp.put('8',"tuv");
        mpp.put('9',"wxyz");
        generate(ans, digits, new StringBuilder(), mpp, 0);
        return ans;
    }
}