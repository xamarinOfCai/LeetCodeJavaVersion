import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LongestSubStringWithoutRepeatingCharacters0003
 * @Description 第三道题
 * @Author cjj
 * @Date 2019-06-09 15:24
 * @Version 1.0
 */
public class LongestSubStringWithoutRepeatingCharacters0003 {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> testCases = new ArrayList<String>();

        testCases.add("abcabcbb");
        testCases.add("bbbbb");
        testCases.add("pwwkew");
        testCases.add("au");

        for(int h = 0; h < testCases.size(); h++) {
            int length = s.lengthOfLongestSubString(testCases.get(h));
            System.out.println("最长的字符串的长度为 = [" + length + "]");
        }
    }

}

class Solution{
    /**
     * 计算不包含无重复子串的长度
     * 思路：逐个检查所有的子字符串，看它是否不含有重复的字符
     * 效率低下
     * @param s
     * @return
     */
    public int lengthOfLongestSubString(String s){
        int length = 1;
        if(s == null || s.length()== 0 ){
            return 0;
        }
        if(s.length() == 1){
            return length;
        }

        String maxString = "";
        for(int i = 0; i < s.length(); i++){
            String sub = String.valueOf(s.charAt(i));
            for(int j = i+1; j < s.length(); j++){
                char tempChar = s.charAt(j);
                if(sub.indexOf(tempChar) != -1){
                    //每次跳出循环时候，需要比较当前
                    // 最大的字符串与目前得到的字符串的长度
                    if(maxString.length() < sub.length()){
                        maxString = sub;
                    }
                    break;
                }else{
                    sub += tempChar;
                }
                //每次跳出循环时候，需要比较当前
                // 最大的字符串与目前得到的字符串的长度
                if(maxString.length() < sub.length()){
                    maxString = sub;
                }
            }

        }
        length = maxString.length();
        System.out.println("maxString = [" + maxString + "]");
        return length;
    }

}
