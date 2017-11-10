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
                   while (i < j && a[j] > x) {
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


    public static void main(String[] args){
        int []a ={12,89,46,83,34,78,93,75,38,21,40,11,31,63,29,99,62,59,4,71};
        int k= a.length-1;
        quickSort(a,0,k);
        for(int i = 0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
}
