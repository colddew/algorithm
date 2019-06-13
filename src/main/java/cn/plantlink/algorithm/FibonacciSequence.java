package cn.plantlink.algorithm;

/**
 * 斐波那契数列
 */
public class FibonacciSequence {

    // 递归，时间复杂度O(n^2)，空间复杂度O(n)
    public static int recursive(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return recursive(n - 1) + recursive(n - 2);
        }
    }

    // 迭代，时间复杂度O(n)，空间复杂度O(n)
    public static int iterative(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {

            // 使用辅助数组降低时间复杂度
            int[] d = new int[n + 1];
            d[0] = 0;
            d[1] = 1;

            for (int i = 2; i <= n; i++) {
                d[i] = d[i - 1] + d[i - 2];
            }

            return d[n];
        }
    }

    // 迭代，时间复杂度O(n)，空间复杂度O(1)
    public static int iterative_O1(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {

            // 临时变量滚动更新降低空间复杂度
            int first = 0;
            int second = 1;

            for (int i = 2; i <= n; i++) {
                int third = first + second;
                first = second;
                second = third;
            }

            return second;
        }
    }

    public static void main(String[] args) {
        System.out.println(recursive(5));
        System.out.println(iterative(5));
        System.out.println(iterative_O1(5));
    }
}
