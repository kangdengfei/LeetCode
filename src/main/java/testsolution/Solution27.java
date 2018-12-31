package testsolution;

/**
 * created  by KDF on 2017/12/12.
 * 给一个整数数组，找到最小的未出现的素数
 * 给一个数组 [2,3,5,7,11,13,17,23,29]
 返回 19
 */


public class Solution27 {
    public static int firstMissingPrime(int[] nums) {
        int len = nums.length;
        boolean flag = false;
        int m= 0;
        if(nums[0] != 2)
            return 2;
        else
            for(int i =3;i<nums[len-1];i++){
                for(int j=2;j < i-1;j++){
                    flag = false;
                    if(i%j ==0) {
                        flag = true;
                        break;
                    }
                }
                if(flag == false){
                    m++;
                    if(i != nums[m]) {
                        System.out.println(i);
                        System.out.println(nums[m]);
                        return i;
                    }
                }
            }
            return 0;
    }

    public static void main(String[] args) {
        int [] array ={2,3,5,7,11,13,17,23,29};
        System.out.println(firstMissingPrime(array));
    }
}
