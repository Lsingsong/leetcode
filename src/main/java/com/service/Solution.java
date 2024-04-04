package com.service;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    //堆排序的优先队列
    //大根堆用于升序排序（所以求最小的前k个数用大根堆），小根堆用于降序排序（所以求最大的前k个数
    //用优先队列PriorityQueue 配置大顶堆、小顶堆
    //数组不断增长，每增长一位就排序一次，所以在数据增长时将其有序化
    //中位数，对所有数值排序后，取两个数的平均值
    //中位数：中间数字或中间两个数字的均值
    //也就是说，中位数是较小的一半元素中最大的，并且也是较大的一半元素中最小的
    //通过大根堆得到较小的一半元素中最大的；小根堆得到较小的一半元素中最小的
    //如果是偶数，那就取两个顶顶/2；如果是奇数，那就直接返回任意一个顶。
    PriorityQueue<Integer> max = new PriorityQueue<>();//小顶堆，堆顶最小
    PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));//大根堆，堆顶最大

    public void Insert(Integer num) {//Insert（）读数据流

        min.offer(num);//先加入较小的
        max.offer(min.poll());//将较小部分的最大值取出（删掉），给较大的部分
        if (min.size() < max.size()) {   //平衡两个堆的数量
            min.offer(max.poll());
        }
    }

    public Double GetMedian() {//得数据的中位数
        if (min.size() > max.size()) {//奇数个
            return (double) min.peek();
        } else {//偶数个
            return (double) (min.peek() + max.peek()) / 2.0;
        }
    }

    private final int[] cnts = new int[128];
    private final Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1)
            queue.poll();
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}


