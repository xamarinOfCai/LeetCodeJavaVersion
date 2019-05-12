package twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @ClassName twosum.TwoSum
 * @Description 求两数量之后等于指定值的下标
 * @Author cjj
 * @Date 2019-05-12 10:22
 * @Version 1.0
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] result = new int[2];
        int[]nums = {2, 7, 11, 15};
        int target = 9;
        Solution solution =new Solution();
        result = solution.twoSumForFast(nums,target);
        Arrays.stream(result).boxed().forEach(System.out::println);

    }
}

class Solution {
    /**
     * 将数组缓存在HashMap中，以数组的值作为key,数组的下标作为value，循环遍历即可找出来
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> valueAndKeyMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            valueAndKeyMap.put(nums[i],i);
        }
        for(int j = 0; j < nums.length; j++){
            int antherValue = target - nums[j];
            if(valueAndKeyMap.containsKey(antherValue)){
                int anotherIndex = valueAndKeyMap.get(antherValue);
                if(anotherIndex > j){
                    result[0] = j;
                    result[1] = anotherIndex;
                    break;
                }
            }
        }

        return result;
    }


    /**
     * 参考网友的答案
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumForFast(int[] nums,int target){
        Map<Integer,Integer>valueAndKeyMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int  anotherValue = target - nums[i];
            if(valueAndKeyMap.containsKey(anotherValue)){
                return new int[]{valueAndKeyMap.get(anotherValue),i};
            }
            valueAndKeyMap.put(nums[i],i);
        }
        throw new IllegalArgumentException();
    }
}
