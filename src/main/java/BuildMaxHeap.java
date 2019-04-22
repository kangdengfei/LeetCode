import java.util.Arrays;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-21 14:24
 **/
public class BuildMaxHeap {
    /**
     * 构建最大堆
     * @param array
     * @param index
     * @param
     */

    public static void buildHeapV3(int [] array,int index,int val){
        array[index] = val;
        while (index != 0){
            int parent = (index-1) /2;
            if (array[parent] < array[index]){
                swap(array,parent,index);
                index = parent;
            }else
                break;
        }
    }

        public static void buildHeapV2(int [] array ,int index ,int value){
        array[index] = value;
        while (index != 0){
            int parent = (index-1)/2;
            if(array[parent]<array[index]){
                swap(array,index,parent);
                index = parent;
            }else {
                break;
            }
        }
    }

    public static void swap(int []array ,int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    //1.构建最大堆
    public static void buildHeap(int []array){

        for (int i = array.length/2-1;i>=0;i--){
            adjustHeap(array,i,array.length);
        }
    }
    public static void adjustHeap(int []array ,int parent ,int len){
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


    public static void main(String[] args) {
        int []arry = {9,4,6,10,3,8,1,2,5};
        System.out.println("下沉构建最大堆:");
        buildHeap(arry);
        System.out.println(Arrays.toString(arry));
        System.out.println("堆排序结果如下：");
        for (int i= arry.length-1;i>0 ;i--){
            swap(arry,0,i);
            adjustHeap(arry,0,i);
        }
        System.out.println(Arrays.toString(arry));
        System.out.println("上浮构建最大堆：");
        int []arry1 = {9,4,6,10,3,8,1,2,5};
        int [] arrayTemp = new int[arry1.length];
        for (int i = 0;i<arry1.length;i++) {
            buildHeapV2(arrayTemp,i,arry1[i]);
        }
        System.out.println(Arrays.toString(arrayTemp));
        System.out.println("堆排序结果如下：");
        for (int i= arrayTemp.length-1;i>0 ;i--){
            swap(arrayTemp,0,i);
            adjustHeap(arrayTemp,0,i);
        }
        System.out.println(Arrays.toString(arrayTemp));
    }

}



