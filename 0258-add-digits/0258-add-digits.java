class Solution {
    public int addDigits(int num) {
        int sum;
        while(num>=10){
            sum=0;
        int temp = num;
        while(temp!=0){
            int digit = temp%10;
            sum+=digit;
            temp /= 10;
        }
        num=sum;
        }
        return num;
    }
}