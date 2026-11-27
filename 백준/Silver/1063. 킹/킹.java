import java.io.*;
import java.util.*;

public class Main {
    static final List<String> dirs = List.of("R", "L", "B", "T", "RT", "LT", "RB", "LB");
    static final int[] dr = {1, -1, 0, 0, 1, -1, 1, -1};
    static final int[] dc = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] king, stone;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        king = parsing(st.nextToken());
        stone = parsing(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++)
            move(dirs.indexOf(br.readLine()));

        StringBuilder output = new StringBuilder();
        output.append((char) (king[0] + 'A' - 1)).append(king[1]).append('\n').append((char) (stone[0] + 'A' - 1)).append(stone[1]);
        System.out.println(output);
    }

    public static int[] parsing(String input) { // 입력 받은 좌표 파싱.
        return new int[]{input.charAt(0) - 'A' + 1, input.charAt(1) - '0'};
    }

    public static void move(int dir) {
        int nkr = king[0] + dr[dir], nkc = king[1] + dc[dir];
        if (nkr < 1 || nkr > 8 || nkc < 1 || nkc > 8) return;

        if (nkr == stone[0] && nkc == stone[1]) { // 킹이랑 돌이 겹친 경우.
            int nsr = stone[0] + dr[dir], nsc = stone[1] + dc[dir];
            if (nsr < 1 || nsr > 8 || nsc < 1 || nsc > 8) return;
            stone[0] = nsr;
            stone[1] = nsc;
        }
        king[0] = nkr;
        king[1] = nkc;
    }
}