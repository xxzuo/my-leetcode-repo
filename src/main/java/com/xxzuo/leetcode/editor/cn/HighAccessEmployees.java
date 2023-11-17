//给你一个长度为 n 、下标从 0 开始的二维字符串数组 access_times 。对于每个 i（0 <= i <= n - 1 ），access_
//times[i][0] 表示某位员工的姓名，access_times[i][1] 表示该员工的访问时间。access_times 中的所有条目都发生在同一天内。 
//
// 访问时间用 四位 数字表示， 符合 24 小时制 ，例如 "0800" 或 "2250" 。 
//
// 如果员工在 同一小时内 访问系统 三次或更多 ，则称其为 高访问 员工。 
//
// 时间间隔正好相差一小时的时间 不 被视为同一小时内。例如，"0815" 和 "0915" 不属于同一小时内。 
//
// 一天开始和结束时的访问时间不被计算为同一小时内。例如，"0005" 和 "2350" 不属于同一小时内。 
//
// 以列表形式，按任意顺序，返回所有 高访问 员工的姓名。 
//
// 
//
// 示例 1： 
//
// 
//输入：access_times = [["a","0549"],["b","0457"],["a","0532"],["a","0621"],["b","0
//540"]]
//输出：["a"]
//解释："a" 在时间段 [05:32, 06:31] 内有三条访问记录，时间分别为 05:32 、05:49 和 06:21 。
//但是 "b" 的访问记录只有两条。
//因此，答案是 ["a"] 。 
//
// 示例 2： 
//
// 
//输入：access_times = [["d","0002"],["c","0808"],["c","0829"],["e","0215"],["d","1
//508"],["d","1444"],["d","1410"],["c","0809"]]
//输出：["c","d"]
//解释："c" 在时间段 [08:08, 09:07] 内有三条访问记录，时间分别为 08:08 、08:09 和 08:29 。
//"d" 在时间段 [14:10, 15:09] 内有三条访问记录，时间分别为 14:10 、14:44 和 15:08 。
//然而，"e" 只有一条访问记录，因此不能包含在答案中，最终答案是 ["c","d"] 。 
//
// 示例 3： 
//
// 
//输入：access_times = [["cd","1025"],["ab","1025"],["cd","1046"],["cd","1055"],[
//"ab","1124"],["ab","1120"]]
//输出：["ab","cd"]
//解释："ab"在时间段 [10:25, 11:24] 内有三条访问记录，时间分别为 10:25 、11:20 和 11:24 。
//"cd" 在时间段 [10:25, 11:24] 内有三条访问记录，时间分别为 10:25 、10:46 和 10:55 。
//因此，答案是 ["ab","cd"] 。 
//
// 
//
// 提示： 
//
// 
// 1 <= access_times.length <= 100 
// access_times[i].length == 2 
// 1 <= access_times[i][0].length <= 10 
// access_times[i][0] 仅由小写英文字母组成。 
// access_times[i][1].length == 4 
// access_times[i][1] 采用24小时制表示时间。 
// access_times[i][1] 仅由数字 '0' 到 '9' 组成。 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 0 👎 0


package com.xxzuo.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class HighAccessEmployees {
    public static void main(String[] args) {
        Solution solution = new HighAccessEmployees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findHighAccessEmployees(List<List<String>> access_times) {
            HashMap<String, List<String>> record = new HashMap<>();

            // 处理成 map<人, 时间列表>
            for (List<String> accessTime : access_times) {
                List<String> timeList = record.get(accessTime.get(0));
                if (timeList != null) {
                    timeList.add(accessTime.get(1));
                } else {
                    List<String> l = new ArrayList<>();
                    l.add(accessTime.get(1));
                    record.put(accessTime.get(0), l);
                }
            }
            List<String> res = new ArrayList<>();
            for (String p : record.keySet()) {
                List<String> timeList = record.get(p);
                // 时间列表排序
                Collections.sort(timeList);
                // 计算每三个时间是不是在一个小时内
                for (int i = 2; i < timeList.size(); i++) {
                    if (getTimeDiff(timeList.get(i - 2), timeList.get(i)) < 60) {
                        res.add(p);
                        break;
                    }
                }

            }
            return res;
        }

        /**
         * 计算两个字符串时间的 分钟差
         *
         * @param time1
         * @param time2
         * @return
         */
        public int getTimeDiff(String time1, String time2) {
            int hour1 = Integer.parseInt(time1.substring(0, 2));
            int min1 = Integer.parseInt(time1.substring(2));

            int hour2 = Integer.parseInt(time2.substring(0, 2));
            int min2 = Integer.parseInt(time2.substring(2));

            return hour2 * 60 + min2 - hour1 * 60 - min1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}