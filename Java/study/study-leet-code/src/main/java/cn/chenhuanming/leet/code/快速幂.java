package cn.chenhuanming.leet.code;

/**
 * 快速求base的exponent次方
 * 原理是通过分解指数，减少乘法次数
 * 例如，3^11 = 3^(1011) = 3^(0001)*3^(0010)*3^(1000)
 * 3^(0010) = 3^(0001）*3，不用重新计算3^(0001)
 */
public class 快速幂 {
    public static void main(String[] args) {
        System.out.println(Power(0.3, 2));
    }

    public static double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        double result = 1;
        double curr = base;
        int n = exponent > 0 ? exponent : -exponent;
        while (n > 0) {
            if ((n & 1) == 1)
                result *= curr;
            curr *= curr;
            n >>= 1;
        }
        return exponent > 0 ? result : 1 / result;
    }
}