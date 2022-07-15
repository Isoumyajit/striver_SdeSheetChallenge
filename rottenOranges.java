import java.util.*;

public class rottenOranges {

    public static int minTimeToRot(int[][] grid, int n, int m) {

        Queue<int[]> helper = new LinkedList<>();
        int time = 0;
        int totalOrange = 0;
        int rotten = 0;
        for (int index = 0; index < grid.length; index++) {
            for (int j = 0; j < grid[index].length; j++) {
                if (grid[index][j] != 0)
                    totalOrange++;
            }
        }

        for (int index = 0; index < grid.length; index++) {
            for (int j = 0; j < grid[index].length; j++) {

                if (grid[index][j] == 2) {
                    int[] cell = new int[2];
                    cell[0] = index;
                    cell[1] = j;
                    helper.add(cell);
                }

            }
        }

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        while (!helper.isEmpty()) {

            int size = helper.size();
            while (size > 0) {
                int[] temp = helper.poll();
                int x = temp[0];
                int y = temp[1];
                for (int dir = 0; dir < 4; dir++) {

                    if (x + dx[dir] > grid.length || y + dy[dir] < 0 || y + dy[dir] > grid.length || x + dx[dir] < 0
                            || grid[x + dx[dir]][y + dy[dir]] == 2)
                        continue;
                    if (grid[x + dx[dir]][y + dy[dir]] == 1) {
                        helper.add(new int[] { x + dx[dir], y + dy[dir] });
                        rotten++;
                    }
                }
                size--;
            }
            time++;
        }

        if (totalOrange != rotten)
            return -1;
        return time;
    }

}