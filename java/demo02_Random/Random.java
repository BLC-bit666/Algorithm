package demo02_Random;

/**
 * &#064;BelongsProject: algorithm
 * &#064;CreateTime: 2023-10-14  17:42
 * &#064;Description: 随机器的改造
 * &#064;Author: lanai
 */
public class Random {
    public static void main(String[] args) {
        randomPowerX();
        System.out.println(random1toRandom2());
    }

    /**
     * 任意的x，x属于[0,1),[0,x)范围上数出现的概率由x->x平方
     */
    public static void randomPowerX(){
        System.out.println(Math.max(Math.random(),Math.random()));
    }


    // region 构造 0 | 1 等概率生成器实现随机数范围转变


    /**
     * 等概率产生23-45
     * @return res
     */
    public static int random(){
        return (int)(Math.random()*23+23);
    }

    /**
     * 将给定数字生成器改造成0，1等概率生成器
     * @return 0 | 1
     */
    public static int one2two(){
        int ans=0;
        do{
            ans = random();
        }while (ans==34);
        return ans<34?0:1;
    }
    /**
     * 给定的等概率生成器[23,45]改造成等概率生成器[39,68]
     */
    public static int random1toRandom2(){
      int num = 0;
      do {
          num=(one2two() << 4) + (one2two() << 3) + (one2two() << 2) + (one2two() << 1) + one2two();//等概率生成数字0-31
      }while(num>29);
      return num+39;
    }

    /*
     * 如果   Math.random()<x?0:1  不等概率的生成固定概率的 0 | 1
     * P(0) = x ; p(1) = 1-x; 则可以使得 两次随机生成的结果不一致时 返回 ；则概率都是 p = x(1-x);
     *      do{
     *          ans = f();
     *      }while(ans == f());
     */

    //endregion

}
