package leetcode.medium;

/**
 * Created by cc on 2016/8/7.
 */
public class BestTimeToBuySellStockWithCoolDown {


    /**Two status array.
     * 1. buy[]
     * 2. sell[]
     * buy[i] 表示到第i天， 最后一次是buy操作 最大获利
     * sell[i] 表示到第i天， 最后一次操作是sell  最大获利
     * 假设 手里没钱 可以先借钱买卖
     * 初始状态
    */

    /** From https://segmentfault.com/a/1190000004193861
     * Best explain.
     * 因为当前日期买卖股票会受到之前日期买卖股票行为的影响，首先考虑到用DP解决。

     这道题比较麻烦的是有个cooldown的限制，其实本质也就是买与卖之间的限制。对于某一天，股票有三种状态: buy, sell, cooldown,
     sell与cooldown我们可以合并成一种状态，因为手里最终都没股票，最终需要的结果是sell，即手里股票卖了获得最大利润。
     所以我们可以用两个DP数组分别记录当前持股跟未持股的状态。然后根据题目中的限制条件，理清两个DP数组的表达式。

     对于当天最终未持股的状态，最终最大利润有两种可能，
     一是今天没动作跟昨天未持股状态一样，
     二是昨天持股了，今天卖了。
     所以我们只要取这两者之间最大值即可，表达式如下：
     sellDp[i] = Math.max(sellDp[i - 1], buyDp[i - 1] + prices[i]);

     对于当天最终持股的状态，最终最大利润有两种可能，
     一是今天没动作跟昨天持股状态一样，
     二是前天还没持股，今天买了股票，这里是因为cooldown的原因，
     所以今天买股要追溯到前天的状态。我们只要取这两者之间最大值即可，表达式如下：
     buyDp[i] = Math.max(buyDp[i - 1], sellDp[i - 2] - prices[i]);
     * */

    /**
     * Buy and Sell are not very proper
     * Maybe hold and unHold are proper to explain.
     * */
    public int maxProfit(int[] prices) {

        if(prices.length == 0 || prices.length == 1){
            return 0;
        }

        int buy[] = new int[prices.length+1];
        int sell[] = new int[prices.length+1];
        buy[0]=buy[1]=-prices[0];
        sell[0]=sell[1] = 0;
        for(int i = 2; i < sell.length; i++){
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i-1]);
            sell[i] = Math.max(sell[i-1], prices[i-1]+buy[i-1]);
        }

        return sell[sell.length-1];
    }

    public static void main(String[] args){
        int test[] = {1,2,3,0,2};
        BestTimeToBuySellStockWithCoolDown bc = new BestTimeToBuySellStockWithCoolDown();
        System.out.println(bc.maxProfit(test));
    }

}
