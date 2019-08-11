package cn.plantlink.algorithm.pta;

import java.util.Scanner;

/**
 * 哥德巴赫猜想
 * 偶数等于两个素数和
 */
public class GoldbachConjecture {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();

        for (int i = 2; i < sum / 2 + 1; i++) {
            if (isPrime(i) && isPrime(sum - i)) {
                System.out.println(i + " " + (sum - i));
                break;
            }
        }
    }

    private static boolean isPrime(int n) {

        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else {
            for (int i = 2; i < Math.sqrt(n) + 1; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
