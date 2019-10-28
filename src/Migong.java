public class Migong {
    public static void main(String[] args) {
        //1.先创建一个二维数组，模拟迷宫
        //地图
        int[][]map=new int[8][7];
        //使用1 表示墙
        //上下全部置为1
      for(int i=0;i<7;i++){
          map[0][i]=1;
          map[7][i]=1;
      }
        //左右全部置为1
      for(int i=0;i<8;i++){

          map[i][0]=1;
          map[i][6]=1;
      }
        //设置迷宫挡板
        map[3][1]=1;
        map[3][2]=1;
       //初始化完毕,开始输出地图
        for (int[] ints : map) {
            for (int i : ints) {
                System.out.print(i+"    ");
            }
            System.out.println();
        }
        //使用递归回溯给小球找路
        setWay(map,1,1);
        System.out.println("------------------找路完成----------------------");
        for (int[] ints : map) {
            for (int i : ints) {
                System.out.print(i+"    ");
            }
            System.out.println();
        }
    }
    //使用递归回溯来给小球找路
    /**
     * 1. map表示地图
     * 2. i j从【1,1】位置开始找，如果小球可以到map[6,5].则说明通路找到了
     * 3. 如果找到通路了就返回true 否则返回false
     * 4. 当map[i][j]=0的时候，表示该店还没有走过，当为1表示墙，当为2表示是一个通路，可以走；如果是3表示该位置已经走过，但是走不通
     * 5. 在走迷宫的时候需要确定一个策略(方法)，下->右->上->左，如果该点走不通，就再回溯
     * */
    public static boolean setWay(int [][] map,int i,int j){
        //给出递归条件
        if(map[6][5]==2){//说明通路已经找到了
            return true;
        }else{
            if(map[i][j]==0){//如果当前这个点还没有走过
                map[i][j]=2;//假定该点可以走通
                //向下走
                if(setWay(map,i+1,j)){
                    return true;
                }
                //向右走
                else if(setWay(map,i,j+1)){
                    return true;
                }
                //向上走
                else if(setWay(map,i-1,j)){
                    return true;
                }
                //向左走
                else if(setWay(map,i,j-1)){
                    return true;
                }else{
                    //说明该点是走不通的
                    map[i][j]=3;
                    return false;
                }

            }
            //map[i][j]!=0? 可能是1 2 3
            else{
                return false;
            }
        }
    }
}
