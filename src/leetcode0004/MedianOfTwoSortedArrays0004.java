package leetcode0004;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MedianOfTwoSortedArrays0004
 * @Description 0004
 * @Author cjj
 * @Date 2019-06-09 19:35
 * @Version 1.0
 */
public class MedianOfTwoSortedArrays0004 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[]nums1 = new int[]{1,2};
        int[]nums2 = new int[]{3,4};
        double result = s.findMedianSortedArrays(nums1,nums2);
        System.out.println("结果为："+result);

    }

}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i = 0,j =0;
        List<Integer> list3 = new ArrayList<>();
        while( i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                list3.add(nums1[i]);
                i++;
            }else if(nums1[i] == nums2[j]){
                list3.add(nums1[i]);
                list3.add(nums2[j]);
                i++;
                j++;
            }else{
                list3.add(nums2[j]);
                j++;
            }
        }
        if(i < nums1.length ){
            for(int k = i ;  k < nums1.length; k++){
                list3.add(nums1[k]);
            }
        }else if(j < nums2.length ){
            for(int k = j ; k < nums2.length; k++){
                list3.add(nums2[k]);
            }
        }

        double result = 0.0;
        if(list3.size() % 2 == 0){
            int right = ((list3.size()/2)> 0? list3.size()/2:0);
            int left = right-1;
            result = (list3.get(left)+list3.get(right))/2.0;
        }else{
            int index = (list3.size()/2)> 0? list3.size()/2:0;
            result = list3.get(index);
        }
        return result;
    }
}
