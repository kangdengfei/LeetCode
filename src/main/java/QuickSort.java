import java.util.Stack;

/**
 * 快速排序
 */
public class QuickSort {
    public static void quickSort(int []a,int l,int r){
           if(l<r) {
               int i = l;
               int j = r;
               int x = a[l];
               while (i < j) {
                   while (i < j && a[j] >=x) {
                       j--;
                   }
                   if (i < j) {
                       a[i] = a[j];
                       i++;
                   }
                   while (i < j && a[i] < x) {
                       i++;
                   }
                   if (i < j) {
                       a[j] = a[i];
                       j--;
                   }
               }
               a[i] = x;
               quickSort(a, l, i - 1);
               quickSort(a, i + 1, r);
           }
    }
//public static void quickSort(int s[], int l, int r)
//{
//    if (l < r)
//    {
//        //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
//        int i = l, j = r, x = s[l];
//        while (i < j)
//        {
//            while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
//                j--;
//            if(i < j)
//                s[i++] = s[j];
//
//            while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
//                i++;
//            if(i < j)
//                s[j--] = s[i];
//        }
//        s[i] = x;
//        quickSort(s, l, i - 1); // 递归调用
//        quickSort(s, i + 1, r);
//    }
//}


    public static void quickSort2(int []array){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(array.length-1);
        while (!stack.isEmpty()){
            int end = stack.pop();
            int start = stack.pop();
            int i = partion(array,start,end);
            if (i>start){
                stack.push(start);
                stack.push(i-1);
            }
            if (end>i){
                stack.push(i+1);
                stack.push(end);
            }
        }

    }

    public static int partion(int []array ,int start,int end){
        int l = start;
        int r = end;
        int temp = array[l];
        while (l<r){
            while (l<r && array[r]>=temp){
                r--;
            }
            if (l<r){
                array[l] = array[r];
            }
            while (l<r && array[l]<temp){
                l++;
            }
            if (l<r)
                array[r] =array[l];
        }
        array[l] =temp;
        return l;
    }


    public static void quickSort3(int[] array,int left ,int right){
        if(left < right){
            int i = left;
            int j = right;
            int temp = array[left];
            while (i<j){
                while (i<j && array[j] >= temp){
                    j--;
                }
                if(array[j]<temp){
                    array[i] = array[j];
                    i++;
                }
                while (i<j && array[i] < temp){
                    i++;
                }
                if (array[i] >= temp){
                    array[j] = array[i];
                    j--;
                }
            }
            array[i] = temp;
            quickSort3(array,left,i-1);
            quickSort(array,i+1,right);
        }

    }
    public static void main(String[] args){
//        int []a ={12,89,46,83,34,78,93,75,38,21,40,11,31,63,29,99,62,59,21,71};
//        int k= a.length-1;
//        quickSort(a,0,k);
//        for(int i = 0;i<a.length;i++)
//            System.out.print(a[i]+" ");
//        int []a2 ={12,89,46,83,34,78,93,75,38,21,40,11,31,63,29,99,62,59,21,71};
//        System.out.println();
//        quickSort2(a2);
//        for(int i = 0;i<a.length;i++)
//            System.out.print(a[i]+" ");
        int [] a3 = {4,6,3,8,7,1,2};
        quickSort3(a3,0,a3.length-1);
        for(int i = 0;i<a3.length;i++)
            System.out.print(a3[i]+" ");
    }



    public void quickSort4(int [] array,int left,int right){
        while (left < right){
            int i = left;
            int j = right;
            int temp = array[i];
            while (i<j){
                while (i<j && array[j] > temp){
                    j--;
                }
                if (array[j] <= temp){
                    array[i] = array[j];
                    i++;
                }
                while (i < j && array[i] < temp){

                }
            }
        }

    }
}
