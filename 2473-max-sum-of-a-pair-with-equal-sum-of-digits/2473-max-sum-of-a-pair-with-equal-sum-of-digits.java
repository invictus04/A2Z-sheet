class Solution {

    public int maximumSum(int[] nums) {
        int result = -1;
        int[] digitMapping = new int[82];

        for (int element : nums) {
            int digitSum = 0;
            for (int currValue = element; currValue != 0; currValue /= 10) {
                int currDigit = currValue % 10;
                digitSum += currDigit;
            }
            if (digitMapping[digitSum] > 0) {
                result = Math.max(result, digitMapping[digitSum] + element);
            }
            digitMapping[digitSum] = Math.max(digitMapping[digitSum], element);
        }

        return result;
    }
}