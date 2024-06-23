package day_13.BOJ_S3_15651;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sel = new int[M];

        permutation(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void permutation(int sidx){
        if(sidx == M){
            for(int n : sel){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1 ; i<=N ; i++){
            sel[sidx] = i;
            permutation(sidx+1);
        }
    }

}
