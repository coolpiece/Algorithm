import java.io.*;
import java.util.*;

public class Main {
	static boolean[] isNotPrime = new boolean[100000];
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), cnt = 0;
		notPrime();
		for(int i=a; i<=b; i++) {
			int primeCnt = prime(i);
			if(!isNotPrime[primeCnt]) cnt++;
		}
		System.out.println(cnt);
	}

	public static void notPrime() {
		isNotPrime[0] = isNotPrime[1] = true;
		for(int i=2; i<100000; i++) {
			if(!isNotPrime[i]) {
				for(int j=2; i*j<100000; j++) // 소수의 배수는 소수가 아니다.
					isNotPrime[i*j] = true;
			}
		}
	}

	public static int prime(int n) {
		List<Integer> list = new ArrayList<>();
		for(int i = 2; i*i <=n; i++) {
			while(n % i == 0) {
				list.add(i);
				n /= i;
			}
		}
		if(n > 1) list.add(n);
		return list.size();
	}
}