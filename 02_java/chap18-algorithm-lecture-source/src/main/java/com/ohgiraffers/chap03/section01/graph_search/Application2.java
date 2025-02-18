package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 수업목표. BFS와 x, y좌표를 활용한 문제를 해결할 수 있다.(feat.배열 인덱스와 좌표는 반대 개념) */
/* 설명.
*   너비 우선 탐색(Breadth-First Search)
*   선입선출 구조의 queue를 활용한다.
*   시작 노드에서 출발해 시작 노드를 기준으로 가까운 노드를 먼저 방문하면서 탐색하는 알고리즘이다. */


public class Application2 {

    // 한 줄씩 읽어드리기 위한 메소드
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }
    /* 설명. BFS로 문제 해결을 위한 Queue */
    static Queue<Node> q = new LinkedList<>();

    /* 설명. 같은 인덱스에 있는 값을 활용해 상하좌우을 의미하는 좌표 배열들 */
    static int[] dirX = {0, 0, -1, -1};
    static int[] dirY = {1, -1, 0, 0};

    /* 설명. 배추밭 */
    static int map[][];                                 // 대칭이 되는 구조가 아니기 때문에 2차원 배열(양방향, 대칭이 아니기때문)

    /* 설명. 방문배열 */
    static boolean visit[][];                           // 양방향 관계나 대각선에 대칭되는 표가 아니다.

    /* 설명. 현재 위치에 대한 좌표 */
    static int cur_x, cur_y;

    /* 설명. 배추 받의 크기(너비,높이), 심어진 배추의 수*/
    static int M, N, K;                                 // 10, 8, 17로 파싱

    /* 설명. 필요한 배추지렁이의 수 */
    static int count;

    /* 설명. x와 y좌표를 가지는 static 내부 클래스(배추 객체를 위한) */
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine());        //파싱

        M = Integer.parseInt(st.nextToken());       // 너비, 가로, 열
        N = Integer.parseInt(st.nextToken());       // 높이, 세로, 행
        K = Integer.parseInt(st.nextToken());

        //순서 유의
        map = new int[N][M];                        // 순서 유의! (x, y 체계가 아니라 -> y,x 체계)
        visit = new boolean[N][M];

        /* 설명. 배추 심기*/
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());  // br.readLine() 배추의 위치 정보
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[y][x] = 1;                           // 좌표와 행렬이 인덱스 개념은 반대이다.

        }

        count = 0;

        /* 설명. i와 j는 캐릭터의 좌표를 뜻하며 이중 반복을 통해 캐릭터를 이동 */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                /* 설명. 방문 안한 위치에 배추가 심어져 있으면 지렁이를 뿌리자! (하나라도 있다면) */
                if (visit[i][j] == false && map[i][j] == 1) {
                    count++;
                    bfs(j, i);
                }
            }
        }
            return count;
    }
    /*설명. 배추가 상하좌우를 보고 방문하지 않고 유효한 범위 안에 또 다른 배추가 심어져 있는지 확인(방문배열 체크)*/
        private static void bfs(int x, int y) {
            q.offer(new Node(x, y));
            visit[y][x] = true;

            while (!q.isEmpty()) {
                Node node = q.poll();

                /*설명. que에서 뽑은 배추가 상하좌우를 돌려보는 로직 */
                for (int i = 0; i < 4; i++) {
                    cur_x = node.x + dirX[i];
                    cur_y = node.y + dirY[i];

                    /* 설명. 지금 보는 뱡향이 좌표로써 존재하면서 방문한 적이 없고 배추가 심어져 있다면 (방문 체크, que에 추가) */
                    if (range_check() && !visit[cur_y][cur_x] && map[cur_y][cur_x] == 1) {
                        q.offer(new Node(cur_x, cur_y));
                        visit[cur_y][cur_x] = true;
                    }
                }
            }
        }
        /* 설명. 지금 보는 위치(cur_x, cur_y)가 배추밭 범위 안인지 체크하는 유효성 검사 메소드 */
    private static boolean range_check() {
        return cur_x >= 0 && cur_x < M && cur_y >= 0 && cur_y < N;
    }

}
