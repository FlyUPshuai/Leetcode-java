package com.leetcode.no2;

/**
 * @Description
 * @Author WangShuai
 * @date 2021/1/27 10:24
 */
public class SingleNode{

    //这里使用public主要是想省略set/get方法，实际上不可以这样做的
    public int no;//结点编号
    public String name;//结点名称
    public SingleNode next;//指向下一个节点

    //构造器
    public SingleNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "SingleNode{" +
                "no=" + no +
                ", name='" + name +
                '}';
    }

}