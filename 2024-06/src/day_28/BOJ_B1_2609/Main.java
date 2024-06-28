package day_28.BOJ_B1_2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(GCD(A, B));
        System.out.println(LCM(A, B));
    }

    private static int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }

    private static int LCM(int a, int b){
        int gcd = GCD(a, b);
        return a * b / gcd;
    }

}
