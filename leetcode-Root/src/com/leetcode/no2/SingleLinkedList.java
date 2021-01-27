package com.leetcode.no2;

import java.util.Stack;

/**
 * @Description
 * @Author WangShuai
 * @date 2021/1/27 10:30
 */
class SingleLinkedList{
    //初始化一个头节点，头节点不需要动
    private SingleNode head = new SingleNode(0,"");

    //返回头节点
    public SingleNode getHead(){
        return this.head;
    }

    /**
     *  基本方法
     */

    //统计单链表的有效节点个数
    public static int getLength(SingleNode head){
        SingleNode temp = head;
        int count = 0;
        while (true){
            if (temp.next == null){
                break;
            }
            count ++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 添加节点到单向链表
     * 思路：不考虑编号顺序
     * 1、找到当前链表的最后一个节点
     * 2、将最后这个节点的next指针指向新的节点
     */
    public void add(SingleNode node){
        //因为头节点不能移动，因此我们需要一个辅助来遍历链表
        SingleNode temp = head;
        //遍历链表，找到最后一个
        while (true){
            if (temp.next == null ){
                break;
            }
            //如果没有到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向链表的最后
        //最后将这个节点的next指向新节点
        temp.next = node;
    }

    /**
     *  添加节点时，将节点按顺序添加到指定的节点
     *  如果有这个序号的节点，则会添加失败，并提示失败信息
     */
    public void addByOrder(SingleNode node){
        //因为头节点不能移动，因此我们还是需要一个辅助变量temp来帮助我们添加到指定的位置
        //单链表需要将temp指向添加位置的前面一个元素，才可以添加，不然添加不了
        SingleNode temp = head;
        //标志添加的节点是否存在，默认为false,默认不存在
        boolean flag = false;
        while (true){
            //说明temp已经在链表的最后了
            if (temp.next == null){
                break;
            }
            //如果当前节点的下一个(next)节点的no的大于所要添加的节点，那么位置就找到了
            if (temp.next.no > node.no){
                break;
                //添加的节点编号重复了
            }else if (temp.next.no == node.no){
                flag = true;
                break;
            }
            //后移，遍历链表
            temp = temp.next;
        }
        if (flag){
            System.out.println("编号已经存在，无法加入，重复编号信息："+
                    node+"与之冲突的编号节点信息："+temp.next);
        }else {//插入节点
            node.next = temp.next;
            temp.next = node;

        }
    }

    //修改节点的信息，根据编号来修改，no编号不能被修改
    public void update(SingleNode newNode){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
        }
        //不为空，找到想要修改的节点（根据编号no）
        //其实这里可以是temp=head，但是没意义，因为head不可能大于null，我们初始化的时候就给head赋值了
        SingleNode temp = head.next;
        boolean flag = false;//节点是否存在
        while (true){
            //这里不能temp.next，更新数据想要查到最后一个，如果temp.next，那么它只要判断下一个是null就会退出，从而不会判断no是否相等
            //而且如果这里是temp.next，那么temp开始就不能赋值为head.next，不然会空指针异常
            if (temp == null){
                break;
            }
            if (temp.no == newNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据false是否找到节点
        if (flag){//找到了
            temp.name = newNode.name;
        }else {//没有找到
            System.out.println("没有找到与之对应编号的节点，无法修改");
        }
    }

    //删除节点，想要找到想要删除的节点的前一个节点，才能把它删除
    //还是那样，head不能动，想要一个辅助变量temp
    public void delete(int no){
        SingleNode temp = head;
        //标准是否找到节点
        boolean flag = false;
        while (true){
            //已经到了链表的最后面
            if (temp.next == null){
                break;
            }
            //找到想要删除的节点
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("删除的节点不存在，编号："+no);
        }
    }

    //显示链表中的所有消息
    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，需要一个辅助变量来遍历
        SingleNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp.next);
            //将temp后移，一定要后移
            temp = temp.next;
        }
    }

    //=============================拓展方法(面试)====================================

    //查找单链表中倒数第k个节点
    public SingleNode findLastIndexNode(int i,SingleNode head){
        int count = getLength(head);
        int num = count-i;
        if (head.next == null){
            return null;
        }
        if (num<0){
            return null;
        }
        SingleNode temp = head.next;
        for (int j = 0; j < num; j++) {
            temp = temp.next;
        }
        return temp;
    }

    //链表数据反转
    public static void reverse(SingleNode head){
        //如果链表只有一个节点，直接返回
        if(head.next == null || head.next.next == null){
            return ;
        }
        //辅助变量，帮助我们遍历原来的链表temp
        SingleNode temp = head.next;
        SingleNode next = null;//指向当前节点（temp）的下一个节点
        //建立反转表用到的临时节点
        SingleNode reverseHeroNode = new SingleNode(0,"");
        //遍历原来的链表，反转链表中的数据
        while (temp != null){
            //保存当前节点的下一个节点，以防止丢失
            next = temp.next;
            ////将后一个节点指向前一个节点
            temp.next = reverseHeroNode.next;
            //认购将临时节点指向新的节点
            reverseHeroNode.next = temp;
            temp = next;
        }
        head.next = reverseHeroNode.next;
    }

    /**
     * 从尾到头打印单链表
     * 方式一:反转后遍历，缺点是破坏表结构
     * 方式二:利用栈的数据结构特点：先进后出，压入栈后取出就实现了逆序打印
     *
     * 使用栈的方式实现逆序打印
     */

    public static void reversePrint(SingleNode head){
        if (head.next == null){
            return;//空列表
        }
        //创建栈，将链表的节点压入栈中
        Stack<SingleNode> nodeStack = new Stack<>();
        //辅助变量temp协助链表的遍历
        SingleNode temp = head.next;
        while (temp != null){
            nodeStack.push(temp);
            temp = temp.next;//后移
        }
        while (nodeStack.size()>0){
            System.out.println(nodeStack.pop());
        }
    }

    //使用递归反向打印单链表
    public static void recursionReversePrint(SingleNode head){
        if (head.next != null){
            recursionReversePrint(head.next);
        }
        if (head.no != 0){System.out.println(head.no + ":" + head.name);}
    }

}