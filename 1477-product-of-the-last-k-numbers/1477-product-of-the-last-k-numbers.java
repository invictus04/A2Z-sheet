class ProductOfNumbers {

    ArrayList<Integer> stream = new ArrayList<>();

    public ProductOfNumbers() {
    }
    
    public void add(int num) {
        stream.add(num);
    }
    
    public int getProduct(int k) {
        // System.out.println(stream);
        int len = stream.size();
        // System.out.println(len);
        int ans = 1;
        for(int i = len-k; i<len; i++){
            ans *= stream.get(i);
        }
        return ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */