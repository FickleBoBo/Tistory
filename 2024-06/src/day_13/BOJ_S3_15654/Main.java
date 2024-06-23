package day_13.BOJ_S3_15654;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;
    static int M;
    static int[] sel;
    static boolean[] visited;

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
        visited = new boolean[N];

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

        for(int i=0 ; i<N ; i++){
            if(!visited[i]){
                sel[sidx] = arr[i];
                visited[i] = true;
                permutation(sidx+1);
                visited[i] = false;
            }
        }
    }

}
