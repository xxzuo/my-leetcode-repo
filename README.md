# my-leetcode-repo
记录leetcode

使用 idea [leetcode-editor插件](https://github.com/shuzijun/leetcode-editor)

使用的模板

**标题**
>  $!velocityTool.camelCaseName(${question.titleSlug})

**内容**
```
${question.content}
  
  package com.xxzuo.leetcode.editor.cn;
  public class $!velocityTool.camelCaseName(${question.titleSlug}){
      public static void main(String[] args) {
           Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
      }
      ${question.code}
  }
```
