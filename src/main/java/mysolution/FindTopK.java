package mysolution;

import java.util.Arrays;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-02 14:21
 **/
public class FindTopK {

    //1.构建最大堆
    public static void buildHeap(int []array){

        for (int i = array.length/2-1;i>=0;i--){
            adjustHeap(array,i,array.length);
        }
    }
    public static void adjustHeapV2(int []array ,int parent ,int len){
        for (int i = 2*parent+1;i<len;i++){
            if(i+1<len && array[i+1]>array[i]){
                i++;
            }
            if(array[i]>array[parent]){
                int temp = array[parent];
                array[parent] = array[i];
                array[i] = temp;
                parent  = i;
            }else
                break;
        }
    }

    public static void swap(int [] array ,int i ,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    //构建最小堆
    public static void buildHeap(int[]array ,int k){

        for (int i = k/2-1;i>=0;i--){
            adjustHeap(array,i,k);
        }
    }

    public static void adjustHeap(int []array ,int parent ,int len){
        for (int i = 2*parent+1;i<len;i++){
            if (i+1 <len && array[i+1]<array[i]){
                i++;
            }
            if (array[i]<array[parent]){
                swap(array,i,parent);
                parent = i;
            }else {
                break;
            }
        }
    }


    public static void main(String[] args) {
        int [] array = {2,5,3,8,1,12,14,4,6,7,18,10};
//        int [] array = {2,5,8,1,12,14};
        int k = 5;
//        buildHeap(array);
//        int  k = 3;
//        for (int i = 0;i<array.length;i++) {
//            int temp = array[0];
//            array[0] = array [array.length-1-i];
//            array[array.length-1-i] = temp;
//            //调整堆
//            adjustHeap(array,0,array.length-i-1);
//        }

        buildHeap(array,k);
        System.out.println(Arrays.toString(array));

        for (int i=k;i<array.length;i++){
            if (array[i]>array[0]){
                swap(array,0,i);
                adjustHeap(array,0,k);
            }
        }
        System.out.println(Arrays.toString(array));
    }
}



