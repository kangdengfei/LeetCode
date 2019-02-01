package LintCode100;


/**
 * @program: Code
 * @author: KDF
 * @create: 2018-12-02 16:39
 **/
public class Jump_Game_55 {
    public static boolean canJump(int[] nums) {
        if(nums.length >1&& nums[0]==0)return false;
        for(int i = 1;i<nums.length-1;i++){
            if(nums[i] == 0){
                boolean flag = false;
                for(int j = 0;j<i;j++){
                    if(nums[j]+j>i){
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                    return false;
            }
        }
        return true;

    }

    public static boolean canJump2(int[] nums) {
        int max = 0;
        for (int i =0;i<nums.length;i++){
            if(max < i)
                return false;
            max = Math.max(max ,i+nums[i]);

        }
        return true;
    }

    public static void main(String[] args) {
        int [] array = {2,0,1,0,1};
        System.out.println(canJump(array));
        System.out.println(canJump2(array));
    }
}



