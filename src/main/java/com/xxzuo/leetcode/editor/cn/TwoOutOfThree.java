//给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的
//元素可以按 任意 顺序排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
//输出：[3,2]
//解释：至少在两个数组中出现的所有值为：
//- 3 ，在全部三个数组中都出现过。
//- 2 ，在数组 nums1 和 nums2 中出现过。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
//输出：[2,3,1]
//解释：至少在两个数组中出现的所有值为：
//- 2 ，在数组 nums2 和 nums3 中出现过。
//- 3 ，在数组 nums1 和 nums2 中出现过。
//- 1 ，在数组 nums1 和 nums3 中出现过。
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
//输出：[]
//解释：不存在至少在两个数组中出现的值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length, nums3.length <= 100 
// 1 <= nums1[i], nums2[j], nums3[k] <= 100 
// 
//
// Related Topics 数组 哈希表 👍 57 👎 0

  
  package com.xxzuo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class TwoOutOfThree{
      public static void main(String[] args) {
           Solution solution = new TwoOutOfThree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> res = new ArrayList<>();
        // 由于 数组最大 100， 所以可以用一个长度 为 101的 数组来当字典
        int[] dict1 = new int[101];
        int[] dict2 = new int[101];
        int[] dict3 = new int[101];
        // 分别遍历三个数组
        for (int i : nums1) {
            dict1[i]++;
        }
        for (int i : nums2) {
            dict2[i]++;
        }
        for (int i : nums3) {
            dict3[i]++;
        }
        // 统计，看有没有出现过两次的数
        for (int i = 0; i <= 100; i++){
            int count = 0;
            if(dict1[i] != 0){
                count++;
            }
            if(dict2[i] != 0){
                count++;
            }
            if(dict3[i] != 0){
                count++;
            }
            if(count >= 2){
                res.add(i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }