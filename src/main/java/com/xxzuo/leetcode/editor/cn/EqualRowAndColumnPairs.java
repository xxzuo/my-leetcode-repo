//给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。 
//
// 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
//输出：1
//解释：存在一对相等行列对：
//- (第 2 行，第 1 列)：[2,7,7]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
//输出：3
//解释：存在三对相等行列对：
//- (第 0 行，第 0 列)：[3,1,2,2]
//- (第 2 行, 第 2 列)：[2,4,2,2]
//- (第 3 行, 第 2 列)：[2,4,2,2]
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// 1 <= grid[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 矩阵 模拟 👍 68 👎 0

  
  package com.xxzuo.leetcode.editor.cn;

import java.util.HashMap;

public class EqualRowAndColumnPairs{
      public static void main(String[] args) {
           Solution solution = new EqualRowAndColumnPairs().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int equalPairs(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int res = 0;
        HashMap<String, Integer> record = new HashMap<>();

        for(int i = 0; i < rowLen; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < colLen; j++){
                sb.append(grid[i][j]);
                sb.append("|");
            }
            String temp = sb.toString();
            record.put(temp, record.getOrDefault(temp, 0) + 1);
        }

        for(int m = 0; m < colLen; m++){
            StringBuilder sb = new StringBuilder();
            for(int n = 0; n < rowLen; n++){
                sb.append(grid[n][m]);
                sb.append("|");
            }
            String s = sb.toString();
            res += record.getOrDefault(s, 0);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }