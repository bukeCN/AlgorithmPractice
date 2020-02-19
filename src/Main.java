public class Main {
    public static void main(String[] args) {
        int[] test = new int[]{2,1,2,0,1};
        System.out.println(maxProfit(test));
    }


    /**
     * 买卖股票的最佳时机 II
     * 思路：
     * 1、第一次碰到当前元素小于后一元素时时必须买入的。
     * 2、
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int result = 0;
        int buyPrices = -1;
        for (int i = 0; i < prices.length; i++) {
            // 判断是否需要卖出
            if (buyPrices != -1) {
                // 检查后续的最高卖点
                int mustPrices = prices[i];
                for (int j = i + 1; j < prices.length; j++) {
                    if (mustPrices < prices[j]) {
                        mustPrices = prices[j];
                        i = j;
                    } else {
                        // 但是后续的点必须比前一个小，否则终止
                        break;
                    }
                }
                // 找到了最高卖点，卖了它，同时从最高卖点之后寻找下一个卖点
                result = mustPrices - buyPrices + result;
                buyPrices = -1;
                continue;
            }

            // 买入
            int nextBuyPoint = i + 1;
            if (nextBuyPoint < prices.length && prices[i] < prices[i + 1]) {
                buyPrices = prices[i];
            }
        }
        return result;
    }

    /**
     * 从数组中删除重复项
     * 总结：
     * 1、数组在在编程语言中的使用方法
     * 2、使用快慢指针
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        // 慢指针
        int i = 0;
        // 快指针
        for (int j = 1; j < nums.length; j++) {
            // 当快指针和慢指针相等时不做任何操作，快指针+1，慢指针不动
            // 当快指针和慢指针的值不等时，慢指针+1之后和快指针交换值
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        // +1 因为第一个不需要判断
        return i + 1;
    }
}

