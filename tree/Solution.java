import java.util.ArrayList;
class Solution {
    public int numIslands(char[][] grid) {
        int counter = 0;
        int m = grid.length;
        for (int i = 0; i < m; i++) {
            int n = grid[i].length;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
                    ArrayList<Integer> ele = new ArrayList<Integer>() {
                    };
                    grid[i][j] = '0';
                    ele.add(i);
                    ele.add(j);
                    list.add(ele);

                    while (!list.isEmpty()) {
                        ArrayList<Integer> node = list.remove(0);
                        int x = node.get(0);
                        int y = node.get(1);
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            list.add(new ArrayList<Integer>() {
                                {
                                    add(x - 1);
                                    add(y);
                                }
                            });
                            grid[x - 1][y] = '0';
                        }

                        if (x + 1 < m && grid[x + 1][y] == '1') {
                            list.add(new ArrayList<Integer>() {
                                {
                                    add(x + 1);
                                    add(y);
                                }
                            });
                            grid[x + 1][y] = '0';
                        }

                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            list.add(new ArrayList<Integer>() {
                                {
                                    add(x);
                                    add(y - 1);
                                }
                            });
                            grid[x][y - 1] = '0';
                        }

                        if (y + 1 < n && grid[x][y + 1] == '1') {
                            list.add(new ArrayList<Integer>() {
                                {
                                    add(x);
                                    add(y + 1);
                                }
                            });
                            grid[x][y + 1] = '0';
                        }
                    }
                }
            }
        }
        return counter;
    }
}