/**
 * created  by KDF on 2017/10/23.
 */
/*
全排列
 */

public class Solution9{
    public static int total =0;
    public static void swap(String[] str,int i,int j){
        String st = new String();
        st = str[i];
        str[i] = str[j];
        str[j] = st;
    }

    public static boolean isSame(String[] str,int i,int j){
        if(i==j)
            return true;
        for(int a =i ;a<j;a++){
            if(str[a]==str[j]){
                return false;
            }
            return true;
        }

        return false;
    }
    public static void combition(String[] str,int start,int len){
        if(start == len-1){
            for(int i=0;i<len;i++)
            System.out.print(str[i]);
            System.out.println();
            total++;
        }else{
            for(int i=start;i<len;i++){
                if(isSame(str,start,i)){
                    swap(str,start,i);
                    combition(str,start+1,len);
                    swap(str,start,i);
                }


            }

        }

    }

    public static void main(String[] args) {
        String[] st = {"a","b","c","d"};
        combition(st,0,st.length);
        System.out.println(total);
    }

}

