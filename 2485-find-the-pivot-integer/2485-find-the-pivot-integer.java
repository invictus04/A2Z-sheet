class Solution {
    public int pivotInteger(int n) {
        int totalSum = ((n * (n + 1)) / 2);
        // System.out.println(totalSum);
        int sum=0;
        for(int i=1; i<=n; i++){
            sum += i;
            if(sum == (totalSum-sum+i)) return i;
            System.out.println(sum + ":" +  i + " " + (totalSum - sum + i));
        }
        return -1;
    }
}