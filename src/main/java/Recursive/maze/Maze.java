package Recursive.maze;

import java.util.Arrays;

/**
 * @Author PYJ
 * @Description 用迷宫解决递归问题
 * @Date 2020/4/7 1:54
 * @Version 1.0
 **/
public class Maze {
    //起始为(1,1)，遍历路径到(4,4)
    /**
     * 分析：需要先定义策略，策略是 下 -》 右 -》 上 -》 左
     * 如果走过了置为2，走不通置为3
     * 单线程迷宫解法,按照策略都走然后看看能否到结尾
     *
     * @param row 行位置
     * @param column 列位置
     * @param targeRow 目标行位置
     * @param targeColumn 目标列位置
     */
    public boolean walk(int[][] map, int row, int column, int targeRow, int targeColumn) {
        if (map[targeRow][targeColumn] == 1){
            throw new RuntimeException("目标位置不能是迷宫墙壁");
        }
        if (map[row][column] != 0) { //说明是障碍或者已经走过了，走不通
            return false;
        }
        map[row][column] = 2; //先置为走过
        System.out.printf("走到该点:[%d][%d]\n", row, column);
        if (row == targeRow && column == targeColumn) {
            //说明到了目标位置
            return true;
        }
        //向下走判断是否会到对应位置
        if (walk(map, row + 1, column, targeRow, targeColumn)) {
            return true;
        } else if (walk(map, row, column + 1, targeRow, targeColumn)) {
            return true;
        } else if (walk(map,row - 1, column, targeRow, targeColumn)) {
            return true;
        } else if (walk(map, row, column - 1, targeRow, targeColumn)) {
            return true;
        } else {
            map[row][column] = 3; //此路不通
            return false;
        }
    }

    public void map(int[][] map){
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }



}
