class Solution {
    private long helper(long firstHalf, boolean isEven) {
        long resNum = firstHalf;
        if (!isEven) {
            firstHalf /= 10;
        }
        while (firstHalf > 0) {
            resNum = (resNum * 10) + (firstHalf % 10);
            firstHalf /= 10;
        }
        return resNum;
    }

    public String nearestPalindromic(String n) {
        int len = n.length();
        int mid = len / 2;
        boolean isEven = (len % 2 == 0);
        long firstHalf = Long.parseLong(n.substring(0, mid + (isEven ? 0 : 1)));

        ArrayList<Long> possible = new ArrayList<>();

        possible.add(helper(firstHalf, isEven));
        possible.add(helper(firstHalf + 1, isEven));
        possible.add(helper(firstHalf - 1, isEven));
        possible.add((long) Math.pow(10, len - 1) - 1);
        possible.add((long) Math.pow(10, len) + 1);

        long original = Long.parseLong(n);
        long diff = Long.MAX_VALUE;
        long res = Long.MAX_VALUE;

        for (long num : possible) {
            if (num == original)
                continue;
            long currentdiff = Math.abs(num-original);           
            if (currentdiff < diff) {
                diff = currentdiff;
                res = num;
            } else if (currentdiff == diff) {
                res = Math.min(res, num);
            }
        }
        return String.valueOf(res);
    }
}