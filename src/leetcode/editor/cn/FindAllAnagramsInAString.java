//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 463 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Integer> needMap = new HashMap<>();

        Character current;
        for (int i = 0; i < p.length(); i ++) {
            current = p.charAt(i);
            if (countMap.containsKey(current)) {
                countMap.put(current, countMap.get(current) + 1);
            }else {
               countMap.put(current, 1);
            }
            needMap.put(current, 0);
        }

        int left=0,right = 0;
        List<Integer> list = new ArrayList<>();
        int matchCount = 0;
        while (right < s.length()) {
            current = s.charAt(right);
            if (countMap.containsKey(current)) {
                needMap.put(current, needMap.get(current) +1);
                if (needMap.get(current).equals(countMap.get(current))) {
                    matchCount ++;
                }
            }

            while (matchCount == countMap.keySet().size()) {
                if ((right - left + 1) == p.length())
                    list.add(left);
                current = s.charAt(left);
                left++;
                if (needMap.containsKey(current)) {
                    needMap.put(current, needMap.get(current) -1);
                    if (needMap.get(current) < countMap.get(current)) {
                        matchCount --;
                    }
                }

            }
            right++;
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}