class Solution {
    public int findComplement(int num) {
        if(num == 0) return 1;
        int len = Integer.toBinaryString(num).length();
        int mask = (1<<len) -1;
        return num^mask;
    }
}