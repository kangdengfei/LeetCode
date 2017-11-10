
/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args){
        int [] arry ={12,14,15,17 ,19,20,23,24,29};
        int m = 20;
        int a =binarySearch(arry,m);
        System.out.print(a);
    }
//    public static void bufferFind(int []a,int tart){
//        int star = 0;
//        int end = a.length;
//
//        while (star<end){
//            int mind = (star+end)/2;
//            if (a[mind] == tart )
//               // return a[mind];
//                System.out.print(a[mind]);
//            else if(a[mind]<tart){
//                star = mind+1;
//            }else
//                end = mind-1;
//        }
//       // return -1;
//    }

    public static int binarySearch(int []array, int target) {

         int left = 0,right = array.length-1;
         int mid = (left + right) / 2;
         while (left < right) {
         if (array[mid] < target)
             left = mid + 1;
          else
             right = mid;
          mid = (left + right) / 2;
         }
       return array[mid]== target ? mid : -1;
    }
}
