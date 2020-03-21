package com.smile.nowcoder.second;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 22:56
 * @ModifiedBy smile
 */
public class FortyFive {

    // 使用TreeSet
    public boolean isContinuous(int [] numbers) {
        if(numbers==null || numbers.length!=5) return false;
        TreeSet<Integer> treeSet = new TreeSet();
        int count = 0;
        for(int num : numbers){
            if(num == 0) count++;
            else if(num > 13) return false;
            else treeSet.add(num);
        }
        if(count + treeSet.size() != 5) return false; //判断重复

        int min = treeSet.first();
        int max = treeSet.last();

        return max-min < 5; //最大最小不超过5
    }


    // 中间间隔不超过0的个数
    public boolean isContinuous_x(int [] numbers) {
        if(numbers==null || numbers.length==0) return false;
        Arrays.sort(numbers);
        int zero = 0;
        int gap = 0;
        for(int i=0; i<numbers.length-1; i++){
            if(numbers[i]==0) zero++;
            else {
                if(numbers[i]==numbers[i+1]) return false;
                gap += numbers[i+1] - numbers[i] - 1;
            }
        }
        return gap<=zero? true : false;
    }

}
