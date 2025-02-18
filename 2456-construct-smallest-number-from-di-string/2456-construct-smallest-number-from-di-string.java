class Solution {

    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        for (
            int currentIndex = 0, previousIndex = 0;
            currentIndex <= pattern.length();
            ++currentIndex
        ) {
            result.append(1 + currentIndex);

            // Reverse the substring starting from previousIndex when necessary
            if (
                currentIndex == pattern.length() ||
                pattern.charAt(currentIndex) == 'I'
            ) {
                StringBuilder temp = new StringBuilder();
                temp
                    .append(result.substring(0, previousIndex))
                    .append(
                        new StringBuilder(
                            result.substring(previousIndex)
                        ).reverse()
                    );
                result = temp;
                previousIndex = currentIndex + 1;
            }
        }

        // Return the final result as a string
        return result.toString();
    }
}