import java.util.Arrays;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-10-26 09:23
 **/
public class MyHeapSort {


    //调整堆 parent需要调整的节点
    public static void adjustHeap(int []array,int parent,int length){
        int temp = array[parent];
        for(int i = 2*parent+1; i<length;i = 2*i+1){
            if(i+1<length && array[i]<array[i+1]){
                i++;
            }
            if(array[i]>temp){
                array[parent] = array[i];
                parent = i;
            }else {
                break;
            }
            array[parent]= temp;
        }
    }

    public static void swap(int []array,int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void sort(int []arryay){
        //构建堆，从右向左，从下向上
        for (int i = arryay.length/2-1; i>=0; i--){
            adjustHeap(arryay,i,arryay.length);
        }
        //开始排序
        for (int i = arryay.length-1;i>0;i--){
            swap(arryay,i,0);
            adjustHeap(arryay,0,i);
        }
    }

    public static void main(String[] args) {
        int []arry = {8,12,4,5,9,11,2,10,6,13};
        sort(arry);
        System.out.println(Arrays.toString(arry));
        for (int i =0;i<arry.length;i++){
            System.out.println(arry[i]);
        }
    }

}



