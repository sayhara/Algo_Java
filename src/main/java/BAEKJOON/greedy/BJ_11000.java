package BAEKJOON.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11000 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Lecture lecture[] = new Lecture[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lecture[i] = new Lecture(start, end);
        }

        Arrays.sort(lecture, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end; // 시작시간 같다면, 종료시간 기준
                }
                return o1.start-o2.start;   // 시작시간 기준 오름차순
            }
        });


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lecture[0].end);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lecture[i].start) {
                pq.poll();
            }
            pq.add(lecture[i].end);
        }

        System.out.println(pq.size());

    }

    public static class Lecture {

        int start;
        int end;

        public Lecture(int start, int end){
            this.start=start;
            this.end=end;
        }
    }

}



