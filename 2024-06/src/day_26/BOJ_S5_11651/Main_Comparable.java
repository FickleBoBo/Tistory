package day_26.BOJ_S5_11651;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Comparable {

    static class Item implements Comparable<Item>{
        int x;
        int y;

        public Item(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Item o) {
            if(this.y != o.y){
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.x, o.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Item[] arr = new Item[N];

        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new Item(x, y);
        }

        // Comparable
        Arrays.sort(arr);

        for(Item item : arr){
            sb.append(item.x).append(" ").append(item.y).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
