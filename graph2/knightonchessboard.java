import java.util.*;
public class Solution {
    private static int[] dx = {1, 2, 2, 1, -1, -2, -1, -2};
    private static int[] dy = {2, 1, -1, -2, 2, 1, -2, -1};
    private static boolean isSafe(int i, int j, int N, int M) {
        return i >= 0 && i < N && j >= 0 && j < M;
    }
    private static int explore(Queue<int[]> q, int A, int B, int C, int D, int E, int F, int[][] visited) {
        while (!q.isEmpty()) {
            int distance = q.peek()[0];
            int c = q.peek()[1];
            int d = q.peek()[2];
            q.poll();
            if (c == E && d == F) return distance;
            visited[c][d] = 1;

            for (int i = 0; i < dx.length; i++) {
                int first = c + dx[i];
                int second = d + dy[i];
                if (isSafe(first, second, A, B)) {
                    if (visited[first][second] == 0) {
                        visited[first][second] = 1;
                        q.offer(new int[]{distance + 1, first, second});
                    }
                }
            }
        }
        return -1;
    }
    public int knight(int A, int B, int C, int D, int E, int F) {
        int[][] visited = new int[A][B];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, C - 1, D - 1});
        return explore(q, A, B, C - 1, D - 1, E - 1, F - 1, visited);
    }
}

