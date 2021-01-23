//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 769 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        solution.merge(new int[][]{new int[]{1,3}, new int[]{2,6}, new int[]{8,10}, new int[] {15,18}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (s1, s2) -> {
            if (s1[0] == s2[0]) {
                return s2[1] - s1[1];
            }
            return s1[0] - s2[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (left <= intervals[i][0] && intervals[i][1] <= right) {
                continue;
            } else if (intervals[i][0] >= left && intervals[i][0] <= right && intervals[i][1] > right) {
                right = intervals[i][1];
            } else {
                leftList.add(left);
                rightList.add(right);
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        leftList.add(left);
        rightList.add(right);

        int [][] result = new int[leftList.size()][2];

        for (int i = 0; i < leftList.size(); i ++) {
            result[i][0] = leftList.get(i);
            result[i][1] = rightList.get(i);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}