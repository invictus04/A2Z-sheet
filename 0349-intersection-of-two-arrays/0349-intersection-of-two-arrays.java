class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // int hash[] = new int[10001];
        // HashSet<Integer> ans = new HashSet<>();
        // Arrays.fill(hash,-1);
        
        // for(int i=0; i<nums1.length; i++){
        //     hash[nums1[i]] = 0;
        // }

        // for(int i=0; i<nums2.length; i++){
        //     if(hash[nums2[i]] == 0){
        //         ans.add(nums2[i]);
        //     }
        // }

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int num: nums1){
            set1.add(num);
        }
        for(int num: nums2){
            if(set1.contains(num)){
                set2.add(num);
            }
        }

        int arr[] = new int[set2.size()];
        int i=0;
        for(int ele: set2){
            arr[i++] = ele;
        }
        
        
        return arr;
    }
}