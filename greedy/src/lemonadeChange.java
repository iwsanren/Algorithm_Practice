public class lemonadeChange {
    public lemonadeChange() {    }
    public boolean lemonadeChange(int[] bills) {
        if(bills[0] != 5) return false;
        int chargeFive = 0;
        int chargeTen = 0;

        for (int i = 0; i < bills.length; i++) {
            if(bills[i] == 10){
                chargeFive--;
                chargeTen++;
            }else if(bills[i] == 20){
                if(chargeTen == 0){
                    chargeFive -= 3;
                }else{
                    chargeFive--;
                    chargeTen--;
                }
            }else{
                chargeFive++;
            }
            if(chargeFive < 0 || chargeTen < 0) return false;
        }
        return true;
    }
}
