package com.leetcode.no1;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
// 你可以按任意顺序返回答案。
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
//
// Related Topics 数组 哈希表



import java.util.HashMap;

class demo1 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] i1 = twoSum1(nums,5);
        int[] i2 = twoSum1(nums,7);
        System.out.println(i1[0]+"-----"+i1[1]);
        System.out.println(i2[0]+"-----"+i2[1]);

    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }

        return indexs;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] indexs = new int[2];
         // 双重循环 循环极限为(n^2-n)/2
         for(int i = 0; i < nums.length; i++){
             for(int j = nums.length - 1; j > i; j --){
                 if(nums[i]+nums[j] == target){
                    indexs[0] = i;
                    indexs[1] = j;
                    return indexs;
                 }
             }
         }
        return indexs;
    }

}

