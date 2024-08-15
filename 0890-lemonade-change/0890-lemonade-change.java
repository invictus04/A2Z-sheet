class Solution {
    public boolean lemonadeChange(int[] bills) {
        int cntfive=0, cntten=0;
        for(int i=0; i<bills.length; i++){
            if(bills[i] == 5){
                cntfive++;
            } else if(bills[i] == 10) {
                if(cntfive>0){
                cntfive--;
                cntten++;
                } else {
                    return false;
                }
            } else{
                if(cntten>0 && cntfive>0){
                    cntfive--;
                    cntten--;
                } else if(cntfive>=3){
                    cntfive -=3;
                } else {
                    return false;
                }
            }
        }

        

        return true;
    }
}