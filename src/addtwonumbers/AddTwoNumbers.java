package addtwonumbers;

import java.util.concurrent.ExecutorService;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order
 * and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * @ClassName AddTwoNumbers
 * @Description TODO
 * @Author cjj
 * @Date 2019-05-12 13:44
 * @Version 1.0
 */
public class AddTwoNumbers {
    public static void main(String[] args) {

    }

}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode listNode = new ListNode(0);
//        int length1 = getLength(l1);
//        int length2 = getLength(l2);
//        if(length1 == 0){
//            return l2;
//        }
//        if(length2 == 0){
//            return l1;
//        }
//        int minLength = length1 > length2 ? length2:length1;
//        int preSum = 0;
//        int beginSum = l1.val + l2.val;
//        if(beginSum >= 10){
//            beginSum = beginSum - 10;
//            preSum = 1;
//        }
//        ListNode beginNode = new ListNode(beginSum);
//        ListNode next1 = l1.next;
//        ListNode next2 = l2.next;
//        ListNode next = new ListNode(0);
//        for(int i = 1; i < minLength; i++){
//            if(next1 != null && next2 != null){
//                int currentSum = next1.val+next2.val+preSum;
//                if(currentSum >= 10){
//                    currentSum = currentSum -10;
//                    preSum = 1;
//
//                }
//            }
//        }
//
//
//        return listNode;

        int preSum = 0;
        int sum = 0;
        ListNode head = new ListNode(0);
        ListNode pre = head;
        //先直接计算两者，直到最短的退出
        while(l1 != null && l2 != null ){
            sum = l1.val+l2.val;
            sum += preSum;
            preSum = sum / 10;
            sum = sum % 10;
            ListNode currentNode = new ListNode(sum);
            head.next = currentNode;
            head =  currentNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode restNode = (l1 == null) ? l2:l1;
        //短的结束后，另外一个继续计算和进位
        while(restNode != null){
            sum = restNode.val;
            sum += preSum;
            preSum = sum / 10;
            sum = sum % 10;
            ListNode temp = new ListNode(sum);
            head.next = temp;
            head = temp;
            restNode = restNode.next;
        }
        //最后还剩下进位的
        if(preSum > 0){
            ListNode lastNode = new ListNode(preSum);
            head.next = lastNode;
            head = lastNode;
        }
        return pre.next;
    }

    private int getLength(ListNode listNode){
        int i = 0;
        if(listNode == null){
            return i;
        }else{
            i = 1;
        }
        ListNode next = listNode.next;
        while(next != null){
            i++;
            next = next.next;
        }
        return i;
    }
}
