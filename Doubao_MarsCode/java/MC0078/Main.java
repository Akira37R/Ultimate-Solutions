package MC0078;

import java.util.HashMap;

public class Main {
    public static String solution(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        for (int num : cnt.keySet()) {
            if (cnt.get(num) % 5 != 0) {
                return "False";
            }
        }
        return "True";
    }

    public static void main(String[] args) {
        // You can add more test cases here
        System.out.println(solution(new int[]{1, 3, 4, 5, 6, 5, 4}).equals("False"));
        System.out.println(solution(new int[]{1, 1, 1, 1, 2, 1, 2, 2, 2, 2}).equals("True"));
        System.out.println(solution(new int[]{11, 45, 49, 37, 45, 38, 3, 47, 35, 49, 26, 16, 24, 4, 45, 39, 28, 26, 14, 22, 4, 49, 18, 4, 4, 26, 47, 14, 1, 21, 9, 26, 17, 12, 44, 28, 24, 24, 10, 31, 33, 32, 23, 41, 41, 19, 17, 24, 28, 46, 28, 4, 18, 23, 48, 45, 7, 21, 12, 40, 2, 19, 19, 28, 32, 6, 27, 43, 6, 18, 8, 27, 9, 6, 6, 31, 37, 15, 26, 20, 43, 3, 14, 40, 20}).equals("False"));
    }
}