//给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数
//字的某个数位。
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [4,1,3], nums2 = [5,7]
//输出：15
//解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
// 
//
// 示例 2： 
//
// 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
//输出：3
//解释：数字 3 的数位 3 在两个数组中都出现了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 9 
// 1 <= nums1[i], nums2[i] <= 9 
// 每个数组中，元素 互不相同 。 
// 
//
// Related Topics 数组 哈希表 枚举 👍 78 👎 0

  
  package com.xxzuo.leetcode.editor.cn;
  public class FormSmallestNumberFromTwoDigitArrays{
      public static void main(String[] args) {
           Solution solution = new FormSmallestNumberFromTwoDigitArrays().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int res = 0;
        int[] record = new int[10];
        // 这里 数组1 的计算+1
        for(int n : nums1){
            record[n]++;
        }
        // 数组2 的计数+2 是为了区分这个数是从 nums1 来的 还是 nums2来的
        for(int n : nums2){
            record[n] += 2;
        }
        int first = 10;
        int second = 10;
        // 从前面往后遍历  因为取最小 先满足条件的肯定比后满足条件的少
        for(int i = 0; i < 10;i++){
            // 3 表示两个数组都有 那么肯定选这个 因为个位数一定比两位数小
            if(record[i] == 3){
                return i;
            }
            // 记录每个数组 数位的 最小值
            if(record[i] == 1){
                first = Math.min(first, i);
            }
            if(record[i] == 2){
                second = Math.min(second, i);
            }
        }
        // 最后进行比较
        return first < second ? first * 10 + second : second * 10 + first;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }