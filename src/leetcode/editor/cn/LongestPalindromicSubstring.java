//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6113 👎 0

 
package leetcode.editor.cn;

import java.util.List;

public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        boolean[][] palindromeFlag = new boolean[s.length()][s.length()];
        int maxLen = 1;
        int start = 0;
        int end = 0;
        for(int r = 1;r<s.length(); r++){
            for(int l =0; l<r; l++){
                if ((l+1 >= r-1 || palindromeFlag[l+1][r-1]) && s.charAt(l) == s.charAt(r)) {
                    palindromeFlag[l][r] = true;
                    if (r-l+1 > maxLen) {
                        maxLen = r-l;
                        start = l;
                        end = r;
                    }
                }
            }
        }

        return s.substring(start,end+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
