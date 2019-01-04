
/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args){
        int [] arry ={11,12,14,15,17 ,19,20,23,24,29,30};
        int m = 15;
        int a =binarySearch(arry,m);
        int b =binarySearch2(arry,m);
        System.out.println(a);
        System.out.println(b);
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
         int mid = 0;
         while (left <= right) {
             mid = (left + right) / 2;

             if (array[mid] < target)
                 left = mid + 1;
             else if(array[mid] > target)
                 right = mid-1;
             else
                 return mid;
         }
       return  -1;
    }

    public static int binarySearch2(int []array, int target) {

        int left = 0,right = array.length-1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right-left)/2;
            if (array[mid] < target)
                left = mid + 1;
            else if(array[mid] > target)
                right = mid-1;
            else
                return mid;
        }
        return  -1;
    }
}
