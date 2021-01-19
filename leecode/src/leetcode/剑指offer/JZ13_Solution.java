package leetcode.剑指offer;

/**
 * @author 张点
 * @description 机器人的运动范围
 * @date 2020/10/18 15:02
 **/
public class JZ13_Solution {
    int m, n, k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        //si表示i坐标数位和，sj表示j坐标数位和
        return dfs(0, 0, 0, 0);
    }

    public int dfs(int i, int j, int si, int sj) {
        //边界条件
        if (i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) +
                dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }
    /*public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i >= m || j >= n || k < sum(i, j) || visited[i][j]) {
            return 0;
        }
        visited[i][j]=true;
        return 1+dfs(i+1,j,m,n,k,visited)+dfs(i,j+1,m,n,k,visited);
    }
    //求当前格子坐标的位数和
    private int sum(int i, int j) {
        int sum  = 0;
        while (i!=0){
            sum+=i%10;
            i/=10;
        }
        while (j!=0){
            sum+=j%10;
            j/=10;
        }
        return sum;
    }*/

}
