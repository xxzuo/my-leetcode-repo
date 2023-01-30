//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。 
//
// 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[
//i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。 
//
// 示例 1: 
//
// 
//输入: g = [1,2,3], s = [1,1]
//输出: 1
//解释: 
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
// 
//
// 示例 2: 
//
// 
//输入: g = [1,2], s = [1,2,3]
//输出: 2
//解释: 
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= g.length <= 3 * 10⁴ 
// 0 <= s.length <= 3 * 10⁴ 
// 1 <= g[i], s[j] <= 2³¹ - 1 
// 
//
// Related Topics 贪心 数组 双指针 排序 👍 638 👎 0

  
  package com.xxzuo.leetcode.editor.cn;

import java.util.Arrays;

public class AssignCookies{
      public static void main(String[] args) {
           Solution solution = new AssignCookies().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 贪心
        // 对饼干 和 胃口进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int cookie = 0;
        // 小孩遍历完 或者 饼干使用完 就结束
        while(res < g.length && cookie < s.length){
            // 如果 小孩的胃口可以被满足 结果+1
            // 如果小孩的胃口不能被满足 看下一个
            if(g[res] <= s[cookie]){
                res++;
            }
            // 饼干是 肯定被消耗的，因为排过序，如果无法满足当前的小孩，肯定也满足不了下一个小孩
            cookie++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }