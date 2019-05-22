package cn.plantlink.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 最长递增子序列，子序列不连续
 */
public class LongestIncreaseSubsequence {

    // 常规动态规划算法，时间复杂度O(n^2)，空间复杂度O(n)
    public static int lengthOf(int[] nums) {

        if (null == nums || nums.length == 0) {
            return 0;
        } else {

            int n = nums.length;
            int max = 1;
            // 状态数组，d[i]表示以第i个数字结尾的最长递增子序列的长度
            int[] d = new int[n];
            d[0] = 1;

            // a(i) > a(j) -> d(i) = max(所有的d(j)+1) -> max(所有的d(i)+1)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int tmp = nums[i] > nums[j] ? d[j] + 1 : 1;
                    d[i] = Math.max(d[i], tmp);
                }
                max = Math.max(max, d[i]);
            }

            return max;
        }
    }

    // 只保存所有递增子序列中结尾数字最小的，时间复杂度O(n*log(n))，空间复杂度O(n)
    public static int lengthOfWithBinarySearch(int[] nums) {

        if (null == nums || nums.length == 0) {
            return 0;
        } else {

            int n = nums.length;
            int len = 0;
            // 辅助数组使用长度由len决定，d[i]表示长度为i+1的所有递增子序列中结尾最小的数字
            int[] d = new int[n];

            for (int x : nums) {
                int i = findBinarySearchInsertPosition(d, len, x);
                System.out.println("@" + i);
                d[i] = x;
//                System.out.println(x);
                if (i == len) {
                    len++;
                }
            }

            return len;
        }
    }

    private static int findBinarySearchInsertPosition(int[] d, int len, int x) {

//        List<Integer> list = Arrays.stream(d).mapToObj(Integer::valueOf).collect(Collectors.toList());
        List<Integer> list = Arrays.stream(d).boxed().collect(Collectors.toList());
        System.out.println(String.format("list = %s, len = %d, x = %d", list.toString(), len, x));

        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (x < d[middle]) {
                high = middle - 1;
            } else if (x > d[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 8, 2, 6, 4, 5};
//        System.out.println(lengthOf(nums));
        System.out.println(lengthOfWithBinarySearch(nums));
    }
}
