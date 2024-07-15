class Solution {
public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        HashMap<Character, Integer> mp = new HashMap<>();

        int ans = Integer.MAX_VALUE;
        int start = 0;
for (char x : t.toCharArray())
            mp.put(x, mp.getOrDefault(x, 0) + 1);

        int count = mp.size();

        int i = 0, j = 0;

        while (j < s.length()) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) - 1);
            if (mp.get(s.charAt(j)) == 0)
                count--;

            if (count == 0) {
                while (count == 0) {
                    if (ans > j - i + 1) {
                        ans = j - i + 1;
                        start = i;
                    }
                    mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
                    if (mp.get(s.charAt(i)) > 0)
                        count++;

                    i++;
                }
            }
            j++;
        }
        if (ans != Integer.MAX_VALUE)
            return s.substring(start, start + ans);
        else
            return "";
    }
}