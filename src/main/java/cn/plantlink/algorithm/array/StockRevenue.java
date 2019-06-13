package cn.plantlink.algorithm.array;

/**
 * 已知股票涨跌曲线，在某一天买入股票，在另一天卖掉，要求获取最大收益
 */
public class StockRevenue {

    // 动态规划，时间复杂度O(n)，空间复杂度O(1)
    // 求d[j] - d[i]中的最大值，j > i
    // 假设f[i]表示数组中前i+1个数的解，前i+1个数的最小值为m[i]，f[i] = max(f[i-1], a[i] - m[i-1]), m[i] = min(m[i-1], a[i])，问题的解为f[n-1]
    public static int getMaxRevenue(int[] d) {

        if (null == d || d.length <= 1) {
            return 0;
        }

        int revenue = 0;
        int min = d[0];

        for (int i = 1; i < d.length; i++) {
            revenue = Math.max(revenue, d[i] - min);
            min = Math.min(min, d[i]);
        }

        return revenue;
    }

    public static void main(String[] args) {

        int[] d = new int[]{1, 8, 2, 6, 11, 5};
        System.out.println(getMaxRevenue(d));

        int[] d2 = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(getMaxRevenue(d2));

        int[] d3 = new int[]{9, 7, 5, 3, 2, 1};
        System.out.println(getMaxRevenue(d3));
    }
}
