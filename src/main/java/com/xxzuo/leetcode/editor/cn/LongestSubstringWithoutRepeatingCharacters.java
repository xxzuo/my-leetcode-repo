//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 9507 👎 0

  
  package com.xxzuo.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters{
      public static void main(String[] args) {
           Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = 0;
        int len = s.length();
        // 用 map 记录窗口内的 字母
        HashMap<Character, Integer> record = new HashMap<>();
        while (right < len){
            char cur = s.charAt(right);
            // 如果当前没有就加入窗口 记录一下目前长度
            if(!record.containsKey(cur)){
                record.put(cur, right);
                res = Math.max(res, right - left + 1);
                right++;
            }else {
                // 如果有 则移动 left 到出现过字母的后一个 index
                left = Math.max(left, record.get(cur) + 1);
                if(left > right){
                    right = left;
                }
                record.remove(cur);
                res = Math.max(res, right - left + 1);
            }

        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }