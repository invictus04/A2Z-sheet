class Solution {

    public static final int[][] DIRECTIONS = {
        { 1, 0 },
        { -1, 0 },
        { 0, 1 },
        { 0, -1 },
    };

    public int[] maxPoints(int[][] grid, int[] queries) {
        int queryCount = queries.length;
        int[] result = new int[queryCount];
        int rowCount = grid.length;
        int colCount = grid[0].length;

        int totalCells = rowCount * colCount;
        int[] thresholdForMaxPoints = new int[totalCells + 1];
        int[][] minValueToReach = new int[rowCount][colCount];

        for (int[] row : minValueToReach) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minValueToReach[0][0] = grid[0][0];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->
            Integer.compare(a[2], b[2])
        );
        minHeap.offer(new int[] { 0, 0, grid[0][0] });
        int visitedCells = 0;
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            thresholdForMaxPoints[++visitedCells] = current[2];

            for (int[] direction : DIRECTIONS) {
                int newRow = current[0] + direction[0];
                int newCol = current[1] + direction[1];
                if (
                    newRow >= 0 &&
                    newRow < rowCount &&
                    newCol >= 0 &&
                    newCol < colCount &&
                    minValueToReach[newRow][newCol] == Integer.MAX_VALUE
                ) {
                    minValueToReach[newRow][newCol] = Math.max(
                        current[2],
                        grid[newRow][newCol]
                    );

                    minHeap.offer(
                        new int[] {
                            newRow,
                            newCol,
                            minValueToReach[newRow][newCol],
                        }
                    );
                }
            }
        }
        for (int i = 0; i < queryCount; i++) {
            int threshold = queries[i];
            int left = 0, right = totalCells;
            while (left < right) {
                int mid = (left + right + 1) >>> 1;
                if (thresholdForMaxPoints[mid] < threshold) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            result[i] = left;
        }

        return result;
    }
}