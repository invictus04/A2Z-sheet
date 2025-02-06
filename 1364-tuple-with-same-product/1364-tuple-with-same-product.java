class Solution {

    public int tupleSameProduct(int[] nums) {
        int numsLength = nums.length;

        List<Integer> pairProducts = new ArrayList<>();

        int totalNumberOfTuples = 0;

        // Iterate over nums to calculate all pairwise products
        for (int firstIndex = 0; firstIndex < numsLength; firstIndex++) {
            for (
                int secondIndex = firstIndex + 1;
                secondIndex < numsLength;
                secondIndex++
            ) {
                pairProducts.add(nums[firstIndex] * nums[secondIndex]);
            }
        }

        Collections.sort(pairProducts);

        int lastProductSeen = -1;
        int sameProductCount = 0;

        // Iterate over pairProducts to count how many times each product occurs
        for (
            int productIndex = 0;
            productIndex < pairProducts.size();
            productIndex++
        ) {
            if (pairProducts.get(productIndex) == lastProductSeen) {
                // Increment the count of same products
                sameProductCount++;
            } else {
                // Calculate how many pairs had the previous product value
                int pairsOfEqualProduct =
                    ((sameProductCount - 1) * sameProductCount) / 2;

                totalNumberOfTuples += 8 * pairsOfEqualProduct;

                // Update lastProductSeen and reset sameProductCount
                lastProductSeen = pairProducts.get(productIndex);
                sameProductCount = 1;
            }
        }

        // Handle the last group of products (since the loop ends without adding
        // it)
        int pairsOfEqualProduct =
            ((sameProductCount - 1) * sameProductCount) / 2;
        totalNumberOfTuples += 8 * pairsOfEqualProduct;

        return totalNumberOfTuples;
    }
}
