package com.leetcode.no2;

/**
 * @Description
 * @Author WangShuai
 * @date 2021/1/27 10:31
 */
public class TestSingle {
    public static void main(String[] args) {
        //测试代码
        //创建节点
        SingleNode node1 = new SingleNode(1, "曹操");
        SingleNode node2 = new SingleNode(2, "刘备");
        SingleNode node3 = new SingleNode(3, "关羽");
        SingleNode node4 = new SingleNode(4, "张飞");
        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入英雄人物(忽略编号排序)
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);

        //自行测试（省略）
    }
}
