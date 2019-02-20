package LeetCode151_200;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-19 16:17
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 *     Your returned answers (both index1 and index2) are not zero-based.
 *     You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 **/
public class Two_Sum_II_Input_array_is_sorted_167 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null){
            return null;
        }
        int start = 0;
        int end = numbers.length-1;
        while (start < end){
            int temp = numbers[start] + numbers[end];
            if (temp == target){
                return new  int [] {start+1,end+1};
            }else if(target>temp){
                start++;
            }else {
                end--;
            }
        }
        return null;
    }
}



