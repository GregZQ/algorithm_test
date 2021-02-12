//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 933 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String test = "123";
        System.out.println(test.substring(0,3));
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("acbbaca", "aba"));


    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {

        Map<Character,Integer> countMap = new HashMap<>();
        Map<Character, Integer> needMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            Integer charCount = countMap.get(t.charAt(i));
            countMap.put(t.charAt(i), Objects.isNull(charCount) ? 1 : charCount + 1);
            needMap.put(t.charAt(i),0);
        }

        int matchCount = 0;
        int left = 0, right = 0;
        int minStart =0;
        int minLength = Integer.MAX_VALUE;
        while (right < s.length()) {
            Character current = s.charAt(right);
            Integer charCount = countMap.get(current);
            if (Objects.nonNull(charCount)) {
                needMap.put(current, needMap.get(current) + 1);
                if (needMap.get(current).equals(charCount)) {
                    matchCount ++;
                }
            }

            while (matchCount == countMap.keySet().size()) {
                if ((right - left) < minLength) {
                    minStart = left;
                    minLength = right-left;
                }
                current = s.charAt(left);
                left++;
                if (Objects.nonNull(needMap.get(current))) {
                    charCount = needMap.get(current);
                    needMap.put(current, --charCount);
                    if (charCount < countMap.get(current))
                    matchCount--;
                }
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" :s.substring(minStart, minStart + minLength + 1);
    }
}
//    测试用例:"acbbaca" "aba" 测试结果:"acbba" 期望结果:"baca" stdout:
//leetcode submit region end(Prohibit modification and deletion)

}