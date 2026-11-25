import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) { // 해시맵에 넣기.
            input = br.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet()); // 리스트로 옮겨서 정렬.
        list.sort((a, b) -> { // 정렬.
           int cntA = map.get(a), cntB = map.get(b);
           if(cntA != cntB) return cntB - cntA; // 개수 큰 순서로 정렬.
           return a.compareTo(b); // 개수 같으면 사전 순 정렬.
        });

        System.out.println(list.get(0));
    }
}