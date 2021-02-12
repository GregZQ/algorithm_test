//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 337 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Integer> needMap = new HashMap<>();
        Character current;
        for (int i = 0; i < t.length(); i ++) {
            current = t.charAt(i);
            if (Objects.nonNull(countMap.get(current))) {
                countMap.put(current, countMap.get(current) + 1);
            } else {
                countMap.put(current, 1);
            }
            needMap.put(current,0);
        }

        int matchCount = 0;
        for (int i =0 ; i < s.length(); i ++) {
            current = s.charAt(i);
            if (needMap.containsKey(current)) {
                needMap.put(current,  needMap.get(current) + 1);
                if (needMap.get(current).equals(countMap.get(current))) {
                    matchCount +=1;
                }
            }
        }

        return matchCount == countMap.keySet().size() && s.length() == t.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}