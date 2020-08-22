package 牛客.剑指offer;

/**
 * @ClassName JZ12_Solution
 * @Description 数值的整数次方
 * @Author 张点
 * @Date 2020/8/13 11:31
 * @Version 1.0
 **/
public class JZ12_Solution {
    /*public static double Power(double base, int exponent) {
        double res = 1.0;
        //指数为0，任何数的0次方都为1
        if (exponent == 0) return 1;
        //指数为正次方结果为乘积
        else if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                res *= base;
            }
        } else {//指数为负，负次方为1/正次方
            exponent = Math.abs(exponent);
            for(int i = 0 ;i<exponent;i++){
                res*=base;

            }
            res = 1/res;
        }
        //当底数为负时，就看指数，若指数是偶数，则结果为正，若指数为奇数，则结果为负
        //默认结果为正，若flag==false，说明指数为 奇数，则结果取反
        boolean flag = true;
        if (exponent % 2 == 1) {
            flag = false;
        }
        if (base < 0 && flag) {
            res = res * (-1);
        }
        return res;
    }*/

    public static void main(String[] args) {
        double base = -2;
        int exponent = -4;
        System.out.println(Power(base, exponent));
    }

    //快速幂
    /*public static double Power(double base, int exponent) {
        if (base != 0 && exponent == 0) return 1;
        if (base - 0.0 == 0.00001 || base - 0.0 == -0.00001) {
            if (exponent < 0) {
                throw new RuntimeException();
            } else {
                return 0.0;
            }
        }
        double res = 1.0;
        int e = exponent > 0 ? exponent : -exponent;
        while (e != 0) {
            res = (e & 1) != 0 ? res * base : base;
            base*=base;
            e=e>>1;
        }
        return exponent>0?res:1/res;
    }*/

    //随缘方法
    public static double Power(double base, int exponent) {
        double res = 1.0;
        if (exponent == 0) return 1;
        if (exponent < 0) {
            base = 1.0 / base;
        }

        while (exponent!=0) {
            res *= base;
            exponent = exponent > 0 ? (--exponent) : (++exponent);
        }
        return res;
    }
}
