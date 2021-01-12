//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1069 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new LinkedList<>();
        List<Integer> current = new LinkedList<>();
        for (int i = 0 ;i < nums.length ; i ++) {
            current.add(nums[i]);
            find(current, nums);
            current.remove(0);
        }

        return result;
    }

    public void find(List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            result.add(new LinkedList<>(current));
            return;
        }
        for (int i = 0; i< nums.length; i++) {
            if (current.contains(nums[i])) {
                continue;
            }
            current.add(nums[i]);
            find(current, nums);
            current.remove(current.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}