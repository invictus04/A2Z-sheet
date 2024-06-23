class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i>=0; i--) {
            if(digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int arr [] = new int[digits.length+1];
        int len = 1;
        if(digits[0] == 0) {
            arr[0] = 1;
        }
        arr[len++] = 0;
        return arr;

    }
}