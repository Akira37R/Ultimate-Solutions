package LC3218_MinimumCostForCuttingCakeI;

import java.util.Arrays;

/**
 * <a href=https://leetcode.cn/problems/minimum-cost-for-cutting-a-cake/>Minimum Cost For Cutting A Cake I</a>
 * 贪心；数组；动态规划；排序
 */
public class MinimumCostForCuttingCakeI {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumCost(5, 4, new int[]{1, 2, 4}, new int[]{1, 3, 4}));
    }
}

class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        int res = 0;
        int i = 0, j = 0;   // 分别倒序遍历水平切与垂直切
        while (i < m - 1 || j < n - 1) {
            if (j == n - 1 || i < m - 1 && horizontalCut[i] < verticalCut[j]) {
                res += horizontalCut[i++] * (n - j);    // 连接该行所有非连通的对应水平切的边
            } else {
                res += verticalCut[j++] * (m - i);  // 连接该列所有非连通的对应垂直切的边
            }
        }

        return res;
    }
}