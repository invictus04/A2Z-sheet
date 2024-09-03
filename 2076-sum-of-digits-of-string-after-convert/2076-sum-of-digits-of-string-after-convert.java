class Solution {
    public int getLucky(String s, int k) {
     int res = 0;
     for(int i=0; i<s.length(); i++){
        int num = s.charAt(i)-'a' + 1;
         while (num > 0) {
            res += num % 10;
            num /= 10;
        }
     }
    
    for(int i=1; i<k; i++){
        int digitSum=0;
        while(res>0){
            digitSum += res%10;
            res /= 10;
        }
        res = digitSum;
    }
    return res;
    }
}