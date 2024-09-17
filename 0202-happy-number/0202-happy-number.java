class Solution {
    public boolean isHappy(int n) {
        // if(n>=0 && n<=2) return false;
        if(n == 1) return true;
        HashSet<Integer> seen = new HashSet<>();

        while(n != 1 && !seen.contains(n)){
            seen.add(n);    
            int sum=0;
            while(n>0){      
                int digit = n%10;
                sum+=digit*digit;
                n = n/10;
            }
            n = sum;
        }    
        
    return  n==1;

    }
}