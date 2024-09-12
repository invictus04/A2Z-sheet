class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while(columnNumber>0){
            int ind = (columnNumber -1)%26;
            ans.insert(0,(char)('A' + ind));
            columnNumber = (columnNumber - 1)/26;
        }
        return ans.toString();
    }
}