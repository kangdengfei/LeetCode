package Leetcode250_;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-03-22
 *
 * Ipv4地址可以转为int类型
 **/

public class IpV4ToInt {
    public static Integer transferString(String string){
        String[] split = string.split("\\.");
        int result = 0;
        for (int i = 0;i<split.length;i++){
            int temp = Integer.parseInt(split[i]) << 8*i;
            result = result | temp;
        }
        return result;
    }

    public static int ip2Int(String ipString) {
        // 取 ip 的各段
        String[] ipSlices = ipString.split("\\.");
        int rs = 0;
        for (int i = 0; i < ipSlices.length; i++) {
            // 将 ip 的每一段解析为 int，并根据位置左移 8 位
            int intSlice = Integer.parseInt(ipSlices[i]) << 8 * i;
            // 求与
            rs = rs | intSlice;
        }
        return rs;
    }

    public static void main(String[] args) {
        String string = "255.255.255.127";
        System.out.println(transferString(string));
        System.out.println(ip2Int(string));//所以int类型的取值范围为（- 2^31 ~ 2^31 -1）
    }
}



