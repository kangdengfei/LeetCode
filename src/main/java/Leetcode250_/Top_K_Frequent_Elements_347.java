package Leetcode250_;

import java.util.*;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-03-31
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 **/
public class Top_K_Frequent_Elements_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i :nums){
            if (map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else
                map.put(i,1);
        }

        Set<Integer> set = map.keySet();
        Integer[] objects = (Integer[]) set.toArray(new Integer[set.size()]);
        int[] array = new int[set.size()];
        for (int i = 0;i<set.size();i++){
            array[i] = objects[i];
        }


        createHeap(array);
        List list = new ArrayList();
        for (int i =0;i<k;i++){
            list.add(map.get(array[i]));
        }
        return list;
    }

    /**
     * 创建最小堆
     * @param nums
     *
     */
    public void createHeap(int [] nums){
        for (int i = nums.length/2-1;i>=0;i--){
            adjustHeap(i,nums.length,nums);
        }
    }

    /**
     *  调整堆
     */
    public void adjustHeap(int parent ,int len, int [] array){
        for (int i = 2*parent+1;i<len;i++){
            if (i+1<len && array[i+1] < array[i]){
                i++;
            }
            if (array[i] < array[parent]){
                swap(i,parent,array);
                parent = i;
            }else {
                break;
            }

        }
    }

    public void swap(int i ,int j, int [] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}



