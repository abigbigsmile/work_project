package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 23:40
 * @ModifiedBy smile
 */


// 孩子们的游戏(圆圈中最后剩下的数)
public class FortySix {

    /**
     * 题目描述
     * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
     * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的
     * 那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....
     * 这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,
     * 哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
     *
     * 如果没有小朋友，请返回-1
     */

    public class Solution {
        // 使用递归：
        // 这是一个约瑟夫环的问题
        public int LastRemaining_Solution(int n, int m) {
            if(n==0) return -1;
            if(n==1) return 0;
            return (LastRemaining_Solution(n-1, m)+m)%n;
        }
    }

    // 这是一个约瑟夫环的问题:https://blog.csdn.net/u011500062/article/details/72855826
    /*
        f(n, m)表示n个人时的胜利者，一轮之后为f(n-1, m)；因为第二轮会从第一轮被淘汰的人后面重新报数，所以f(n, m)的胜利者的
        位置在f(n-1, m)时相当于前移了m位： (f(n-1,m)+m)%n = f(n, m)
    */
    public int LastRemaining_Solution(int n, int m) {
        if(n <= 0 || m <= 0) return -1;
        int last = 0; //当n==1时，胜利者下标为0
        for(int i=2; i<=n; i++){
            last = (last+m)%i; //递推公式：
        }
        return last;
    }

}
