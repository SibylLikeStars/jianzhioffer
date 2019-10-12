package leetcode.utils;

/**
 * 含两个指向的链表
 */
public class RandomListNode {
    public int label;
    public RandomListNode next = null;
    public RandomListNode random = null;

    public RandomListNode(int label) {
        this.label = label;
    }
}
