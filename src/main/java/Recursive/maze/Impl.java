package Recursive.maze;

/**
 * @Author PYJ
 * @Description
 * @Date 2020/4/7 2:16
 * @Version 1.0
 **/
public class Impl {

    public static void main(String[] args) {
        // 用二维数组表示地图
        int[][] map = {
                {1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,1,1},
                {1,0,0,1,0,1,1,1,1,0,0,1},
                {1,1,0,1,0,1,1,0,0,0,0,1},
                {1,1,1,0,0,1,0,0,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1}
        };

        Maze maze = new Maze();
        maze.map(map);
        System.out.println("——————————————");
        maze.walk(map,1,1, 4 ,6);
        maze.map(map);
    }
}
