//假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。 
//
// 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则
//的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 1
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= flowerbed.length <= 2 * 10⁴ 
// flowerbed[i] 为 0 或 1 
// flowerbed 中不存在相邻的两朵花 
// 0 <= n <= flowerbed.length 
// 
//
// Related Topics 贪心 数组 👍 666 👎 0

  
  package com.xxzuo.leetcode.editor.cn;
  public class CanPlaceFlowers{
      public static void main(String[] args) {
           Solution solution = new CanPlaceFlowers().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//        int count = 0;
//        for(int i = 0; i < flowerbed.length; i++){
//            if(flowerbed[i] == 0){
//                int pre = i == 0 ? 0 : flowerbed[i - 1];
//                int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
//                if(pre == 0 && next == 0){
//                    System.out.println(i);
//                    flowerbed[i] = 1;
//                    count++;
//                }
//
//            }
//        }
//        return count >= n;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        for(int f : flowerbed){
            sb.append(f);
        }
        sb.append(0);
        String[] split = sb.toString().split("1");

        for(int i = 0; i < split.length; i++){
            count += split[i].length() % 2 == 0 ? split[i].length() / 2 - 1 : split[i].length() / 2;

        }
        return count >= n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }