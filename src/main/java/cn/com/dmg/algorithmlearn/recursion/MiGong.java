package cn.com.dmg.algorithmlearn.recursion;

/**
 * @ClassName MiGong
 * @Description 迷宫
 * @author zhum
 * @date 2022/7/20 13:43
 */
public class MiGong {
    public static void main(String[] args) {

        //创建一个二维数组 8行 7列
        int[][] map = new int[8][7];
        //上下全部设置为1
        for (int i = 0;i < 7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部设置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置中间的墙 第四行 第2，3列
        map[3][1] = 1;
        map[3][2] = 1;

        setWay(map,1,2);

        //遍历地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * 如果小球能够到[6][5]的位置则能够寻找成功
     * 当地图的map[i][j] = 0 的时候表示没有走过 1的时候标识墙 2标识可以走 3标识该位置已经走过 但是走不通
     * 再走迷宫的时候需要确定一个策略
     *  先走下面 再走右面 再走上 再走左  如果该点走不通 则回溯
     *
     * @author zhum
     * @date 2022/7/20 13:54
     * @param map 地图
     * @param i 开始位置x
     * @param j 开始位置y
     * @return boolean
     */
    public static boolean setWay(int[][] map,int i,int j){
        //首先 当map[6][5] == 2的时候表示已经走完
        if(map[6][5] == 2){
            return true;
        } else {
            if(map[i][j] == 0){
                //当前路还没有走过 按照策略走 先假定当前节点是可以走通的
                map[i][j] = 2;
                //向下走
                if(setWay(map,i+1,j)){
                    return true;
                } else if (setWay(map,i,j+1)){
                    return true;
                } else if(setWay(map,i-1,j)){
                    return true;
                } else if(setWay(map,i,j-1)){
                    return true;
                } else {
                    //此路不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map[i][j]不为0  那么可能为 1，2，3
                return false;
            }
        }

    }
}
