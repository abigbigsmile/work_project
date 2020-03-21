package com.smile.nowcoder.second;

import java.util.ArrayList;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 16:43
 * @ModifiedBy smile
 */

/**
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FortyOne {

    //双指针
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        int left = 1, right = 2;
        while(left < right){
            int curSum = (left+right)*(right-left+1)/2;
            if(curSum==sum){
                ArrayList<Integer> temp = new ArrayList();
                for(int i=left; i<=right; i++) temp.add(i);
                res.add(new ArrayList(temp));
                left++;
            }else if(curSum<sum){
                right++;
            }else{
                left++;
            }
        }
        return res;
    }

}
