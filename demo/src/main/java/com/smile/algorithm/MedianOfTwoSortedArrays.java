package com.smile.algorithm;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i=0, j=0, k=0;
        while(i < nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
                arr[k++] = nums1[i++];
            }else if(nums1[i] == nums2[j]){
                arr[k++] = nums1[i++];
                arr[k++] = nums2[j++];
            }else{
                arr[k++] = nums2[j++];
            }
        }
        if(i == nums1.length)while(j<nums2.length)arr[k++] = nums2[j++];
        else if(j == nums2.length)while(i<nums1.length)arr[k++] = nums1[i++];
        else;
        if(arr.length == 1)return arr[0];
        int mid = arr.length/2;
        if(arr.length%2 == 0)return ((double)arr[mid-1]+(double)arr[mid])/2;
        else return (double)arr[mid];
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1,2};
        int[] n2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(n1, n2));
    }
}
