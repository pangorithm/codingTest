class Solution {
    public int solution(int chicken) {
        int coupon = chicken;
        int sum = chicken;
        while(coupon > 9){
            int service = coupon / 10;
            sum += service;
            coupon = service + coupon % 10;
        }
        return sum - chicken;
    }
}