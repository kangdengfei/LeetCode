package LeetCode101_150;

import com.sun.imageio.plugins.common.I18N;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-13 15:24
 *
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 *
 * Example 2:
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 **/

/*
hashMap保存值,
遍历一次数组，查看元素作为key在map中是否存在，不存在插入，值为1，存在判断val是否为2，是删除key，不是val加一；
最终map中只有一条记录。
 */
public class Single_Number_II_137 {
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                int val = map.get(nums[i]);
                if (val == 2)
                    map.remove(nums[i]);
                else
                    map.put(nums[i],++val);

            }else
                map.put(nums[i],1);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        int result=0;
        for (Map.Entry entry: entrySet){
            result = (int) entry.getKey();
        }

        return result;

    }

    public static int singleNumber2(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int result = 0;
        for (int i = 0;i<32;i++){
            int sum =0;
            for (int j = 0;j<nums.length;j++){
                if (((nums[j] >> i) & 1) == 1){
                    sum++;
                }
                sum = sum % 3;
            }
            result = result | sum<<i;
        }

        return result;

    }

    public int singleNumber3(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int j = 0; j < nums.length; j++) {
                if(((nums[j] >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }
            if(sum != 0) {
                ans |= sum << i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = {222,222,322,222};
        System.out.println(singleNumber(nums));


    }
}



