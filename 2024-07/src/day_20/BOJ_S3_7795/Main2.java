package day_20.BOJ_S3_7795;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr1 = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0 ; i<N ; i++){
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            int[] arr2 = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i=0 ; i<M ; i++){
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            int cnt = 0;
            int st1 = N-1;
            int st2 = M-1;

            while(true){
                if(arr1[st1] > arr2[st2]){
                    cnt += st2 + 1;
                    st1--;
                }
                else{
                    st2--;
                }

                if(st1 < 0 || st2 < 0) break;
            }

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
