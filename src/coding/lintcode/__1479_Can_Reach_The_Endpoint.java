/**
 *  @author: Yunxiang He
 *  @date  : 2018-10-04
 */

package coding.lintcode;

/*

Given a map size of m*n, 1 means space, 0 means obstacle, 9 means the endpoint. You start at (0,0) and return whether you can reach the endpoint.


Example
    Input:[[1,1,1],[1,1,1],[1,1,9]]
    Output:true

*/

public class __1479_Can_Reach_The_Endpoint {

    public static void main(String[] args) {
        int[][] map = { { 1, 1, 1, 0, 0 }, { 1, 1, 1, 1, 1 }, { 1, 0, 1, 1, 9 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 1, 1 } };
        new __1479_Can_Reach_The_Endpoint().reachEndpoint(map);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean reachEndpoint(int[][] map) {
        return DFS(map, 0, 0);
    }

    private boolean DFS(int[][] map, int x, int y) {
        if (x >= 0 && y >= 0 && x < map.length && y < map[0].length && map[x][y] != 0) {
            if (map[x][y] == 9) {
                return true;
            } else {
                map[x][y] = 0;
                return DFS(map, x + 1, y) || DFS(map, x, y + 1) || DFS(map, x - 1, y) || DFS(map, x, y - 1);
            }
        } else {
            return false;
        }
    }

}
