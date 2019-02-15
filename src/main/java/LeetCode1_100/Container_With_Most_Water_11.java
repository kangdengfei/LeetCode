package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-30 13:51
 *
 * 11. Container With Most Water
 * Medium
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 *
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 *
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 **/
public class Container_With_Most_Water_11 {
    //o(n2)
    public int maxArea(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int area = 0;
        for(int i = 0;i<height.length;i++){
            for(int j =i+1 ;j<height.length;j++){
                int len = j - i;
                int h = Math.min(height[i],height[j]);
                area = Math.max(area,len*h);
            }

        }
        return area;
    }

    //o(n)
    public int maxAreaV2(int[] height){
        if(height == null || height.length == 0)
            return 0;
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left<right){
            max = Math.max(max,(right-left)*Math.min(height[left],height[right]));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}



