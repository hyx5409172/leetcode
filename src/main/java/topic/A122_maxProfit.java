package topic;

public class A122_maxProfit {

    public static void main(String[] args) {
        int[] prices = {2, 1, 2, 0, 1};
        A122_maxProfit a122 = new A122_maxProfit();

        System.out.println(a122.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int hold = -1;
        int profit = 0;
        for (int i = 1; i < prices.length;) {
            while(i < prices.length && prices[i] >= prices[i-1]){
                if(hold == -1){
                    hold = prices[i - 1];
                }
                i ++;
            }

            if(hold > -1){
                profit += prices[i - 1] - hold;
                hold = -1;
            }

            while(i < prices.length && prices[i] < prices[i - 1]){
                i ++;
            }

        }

        return profit;
    }

}
