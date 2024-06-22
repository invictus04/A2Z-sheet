class Solution {
    boolean isPalindrome(String s, int left, int right){
        while(left<=right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    void generate(String s,List<List<String>> ans,List<String> res, int i){
        if(i==s.length()){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int j=i; j< s.length(); j++){
            if(isPalindrome(s,i,j)){
                res.add(s.substring(i,j+1));
                generate(s,ans,res,j+1);
                res.remove(res.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();
        generate(s,ans,res,0);
        return ans;
    }
}