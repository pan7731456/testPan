package Recursive.queen_again;

/**
 * @Author pan
 * @Date 2020/4/13 10:17
 * @Description
 * @Version 1.0
 **/
public class Queen {
    private int max;
    private int[] values;

    static int count;

    public Queen(int max) {
        this.max = max;
        this.values = new int[max];
        place(0);
        System.out.printf("共有%d种摆法\n", count);
    }

    /**
     * 放置皇后，第几行进行放置
     *
     * @param row
     */
    private void place(int row) {
        if (row == this.max) {
            count++;
            show();
            return;
        }
        /**
         * 放置对应列
         */
        for (int i = 0; i < this.max; i++) {
            values[row] = i;
            if (check(row)) { //通过放置
                place(row + 1);
            }
        }
    }

    private boolean check(int row) {
        /**
         * 判断和之前放置的皇后是否有冲突
         */
        for (int i = 0; i < row; i++) {
            if (values[i] == values[row] ||  //同一列
                    Math.abs(row - i) == Math.abs(values[row] - values[i])) { //同一斜线
                return false;
            }
        }
        return true;
    }

    /**
     * 展示已摆好的皇后棋局
     */
    private void show() {
        for (int i = 0; i < this.max; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < this.max; i++) {
            for (int j = 0; j < this.max; j++) {
                if (values[i] == j) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
