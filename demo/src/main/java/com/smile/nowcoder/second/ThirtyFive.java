package com.smile.nowcoder.second;

import java.util.Arrays;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 0:51
 * @ModifiedBy smile
 */


public class ThirtyFive {

    public static void main(String[] args) {
        int[] arr = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int count = mergeSort(arr, 0, arr.length-1);
        System.out.println(count);
    }

    public static int mergeSort(int[] arr, int left, int right){
        int count = 0;
        if(left>=right) return 0;
        int mid = left + (right-left)/2;
        count += mergeSort(arr, left, mid);
        count += mergeSort(arr, mid+1, right);
        count += merge(arr, left, mid, right);
        return count;
    }

    /*public static int merge(int[] arr, int left, int mid, int right){
        int count = 0;
        int[] temp = Arrays.copyOf(arr, arr.length);
        int l = left, r = mid+1;
        for(int i=left; i<=right; i++){
            if(l>mid) arr[i] = temp[r++];
            else if(r>right) arr[i] = temp[l++];
            else if(temp[l]<=temp[r]) arr[i] = temp[l++];
            else {
                count += mid - l + 1;
                arr[i] = temp[r++];
            }
        }
        return count;
    }*/

    private static int merge(int[] arr, int lo, int mid, int hi) {
        int[] temp = new int[hi - lo + 1];
        int index = 0;
        int count = 0;
        int p1 = lo, p2 = mid + 1;
        while (p1 <= mid && p2 <= hi) {
            // 与归并排序不同的地方，在merge过程中统计逆序对数

            /**
             * 下面两个条件调换一下就可以通过牛客的判题系统？？？？？？
             */


            if (arr[p1] > arr[p2]) {
                count += mid - p1 + 1;
                temp[index++] = arr[p2++];
            } else {
                temp[index++] = arr[p1++];
            }
        }
        while (p1 <= mid) {
            temp[index++] = arr[p1++];
        }
        while (p2 <= hi) {
            temp[index++] = arr[p2++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[lo++] = temp[i];
        }

        return count;
    }
}
