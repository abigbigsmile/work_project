package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 16:10
 * @ModifiedBy smile
 */
public class Forty {

    public static void main(String[] args) {
        int[] array = {2,4,3,6,3,2,5,5};
        FindNumsAppearOnce(array, new int[1], new int[1]);
    }


    /*
        首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。
依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。我们首先还是先异或，剩下的数字肯定是A、B异或的结果，
这个结果的二进制中的1，表现的是A和B的不同的位。我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。
如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
     */
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length==0) return;
        int bitResult = 0;

        //数组所有数进行异或运算
        for(int i=0; i<array.length; i++) bitResult ^= array[i];

        //获取bitResult中为1的位置
        int temp = bitResult;
        int index = 0;
        while(temp != 0){
            if((temp&1) == 0) {
                temp >>= 1;
                index ++;
            }
            else break;
        }

        int res1=0, res2=0;

        //分为两组
        for(int num : array){
            int n = num>>index;
            if((n&1)==0) res1 ^= num;
            else res2 ^= num;
        }
        num1[0] = res1;
        num2[0] = res2;
    }


    //简洁写法
    public void FindNumsAppearOnce_x(int [] array,int num1[] , int num2[]) {
        if(array.length < 2) return ;
        int myxor = 0;
        int flag = 1;
        for(int i = 0 ; i < array.length; ++ i )
            myxor ^= array[i];
        while((myxor & flag) == 0) flag <<= 1;
        // num1[0] = myxor;
        //num2[0] = myxor;
        for(int i = 0; i < array.length; ++ i ){
            if((flag & array[i]) == 0) num2[0]^= array[i];
            else num1[0]^= array[i];
        }
    }

}
