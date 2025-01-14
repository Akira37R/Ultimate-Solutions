package BasicAlgorithms.Discretization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 离散化
 */
public class Discretization {
    static List<Integer> alls = new ArrayList<>();  // 存储所有待离散化的值

    /**
     * 初始化离散化列表（保序）
     */
    public static void init() {
        Collections.sort(alls);     // 将所有值排序
        alls = new ArrayList<>(new HashSet<>(alls));    // 去重
    }

    /**
     * 根据离散化的值k获取原来的值x
     */
    public static int get(int k) {
        return alls.get(k);
    }

    /**
     * 二分求出x对应的离散化的值
     */
    public static int find(int x) {
        int l = 0, r = alls.size() - 1;
        while (l < r) {     // 找到第一个大于等于x的位置（唯一）
            int mid = (l + r) >> 1;
            if (alls.get(mid) >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;   // 这里+1是为了映射到1, 2, ..., alls.size()
    }
}