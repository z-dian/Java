package 面试算法练习.练习;

/**
 * Description: 大数相加
 * Created by zhang on 2021/1/23 13:21
 */
public class bigdecimal_add {
    public static String add(String a, String b) {
        StringBuilder a1 = new StringBuilder(a).reverse();
        StringBuilder b1 = new StringBuilder(b).reverse();
        int l1 = a1.length();
        int l2 = b1.length();
        int len = Math.max(l1, l2);
        if (l1 < l2) {
            for (int i = l1; i < l2; i++) {
                a1.append("0");
            }
        }else {
            for(int i = l2;i<l1;i++){
                b1.append("0");
            }
        }

        StringBuilder res = new StringBuilder();
        int c = 0;
        for(int i =0;i<len;i++){
            int curSum = Integer.parseInt(String.valueOf(a1.charAt(i)))+Integer.parseInt(String.valueOf(b1.charAt(i)))+c;
            int mod = curSum%10;
            res.append(mod);
            c=curSum/10;
        }
        if(c>0){
            res.append(c);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "182674891235";
        String b = "1826748912";
        System.out.println(add(a,b));
    }
}
