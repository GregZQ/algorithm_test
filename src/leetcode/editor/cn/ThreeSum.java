//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 2904 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        solution.threeSum(new int[]{3,0,-2,-1,1,2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length <= 2) {
            return list;
        }

        Arrays.sort(nums);
        int[] array = new int[3];
        array[0] = Integer.MIN_VALUE;
        array[1] = Integer.MIN_VALUE;
        array[2] = Integer.MIN_VALUE;
        for (int i = 0 ; i < nums.length - 2; i ++) {
            if (array[0] == nums[i] ) {
                continue;
            }
            array[0] = Integer.MIN_VALUE;
            array[1] = Integer.MIN_VALUE;
            array[2] = Integer.MIN_VALUE;
            int start = i + 1;
            int end = nums.length - 1;
            int current = -nums[i];
            while (start < end) {
                if (((nums[start] + nums[end]) < current) || nums[start] == array[1]) {
                    start++;
                } else if (((nums[start] + nums[end]) > current) || nums[end] == array[2]) {
                    end--;
                } else {
                    array[0] = nums[i];
                    array[1] = nums[start];
                    array[2] = nums[end];
                    list.add(Arrays.asList(array[0], array[1], array[2]));
                    start++;
                    end--;
                }
            }
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}