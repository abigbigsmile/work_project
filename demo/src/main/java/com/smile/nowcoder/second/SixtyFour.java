package com.smile.nowcoder.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/21 17:57
 * @ModifiedBy smile
 */
public class SixtyFour {

    public static void main(String[] args) {
        int[] nums = {5,2,3,4,1,6,7,0,8};
        for(int num : nums) list.add(num);
        System.out.println(GetMedian());
    }

    //普通解法
    private static ArrayList<Integer> list = new ArrayList();
    public static void Insert(Integer num) {
        list.add(num);
    }
    public static Double GetMedian() {
        list.sort((a, b) -> a-b);
        int size = list.size();
        if(size%2==0){
            return (double)(list.get(size/2)+list.get((size/2)-1))/2;
        }else return (double)list.get(size/2);
    }


    /**
     * 先用java集合PriorityQueue来设置一个小顶堆和大顶堆
     * 主要的思想是：因为要求的是中位数，那么这两个堆，大顶堆用来存较小的数，从大到小排列；
     * 小顶堆存较大的数，从小到大的顺序排序*，显然中位数就是大顶堆的根节点与小顶堆的根节点和的平均数。
     * ⭐保证：小顶堆中的元素都大于等于大顶堆中的元素，所以每次塞值，并不是直接塞进去，而是从另一个堆中poll出一个最大（最小）的塞值
     * ⭐当数目为偶数的时候，将这个值插入大顶堆中，再将大顶堆中根节点（即最大值）插入到小顶堆中；
     * ⭐当数目为奇数的时候，将这个值插入小顶堆中，再讲小顶堆中根节点（即最小值）插入到大顶堆中；
     * ⭐取中位数的时候，如果当前个数为偶数，显然是取小顶堆和大顶堆根结点的平均值；如果当前个数为奇数，显然是取小顶堆的根节点
     */
    //大顶堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    //小顶堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int size = 0;

    public void Insert_x(Integer num) {
        size++;
        if(size%2 == 0){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }else{
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }
    public Double GetMedian_x() {
        if(size%2==0){
            return (double)(maxHeap.peek()+minHeap.peek())/2;
        }else{
            return (double)minHeap.peek();
        }
    }


}
