package cn.plantlink.algorithm;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流中位数
 *
 * 中位数是有序列表中间的数，如果列表长度是偶数，中位数则是中间两个数的平均值
 */
public class DataStreamMedian {

    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    public DataStreamMedian() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    // 将数据分为两部分，最大堆的数据比最小堆的数据都要小
    // 为了保证将数据平均分配到两个堆中，在动态的操作的过程中两个堆中数据的数目之差不能超过1
    public void addNumber(Integer number) {

        maxHeap.add(number);
        minHeap.add(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {

        // input: [41, 35, 62, 4, 97, 108]
        // output: [41, 38, 41, 38, 41, 51.5]
        DataStreamMedian median = new DataStreamMedian();

        median.addNumber(41);
        System.out.println(median.findMedian());
        median.addNumber(35);
        System.out.println(median.findMedian());
        median.addNumber(62);
        System.out.println(median.findMedian());
        median.addNumber(4);
        System.out.println(median.findMedian());
        median.addNumber(97);
        System.out.println(median.findMedian());
        median.addNumber(108);
        System.out.println(median.findMedian());
    }
}
