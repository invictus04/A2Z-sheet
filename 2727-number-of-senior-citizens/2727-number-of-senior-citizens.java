class Solution {
    public int countSeniors(String[] details) {
        int cnt=0;
        for(int i=0; i<details.length; i++) {
            String ans = details[i].substring(11,13);
            int age = Integer.parseInt(ans);
            // int age = (details[i].charAt(11)-'0')*10 + details[i].charAt(12)-'0';
            // System.out.print(age + " ");
            if(age>60){
              cnt++;
            } 
        }
    return cnt;
    }
}