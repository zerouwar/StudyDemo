package cn.chenhuanming.leet.code;

import java.util.Arrays;

/**
 * @author chenhuanming
 * Created at 2018/12/26
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,11,5,7,4,8,9,2};

        quickSort(arr);

        Utils.println(arr);
    }

    static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    static void quickSort(int[] arr,int left,int right){
        if(left<right){
            int mid = partition(arr,left,right);
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }
    }

    static int partition(int[] arr,int left,int right){
        int t = arr[right];

        int i = left;

        for (int j = i; j < right; j++) {
            if(arr[j]<t){
                Utils.exchange(arr,i++,j);
            }
        }
        Utils.exchange(arr,i,right);
        return i;
    }
}
