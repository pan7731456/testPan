package Recursive.queen;

/**
 * @Author PYJ
 * @Description 递归八皇后
 * @Date 2020/4/12 21:36
 * @Version 1.0
 **/
public class QueenEight {
    static int count; //共有多少种摆法
    private int max; //共摆多少个皇后
    private int[] values; //存放的皇后位置,下标代表第几行，值代表第几列

    public QueenEight(int max) {
        this.max = max;
        this.values = new int[max];
    }

    public void queen(){
        place(0); //从第一个位置开始摆放皇后
        System.out.printf("共有%d种摆法 \n", count);
    }

    /**
     * 放置皇后
     *
     * @param num 放置第几个皇后
     */
    private void place(int num){
        if (num == this.max){
            //说明皇后已经放完
            count++; //说明摆法+1
            show(); //展示摆法结果
            return;
        }
        /**
         * i代表位置，代表该行所处的该列
         * 先优先放置，再进行递归判断
         */
        for (int i = 0; i < this.max; i++) {
            //先放置该皇位到一个位置，判断是否有冲突
            //依次遍历判断
            values[num] = i;
            if (check(num)){ // 说明该放置满足，继续放置
                place(num + 1);
            }
            //如果冲突那么就下一列，进行判断
        }
        //这样就会遍历输出所有的皇后位置结果
    }

    /**
     * 判断皇后摆放的位置是否正确
     *
     * @param num 第几个皇后
     * @return
     */
    private boolean check(int num){
        for (int i = 0; i < num; i++) {
            //判断存储的数据里面是否有冲突
            if (values[i] == values[num] ||  // 说明同一列
                    Math.abs(num - i) == Math.abs(values[num] - values[i]) //说明同一斜线
            ){
                return false;
            }
        }
        return true;
    }

    private void show(){
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] +" ");
        }
        System.out.println();
    }
}
