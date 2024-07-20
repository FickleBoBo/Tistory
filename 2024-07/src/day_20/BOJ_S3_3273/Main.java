package day_20.BOJ_S3_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int X = Integer.parseInt(br.readLine());

        int left = 0;
        int right = N-1;
        int cnt = 0;

        while(left < right){
            int sum = arr[left] + arr[right];

            if(sum < X){
                left++;
            }
            else if(sum > X){
                right--;
            }
            else{
                cnt++;
                left++;
                right--;
            }
        }

        System.out.println(cnt);
    }
}
