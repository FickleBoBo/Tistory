package day_13.BOJ_S2_15665;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;
    static int M;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
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

        int before = 0;
        for(int i=0 ; i<N ; i++){
            if(before!=arr[i]){
                sel[sidx] = arr[i];
                before = arr[i];
                permutation(sidx+1);
            }
        }
    }

}
