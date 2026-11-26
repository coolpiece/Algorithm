import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Long, Integer> map = new LinkedHashMap<>(); // <숫자, 빈도>
        for(int i=0; i<n; i++) {
            long input = Long.parseLong(st.nextToken());
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        List<Long> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> { // 정렬.
            int cntA = map.get(a), cntB = map.get(b);
            if(cntA != cntB) return Integer.compare(cntB, cntA); // 빈도 기준 내림차순 정렬.
            return 0; // 빈도가 같으면 먼저 입력된 값 출력.
        });

        StringBuilder output = new StringBuilder();
        for(long num : list) {
            int cnt = map.get(num);
            for(int j=0; j<cnt; j++)
                output.append(num).append(" ");
        }
        System.out.println(output);
    }
}