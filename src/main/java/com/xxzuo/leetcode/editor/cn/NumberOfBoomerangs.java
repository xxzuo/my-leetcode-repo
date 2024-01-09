//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。 
//
// 返回平面上所有回旋镖的数量。 
//
// 示例 1： 
//
// 
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 所有点都 互不相同 
// 
//
// Related Topics 数组 哈希表 数学 👍 291 👎 0

  
  package com.xxzuo.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs{
      public static void main(String[] args) {
           Solution solution = new NumberOfBoomerangs().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, HashMap<Integer, Integer>> record = new HashMap<>();
        int res = 0;
        // 构建 map 记录 当前点 与其他点的距离
        for(int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> temp = new HashMap<>();
            for(int j = 0; j < points.length; j++) {
                if(i != j){
                    // 计算距离
                    int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                            (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                    // 以距离为 key, 记录距离出现的次数
                    temp.put(distance ,temp.getOrDefault(distance, 0) + 1);
                }
            }
            // 记录当前点与其他点的距离
            record.put(i, temp);
        }
        // 遍历集合 统计相同距离的个数
        for (HashMap<Integer, Integer> distanceMap : record.values()) {
            for(Integer distanceCount : distanceMap.values()){
                if(distanceCount <= 1){
                    continue;
                }
                // 统计相同距离的个数 * (相同距离的个数 - 1)
                res += distanceCount * (distanceCount - 1);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }