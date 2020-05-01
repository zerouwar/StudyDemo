package cn.chenhuanming.leet.code.common;

/**
 * @author chenhuanming
 * Created at 2018/12/26
 */
public class Utils {
    public static void exchange(int[] arr, int l, int r) {
        if(l!=r){
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];
        }
    }

    public static void println(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println(2^2);
    }
}
