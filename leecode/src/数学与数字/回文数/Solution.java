package 数学与数字.回文数;

import java.util.ArrayList;

/*
题目：
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
//解法一：若x<0或直接返回false，否则直接反转X，然后与反转前比较
/*public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int ans = 0;
        int temp=x;
        while (temp != 0) {
            int pop = temp % 10;
            ans = ans * 10 + pop;
            temp /= 10;
        }
        if (ans == x) {
            return true;
        } else {
            return false;
        }
    }
}*/
//解法二：将X后半段数字反转如果和前半段相等就是回文数，否则不是回文数。
//判断奇偶数情况：如果是偶数的话，revertNum 和 x 相等；如果是奇数的话，
// 最中间的数字就在revertNum 的最低位上，将它除以 10 以后应该和 x 相等。
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reverteNum = 0;
        //当x<reverteNum时说明已对折过半
        while (x>reverteNum){
            reverteNum = reverteNum*10+x%10;
            x/=10;
        }
        return x==reverteNum||x==reverteNum/10;
    }
}