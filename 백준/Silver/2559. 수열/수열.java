import java.io.*;
import java.util.*;

public class Main {
	static int n, k, arr[];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) // 입력.
			arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];

		int max = Integer.MIN_VALUE;
		for (int i = k; i <=n; i++)
			max = Integer.max(max, arr[i] - arr[i-k]);

		System.out.println(max);
	}
}