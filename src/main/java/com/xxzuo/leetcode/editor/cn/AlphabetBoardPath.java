//我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。 
//
// 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。 
//
// 
//
// 我们可以按下面的指令规则行动： 
//
// 
// 如果方格存在，'U' 意味着将我们的位置上移一行； 
// 如果方格存在，'D' 意味着将我们的位置下移一行； 
// 如果方格存在，'L' 意味着将我们的位置左移一列； 
// 如果方格存在，'R' 意味着将我们的位置右移一列； 
// '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。 
// 
//
// （注意，字母板上只存在有字母的位置。） 
//
// 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = "leet"
//输出："DDR!UURRR!!DDD!"
// 
//
// 示例 2： 
//
// 
//输入：target = "code"
//输出："RR!DDRR!UUL!R!"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target.length <= 100 
// target 仅含有小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 👍 105 👎 0


package com.xxzuo.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class AlphabetBoardPath {
    public static void main(String[] args) {
        Solution solution = new AlphabetBoardPath().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String alphabetBoardPath(String target) {
            // 记录字母位置
            Map<Integer, int[]> coordinate = new HashMap<>();

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    coordinate.put(i * 5 + j, new int[]{i, j});
                }
            }
            coordinate.put('z' - 'a', new int[]{5, 0});
            int[] start = new int[]{0, 0};
            StringBuilder sb = new StringBuilder();
            for (char s : target.toCharArray()) {
                int row = coordinate.get(s - 'a')[0] - start[0];
                int col = coordinate.get(s - 'a')[1] - start[1];
                //优先向上向左走
                if (row < 0) {
                    //向上走
                    for (int i = 0; i < Math.abs(row); i++) {
                        sb.append('U');
                    }
                }
                if (col < 0) {
                    for (int j = 0; j < Math.abs(col); j++) {
                        sb.append('L');
                    }
                } else {
                    for (int j = 0; j < Math.abs(col); j++){
                        sb.append('R');
                    }
                }
                if (row > 0) {
                    for (int i = 0; i < Math.abs(row); i++){
                        sb.append('D');
                    }
                }

                sb.append('!');
                start = new int[]{coordinate.get(s - 'a')[0], coordinate.get(s - 'a')[1]};
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}