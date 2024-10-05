class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        int arr[][] = new int[numRows][numRows];

        for(int i=0; i<numRows; i++){
            List<Integer> ans = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(i==j || j==0){
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                }
                ans.add(arr[i][j]);
            }
            pascal.add(ans);
        }
        return pascal;
    }
}