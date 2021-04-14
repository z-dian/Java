package 动态规划.奖学金;

import java.util.*;

public class Main{
    public static class Grade{
        long ai;
        long bi;
        public Grade(long ai,long bi){
            this.ai = ai;
            this.bi = bi;
        }
    }
    //采用贪心策略
    //1.先算出能够拿到奖学金需要的成绩
    //2.对拿到1分需要的时间进行从小到大排序
    //3.每计算一次当前成绩，看是否满足奖学金要求
    //4.如果不够，就继续学习
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int r = sc.nextInt();
            int avg = sc.nextInt();
            long time = 0;//所用时间
            long score = 0;//当前分数
            List<Grade> list = new ArrayList<Grade>();
            for(int i = 0;i<n;i++){
                long ai = sc.nextLong();
                long bi = sc.nextLong();
                score += ai;//计算每门课当前获得了多少分
                list.add(new Grade(ai,bi));
            }
            long needScore = n*avg-score;//还需要多少分达标
            if(needScore <= 0){
                System.out.println(0);
                continue;
            }
            Collections.sort(list,new Comparator<Grade>(){
                @Override
                public int compare(Grade o1,Grade o2){
                    if(o1.bi<=o2.bi)return -1;
                    else return 1;
                }
            });
            for(int i = 0;i<list.size();i++){
                Grade tmp  = list.get(i);
                if(needScore <= r-tmp.ai){
                    time += needScore*tmp.bi;
                    break;
                }else{
                    time += (r-tmp.ai)*tmp.bi;
                    needScore -= r-tmp.ai;
                }
            }
            System.out.println(time);
        }
    }
}