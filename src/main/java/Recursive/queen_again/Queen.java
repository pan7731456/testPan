package Recursive.queen_again;

/**
 * @Author PYJ
 * @Description 八皇后位置摆法详解 用递归
 * @Date 2020/4/12 22:07
 * @Version 1.0
 **/
public class Queen {
    /**
     * 代表要摆多少个皇后
     */
    private int max;
    /**
     * 皇后的摆法，其中下标代表第几行
     */
    private int[] values;
    /**
     * 代表共有多少种摆法
     */
    static int count;

    /**
     * 构建一个皇后摆法
     *
     * @param max
     */
    public Queen(int max) {
        this.max = max;
        this.values = new int[max];
        place(0); //直接在构造器中摆皇后
        System.out.printf("共有%d种摆法\n",count);
    }

    /**
     * 代表对第几行的皇后进行摆放，同时也就是说摆第几个皇后
     * 因为皇后不能同一行，同一列，同一斜线
     * 因此第几行作为下标，先摆后摆都是一样，因此严格按照第几行到最大行的顺序进行摆放
     *
     * @param row
     */
    private void place(int row){
        if (row == this.max){ //说明已经摆完
            count++;
            show();
            return;
        }
        //继续摆皇后
        /**
         * 代表摆第几列，由于是棋谱，因此行列大小相同，因此最大列是max
         */
        for (int i = 0; i < this.max; i++) {
            values[row] = i; //先在棋谱上摆上该位置
            //判断该位置是否满足条件
            if (check(row)){
                //通过继续摆下一个皇后
                place(row + 1);
            }
            //不通过继续列数中寻找摆法
        }
    }

    private boolean check(int row) {
        /**
         * 遍历判断是否和已经摆好的皇后冲突
         */
        for (int i = 0; i < row; i++) {
            if (values[row] == values[i] || //说明同一行
                    Math.abs(row - i) == Math.abs(values[row] - values[i]) //是否为同一斜线
            ){
                return false;
            }
        }
        return true;
    }

    /**
     * 展示已摆好的皇后棋谱
     */
    private void show(){
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
}
