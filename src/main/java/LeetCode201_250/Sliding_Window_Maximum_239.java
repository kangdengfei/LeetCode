package LeetCode201_250;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-04-03
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 **/

/*
使用双端队列时间复杂度为o(1)，队列中保存着数组元素的下标
1.队头元素保存着是最大值。进入队列时先判断队头元素的下标是否过期。然后从队尾元素开始比较。
2.待插入元素比队尾元素小且队列不为空时不做处理。当队列为空时直接进队
3.待插入元素比队尾元素大时，把队列中比他小的元素全部出队列。
 */
public class Sliding_Window_Maximum_239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0 ||nums.length<k){
            return new int[0];
        }
        ArrayDeque<Integer> queue = new ArrayDeque();
        int [] array = new int[nums.length+1-k];
        int index = 0;
        for (int i = 0;i<nums.length;i++){
            if (!queue.isEmpty() &&  queue.peekFirst()<(i-k+1)){
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offer(i);
            if (i>=k-1){
                array[index++] = nums[queue.peek()];
            }
        }

        return array;
    }


    public int[] maxSlidingWindowV2(int[] nums, int k) {
        if (nums == null || k == 0 || nums.length < k) return new int[0];
        int[] res = new int[nums.length-k+1];
        int index = 0;
        Deque<Integer> queue = new ArrayDeque<>(); //queue to save index
        for (int i = 0; i < nums.length; i++) {
            //丢弃队首那些超出窗口长度的元素 index < i-k+1
            if (!queue.isEmpty() && queue.peek() < i-k+1) queue.poll();
            //队首的元素都是比后来加入元素大的元素，所以存储的index对应的元素是从小到大
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) queue.pollLast();
            queue.offer(i);
            if (i >= k-1) res[index++] = nums[queue.peek()];
        }
        return res;
    }

    public static void main(String[] args) {

        int [] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));

    }
}



