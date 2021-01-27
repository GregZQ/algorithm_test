//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 657 👎 0

package leetcode.editor.cn;
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        solution.canPartition(new int[]{1,5,11,5});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int value = 0;
        for (int i = 0 ; i < nums.length; i ++) {
            value += nums[i];
        }

        if (value % 2 !=0) {
            return false;
        }

        value = value / 2;

        // 确定状态： 背包重量 value & 第j个物品的价值
        // 确定选择:  第J个物品是否选择加入
        boolean[] dp = new boolean[value+1];
        dp[0] = true;
        for (int j = 1; j <= nums.length; j++) {
            for (int i = value; i >= 0; i--) {
                int tmpValue = i - nums[j-1];
                if (tmpValue >= 0) {
                    dp[i] = dp[i- nums[j-1]] || dp[i];
                }
            }
        }

        return dp[value];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}