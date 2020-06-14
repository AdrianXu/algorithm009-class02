class LemonadeChangeSolution {
    public boolean lemonadeChange(int[] bills) {
        int change5 = 0, change10 = 0;
        for(int i = 0; i < bills.length; i++){
            switch(bills[i]){
                case 5:
                    change5++;
                    break;
                case 10:
                    change10++;
                    change5--;
                    break;
                case 20:
                    if(change10 != 0){
                        change10--;
                        change5--;
                    }else{
                        change5 -= 3;
                    }
                    break;
            }
            if(change5 < 0){
                return false;
            }
        }
        return true;
    }
}