class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        if (n == 1)
            return 1;
        TreeMap<Character, Integer> mpp = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            mpp.put(s.charAt(i), mpp.getOrDefault(s.charAt(i), 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Character, Integer> e : mpp.entrySet()) {
            int value = e.getValue();
            if (value % 2 == 0) {
                result += value;
            } else {
                result += value - 1;
            }
        }

        return result < n ? result + 1 : result;
    }
}