package day_26.BOJ_S5_1181;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main_Lambda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for(int i=0 ; i<N ; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);

        // 람다 식으로 정렬
        list.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return Integer.compare(o1.length(), o2.length());
            }
            return o1.compareTo(o2);
        });

        for(String s : list){
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
