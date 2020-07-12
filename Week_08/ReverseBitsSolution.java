public class ReverseBitsSolution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i <= 31; i++){
            ans = ans * 2 + (n & 1);
            n >>= 1;
        }
        return ans;
    }
}