class Solution {
    public int hammingWeight(int n) {
        // StringBuilder res = new StringBuilder();
        // while(n!=0) {
        //     if(n&1 == 1){
        //         res.append("1");
        //     } else{
        //         res.append("0");
        //     }
        //     n = n>>1;
        // }
        // String str = res.reverse().toString();
        // int binary = Integer.parseInt(str);

        int cnt =0;
        while(n!=0){
            n=n&(n-1);
            cnt++;
        }
        return cnt;

    }
}