package algorithm.math;

import java.util.*;

/**
 * @author 高勇01
 * @date 2021/1/28 17:15
 */
public class Math {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            Integer index = map.get(num);
            if (map.containsKey(num)) {
                res[0]=i;
                res[1]= index;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    /**
     * 三数之和
     * 结果不能有重复
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Set<Integer> twoSums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int twoSum = -nums[i];
            twoSums.add(twoSum);
            Set<Integer> set = new HashSet<>();
            for (int j = i+1; j < nums.length-1; j++) {
                if (set.contains(twoSum-nums[j])) {
                    res.add(Arrays.asList(nums[i], nums[j], twoSum-nums[j]));
                }
                set.add(nums[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Math math = new Math();
        List<List<Integer>> lists = math.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        return;
    }
}
