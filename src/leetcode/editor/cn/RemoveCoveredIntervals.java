//给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。 
//
// 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。 
//
// 在完成所有删除操作后，请你返回列表中剩余区间的数目。 
//
// 
//
// 示例： 
//
// 
//输入：intervals = [[1,4],[3,6],[2,8]]
//输出：2
//解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 1000 
// 0 <= intervals[i][0] < intervals[i][1] <= 10^5 
// 对于所有的 i != j：intervals[i] != intervals[j] 
// 
// Related Topics 贪心算法 排序 Line Sweep 
// 👍 34 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        Solution solution = new RemoveCoveredIntervals().new Solution();
        solution.removeCoveredIntervals(new int[][]{new int[]{1,3}, new int[]{2,6}, new int[]{8,10}, new int[] {15,18}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (s1,s2)->{
            if (s1[0] == s2[0]) {
                return s2[1] - s1[1];
            }
            return s1[0] - s2[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= left && intervals[i][1] <= right) {
                count++;
            } else if (intervals[i][0] >=left && intervals[i][0] < right && intervals[i][1] > right) {
                right = intervals[i][1];
            } else {
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}