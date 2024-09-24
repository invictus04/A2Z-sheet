class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set1 = new HashSet<>();
        for(int val: arr1){
            while(!set1.contains(val) && val > 0){
                set1.add(val);
                val /= 10;
            }
        }

        int prefix=0;
        for(int val: arr2){
            while(!set1.contains(val) && val>0){
                val/=10;
            }
            if(val>0){
                prefix = Math.max(prefix,(int) Math.log10(val) + 1);
            }
        }
        return prefix;
    }
}