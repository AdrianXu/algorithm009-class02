class UglySolution {
    public static Ugly u = new Ugly();
    public int nthUglyNumber(int n) {
        return u.num[n - 1];
    }
}

class Ugly{
    int[] num = new int[1690];
    Ugly(){
        num[0] = 1;
        int ugly = 0, i2 = 0, i3 =0, i5 = 0;
        for(int i = 1; i < 1690; i++){
            ugly = Math.min(Math.min(num[i2]*2, num[i3]*3), num[i5]*5);
            num[i] = ugly;
            if(num[i2] * 2 == ugly)i2++;
            if(num[i3] * 3 == ugly)i3++;
            if(num[i5] * 5 == ugly)i5++;
        }
    }
}