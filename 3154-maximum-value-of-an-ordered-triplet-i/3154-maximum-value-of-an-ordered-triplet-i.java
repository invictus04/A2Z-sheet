import java.math.BigInteger;

class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        BigInteger maxi = new BigInteger("-1");
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k= j+1; k<n; k++){
                    BigInteger A = BigInteger.valueOf(nums[i]);
                    BigInteger B = BigInteger.valueOf(nums[j]);
                    BigInteger C = BigInteger.valueOf(nums[k]);
                    maxi = maxi.max((A.subtract(B).multiply(C)));
                    System.out.println(maxi);
                }
            }
        }
        return maxi.longValue() < 0 ? 0 : maxi.longValue();
    }
}