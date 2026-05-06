class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ans[] = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                ans[k++] = nums1[i];
                ans[k++] = nums2[j];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                ans[k] = nums1[i];
                i++;
                k++;
            } else {
                ans[k] = nums2[j];
                j++;
                k++;
            }
        }
        //left over nums1 element
        if (i < m) {
            for (int u = i; u < m; u++) {
                ans[k++] = nums1[u];
            }

        }
        //left over nums2 element
        if (j < n) {
            for (int u = j; u < n; u++) {
                ans[k++] = nums2[u];
            }
        }

        for (int l = 0; l < ans.length; l++) {
            nums1[l] = ans[l];
        }
    }
}