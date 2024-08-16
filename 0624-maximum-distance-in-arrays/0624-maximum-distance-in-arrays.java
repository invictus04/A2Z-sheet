class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int smallest = arrays.get(0).get(0);
        int largest = arrays.get(0).get(arrays.get(0).size() - 1);
        int dist = 0;

        for (int i = 1; i < arrays.size(); i++) {
            dist = Math.max(dist, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - smallest));
            dist = Math.max(dist, Math.abs(largest - arrays.get(i).get(0)));
            smallest = Math.min(smallest, arrays.get(i).get(0));
            largest = Math.max(largest, arrays.get(i).get(arrays.get(i).size() - 1));
        }

        return dist;
    }
}