package LC1125_Smallest_Sufficient_Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/smallest-sufficient-team/">Smallest Sufficient Team</a>
 * 位运算；数组；动态规划；状态压缩
 */
public class SmallestSufficientTeam {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] req_skills = {"java","nodejs","reactjs"};
        List<List<String>> people = new ArrayList<>(Arrays.asList(List.of("java"), List.of("nodejs"), Arrays.asList("nodejs", "reactjs")));
        System.out.println(Arrays.toString(solution.smallestSufficientTeam(req_skills, people)));
    }
}

/**
 * Hard af
 */
class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length, m = people.size();
        HashMap<String, Integer> skill_index = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            skill_index.put(req_skills[i], i);
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, m);
        dp[0] = 0;
        int[] prev_skill = new int[1 << n];
        int[] prev_people = new int[1 << n];
        for (int i = 0; i < m; i++) {
            List<String> p = people.get(i);
            int cur_skill = 0;
            for (String s : p) {
                cur_skill |= 1 << skill_index.get(s);
            }
            for (int prev = 0; prev < (1 << n); prev++) {
                int comb = prev | cur_skill;
                if (dp[comb] > dp[prev] + 1) {
                    dp[comb] = dp[prev] + 1;
                    prev_skill[comb] = prev;
                    prev_people[comb] = i;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        int i = (1 << n) - 1;
        while (i > 0) {
            res.add(prev_people[i]);
            i = prev_skill[i];
        }
        return res.stream().mapToInt(j -> j).toArray();
    }
}