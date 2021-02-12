//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
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
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4951 👎 0

package leetcode.editor.cn;
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring(" ");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int [] word = new int[1000];
        int left = 0, right = 0;
        Character current;
        int max = 0;
        while (right < s.length()) {
            current = s.charAt(right);
            word[current - 'a'+256] ++;
            if(word[current - 'a' + 256] == 1) {
                max = Math.max(max, right - left + 1);
            }

            Character tmp;
            while (word[current - 'a' + 256] > 1) {
                tmp = s.charAt(left);
                left ++;
                word[tmp - 'a' + 256] --;
            }

            right ++;
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}