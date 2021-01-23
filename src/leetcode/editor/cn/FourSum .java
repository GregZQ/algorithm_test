//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 719 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length <= 2) {
            return list;
        }

        Arrays.sort(nums);
        int[] array = new int[3];
        array[0] = Integer.MIN_VALUE;
        array[1] = Integer.MIN_VALUE;
        array[2] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (array[0] == nums[i]) {
                continue;
            }
            array[0] = Integer.MIN_VALUE;
            array[1] = Integer.MIN_VALUE;
            array[2] = Integer.MIN_VALUE;
            int start = i + 1;
            int end = nums.length - 1;
            int current = target -nums[i];
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

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }

        List<List<Integer>> currentList = new ArrayList<>();
        Arrays.sort(nums);

        int current = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == current) {
                continue;
            }
            current = nums[i];


            int[] tmp = new int[nums.length - i -1];
            for (int j = i + 1; j < nums.length; j ++) {
                tmp[j - i - 1] = nums[j];
            }
            List<List<Integer>> result = threeSum(tmp, target- current);
            for (int j = 0; j < result.size(); j ++) {
                List<Integer> aaa = result.get(j);
                currentList.add(Arrays.asList(current, aaa.get(0),aaa.get(1), aaa.get(2)));
            }
        }

        return currentList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}