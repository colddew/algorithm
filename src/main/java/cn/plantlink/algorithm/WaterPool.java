package cn.plantlink.algorithm;

/**
 * 储水量问题
 */
public class WaterPool {

    // 辅助数组，时间复杂度O(n)，空间复杂度O(n)
    public static int store(int[] height) {

        if (null == height || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int leftMax = -1;
        int rightMax = -1;
        int water = 0;
        // 辅助数组
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            d[i] = leftMax;
        }

        for (int i = n - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            d[i] = Math.min(d[i], rightMax);
            water += (d[i] - height[i]);
        }

        return water;
    }

    // 双指针扫描，时间复杂度O(n)，空间复杂度O(1)
    public static int store_O1(int[] height) {

        if (null == height || height.length == 0) {
            return 0;
        }

        int leftMax = -1;
        int rightMax = -1;
        int water = 0;
        int i = 0;
        int j = height.length - 1;

        while (i <= j) {
            // 记录阶段性扫描的最大值
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax) {
                water += (leftMax - height[i++]);
            } else {
                water += (rightMax - height[j--]);
            }
        }

        return water;
    }

    public static void main(String[] args) {
        // 输入为整数数组表示的水位高度图
        int[] height = new int[]{0, 2, 0, 4, 0, 1, 2};
        System.out.println(store(height));
        System.out.println(store_O1(height));
    }
}
