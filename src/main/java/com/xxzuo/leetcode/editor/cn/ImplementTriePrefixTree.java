//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 
//false 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 10⁴ 次 
// 
//
// Related Topics 设计 字典树 哈希表 字符串 👍 1439 👎 0


package com.xxzuo.leetcode.editor.cn;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Solution solution = new ImplementTriePrefixTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        /**
         * 子节点
         */
        private Trie[] childrenList;

        /**
         * 标识 是否为单词结尾
         */
        private boolean wordEndFlag;

        public Trie() {
            // 只包含 26 个小写字母, 所以只需要 26 个节点
            childrenList = new Trie[26];
            // 初始化都是 false
            wordEndFlag = false;
        }

        public void insert(String word) {
            int len = word.length();
            char[] wordCharArray = word.toCharArray();
            Trie node = this;
            for (int i = 0; i < len; i++){
                char ch = wordCharArray[i];
                // 如果没有节点 就创建一个新的子节点
                if(node.childrenList[ch - 'a'] == null){
                    node.childrenList[ch - 'a'] = new Trie();
                }
                node = node.childrenList[ch - 'a'];
            }
            // 标记单词结尾
            node.wordEndFlag = true;
        }

        public boolean search(String word) {
            Trie node = searchNode(word);
            // 如果 能搜索到 并且 是单词 末尾，说明 这个词 已经 insert 过
            return node != null && node.wordEndFlag;
        }

        public boolean startsWith(String prefix) {
            // 只是 前缀， 就不用判断 wordEndFlag 了
            return searchNode(prefix) != null;
        }

        /**
         * 根据 查询的单词 搜索节点
         * @param word 查询的词
         * @return 字典树 节点
         */
        public Trie searchNode(String word){
            int len = word.length();
            char[] wordCharArray = word.toCharArray();
            Trie node = this;
            for (int i = 0; i < len; i++){
                char ch = wordCharArray[i];
                // 如果没有节点 返回 null 表示当前单词 没搜索到
                if(node.childrenList[ch - 'a'] == null){
                    return null;
                }
                node = node.childrenList[ch - 'a'];
            }
            return node;
        }

    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}