package mysolution;

import java.util.Arrays;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-12-19 14:14
 **/
public class MegerSort {

    public static int[] merge(int [] l, int [] r){
        int [] result = new int[l.length + r.length];
        int i = 0;
        int j = 0;
        int p = 0;
        while (i<l.length && j<r.length){
            if(l[i]<= r[j]){
                result[p++]=l[i++];
            }else
                result[p++]=r[j++];
        }
        while (i<l.length){
            result[p++] = l[i++];
        }
        while (j<r.length){
            result[p++] = r[j++];
        }
        return result;
    }

    public static int [] sort(int[] array, int left ,int right){
        if(left<right){
            int mid = left + (right-left)/2;
            int []l = sort(array,left,mid);
            int [] r = sort(array,mid+1,right);
            return merge(l,r);
        }else {
            return new int[] {array[left]};
        }
    }

    public static void main(String[] args) {
//        int [] a1 = {1,4,5,7};
//        int [] a2 = {2,4,6,8};
//
//
//        int[] merge = merge(a1, a2);
//        for (int i = 0 ;i<merge.length;i++){
//            System.out.print(merge[i]);
//            System.out.print(" ");
//        }
        System.out.println();
        int [] array1 = {3,5,4,1,9,6,8,7,2};
        int[] sort = sort(array1, 0, array1.length-1);
        for(int i = 0;i<sort.length;i++){
            System.out.print(sort[i]);
            System.out.print(" ");
        }
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(sort));
    }
}



