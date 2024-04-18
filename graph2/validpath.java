import java.util.*;
public class Solution {
    private static final int[] X = {0, 0, 1, 1, 1, -1, -1, -1};
    private static final int[] Y = {1, -1, 0, 1, -1, 0, 1, -1};
    public String solve(int A, int B, int C, int D, int[] E, int[] F) {
        boolean[][] vis = new boolean[A + 1][B + 1];
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int k = 0; k < C; k++) {
                    if (Math.sqrt(Math.pow(E[k] - i, 2) + Math.pow(F[k] - j, 2)) <= D) {
                        vis[i][j] = true;
                        break;
                    }
                }
            }
        }
        if (vis[0][0] || vis[A][B]) {
            return "NO";
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        vis[0][0] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            if (x == A && y == B) {
                return "YES";
            }
            for (int i = 0; i < 8; i++) {
                int newX = x + X[i];
                int newY = y + Y[i];
                if (newX >= 0 && newX <= A && newY >= 0 && newY <= B && !vis[newX][newY]) {
                    vis[newX][newY] = true;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
        return "NO";
    }
}

