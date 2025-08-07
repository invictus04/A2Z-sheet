class Solution {
    public int hammingDistance(int x, int y) {
        int ham = x^y;
        return Integer.bitCount(ham);
    }
}