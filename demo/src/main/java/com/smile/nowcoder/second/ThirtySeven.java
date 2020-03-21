package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 15:10
 * @ModifiedBy smile
 */


/**
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。==========================有序，就应该想到二分法
 */
public class ThirtySeven {


    //(mid-1 >=0 && array[mid-1] == k应该把0改为start;mid+1 < length && array[mid+1] == k应该把length改为end
    public class Solution {
        public int GetNumberOfK(int [] array , int k) {
            int length = array.length;
            if(length == 0){
                return 0;
            }
            int firstK = getFirstK(array, k, 0, length-1);
            int lastK = getLastK(array, k, 0, length-1);
            if(firstK != -1 && lastK != -1){
                return lastK - firstK + 1;
            }
            return 0;
        }
        //获取第一个k的位置
        private int getFirstK(int [] array , int k, int left, int right){
            if(left>right) return -1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(array[mid] < k){
                    left = mid + 1;
                }else if(array[mid] > k){
                    right = mid - 1;
                }else if(mid-1>=0 && array[mid-1]==k){
                    right = mid-1;
                }else{
                    return mid;
                }
            }
            return -1;
        }

        //获取最后一个k的位置
        private int getLastK(int [] array , int k, int left, int right){
            if(left>right) return -1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(array[mid] < k){
                    left = mid + 1;
                }else if(array[mid] > k){
                    right = mid - 1;
                }else if(mid+1<=right && array[mid+1]==k){
                    left = mid+1;
                }else{
                    return mid;
                }
            }
            return -1;
        }
    }

}
