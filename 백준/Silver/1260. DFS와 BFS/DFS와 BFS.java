import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 구축
        for(int i = 0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // 번호가 작은 정점부터 방문해야 하니 정렬
        for(int i=1;i<=N;i++) {
            Collections.sort(graph[i]);
        }

        // DFS
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        // BFS
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int now) {
        visited[now] = true;
        sb.append(now).append(' ');

        for(int next : graph[now]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        // 인접리스트
        while(!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(' ');

            for(int next : graph[now]) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }




}
