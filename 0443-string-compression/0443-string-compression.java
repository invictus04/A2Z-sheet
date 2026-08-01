class Solution {
    public int compress(char[] chars) {
        /*
         a -> 2
         b -> 3
         d -> 12
         string as = a2b3d12
          
        */
        StringBuilder sb = new StringBuilder();
        int i=0,j=0;
        int count = 0;
        while(j <= chars.length){
            if(j == chars.length){
                sb.append(chars[i]);
                if(count != 1){
                    sb.append(count);
                }
                break;
            }
            if(chars[i] == chars[j]){
                count++;
                j++;
            } else {
                sb.append(chars[i]);
                if(count != 1){
                    sb.append(count);
                }
                i=j;
                count=0;
            }
        }
        
        System.out.println(sb.toString());

        for(int k = 0; k<sb.length(); k++){
            chars[k] = sb.charAt(k);
        }
        return sb.length();
        // return 0;

    }
}