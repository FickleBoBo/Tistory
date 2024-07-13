package day_13.BOJ_G2_11780;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_nextDp {

    // 오버플로우 주의
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 인접 행렬겸 dp 테이블
        // 직행 버스가 없으면 일단 거리를 무한대로 설정하고 자기 자신과의 거리는 0으로 설정
        int[][] dp = new int[1+N][1+N];
        for(int i=1 ; i<=N ; i++){
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }

        // i -> j에서 i번 도시를 방문한 직후에 방문한 도시를 저장하는 테이블
        int[][] next = new int[1+N][1+N];

        // 인접 행렬을 초기화하는데 같은 노선이 여러 개 들어올 수 있음
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(dp[A][B] > C){
                dp[A][B] = C;
                next[A][B] = B;
            }
        }

        // 플로이드 워셜 알고리즘
        for(int k=1 ; k<=N ; k++){
            for(int i=1 ; i<=N ; i++){
                for(int j=1 ; j<=N ; j++){
                    if(dp[i][j] > dp[i][k] + dp[k][j]){
                        dp[i][j] = dp[i][k] + dp[k][j];
                        next[i][j] = next[i][k];    // next[i][j] = k; 로 하지 않게 주의
                    }
                }
            }
        }

        // 플로이드 워셜 알고리즘 결과 테이블 출력
        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                sb.append(dp[i][j] == INF ? 0 : dp[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                // 출발지와 목적지가 같은 경우와 갈 수 없는 도시인 경우
                if(next[i][j] == 0){
                    sb.append(0);
                }
                else{
                    // 경로를 그대로 추적하므로 Queue에 담기
                    Queue<Integer> path = new ArrayDeque<>();

                    // 출발지에서 목적지까지 탐색(next[j][j] = 0 에서 종료)
                    int k = i;
                    while(k != 0){
                        path.offer(k);
                        k = next[k][j];
                    }

                    sb.append(path.size()).append(" ");
                    while(!path.isEmpty()){
                        sb.append(path.poll()).append(" ");
                    }
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
