/**
 * @program: Code
 * @author: KDF
 * @create: 2018-10-31 13:39
 **/
public class Solution41 {
    public static void sort(int []array){
        for(int i = 0; i<array.length; i++){
            for (int j = 0;j<array.length-i-1;j++){
                if(array[j]<array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int []a = {8,3,2,6,7,9,11,10,1,15,16,13,17};
        sort(a);
        for (int i = 0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
}



