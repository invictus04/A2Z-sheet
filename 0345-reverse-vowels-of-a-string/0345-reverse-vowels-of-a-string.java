class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        Set<Character> indx = new HashSet<>();
        indx.add('a');
        indx.add('A');
        indx.add('e');
        indx.add('E');
        indx.add('i');
        indx.add('I');
        indx.add('o');
        indx.add('O');
        indx.add('u');
        indx.add('U');
        char chArr[] = s.toCharArray();
        int start=0, end = n-1;
        while(start<end){
            while (start < end && !indx.contains(chArr[start])) start++;
            while (start < end && !indx.contains(chArr[end])) end--;
            
            char temp = chArr[start];
            chArr[start] = chArr[end];
            chArr[end] = temp;
            
            start++;
            end--;
        }

        return new String(chArr);






    }
}