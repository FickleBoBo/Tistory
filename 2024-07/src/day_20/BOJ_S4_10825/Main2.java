package day_20.BOJ_S4_10825;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {

    static class Student implements Comparable<Student>{
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if(this.kor != o.kor){
                return Integer.compare(o.kor, this.kor);
            }
            if(this.eng != o.eng){
                return Integer.compare(this.eng, o.eng);
            }
            if(this.math != o.math){
                return Integer.compare(o.math, this.math);
            }
            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Student> students = new PriorityQueue<>();

        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            students.offer(new Student(name, kor, eng, math));
        }

        while(!students.isEmpty()){
            sb.append(students.poll().name).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
