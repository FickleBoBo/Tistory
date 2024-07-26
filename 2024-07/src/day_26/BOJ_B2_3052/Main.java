package day_26.BOJ_B2_3052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new HashSet<>();

        for(int i=1 ; i<=10 ; i++){
            set.add(Integer.parseInt(br.readLine()) % 42);
        }

        System.out.println(set.size());
    }
}
