import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(br.readLine());
    float[][] dots = new float[n][2];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      dots[i][0] = Float.parseFloat(st.nextToken());
      dots[i][1] = Float.parseFloat(st.nextToken());
    }
    float[][] graphMatrix = new float[n][n];
    float minDistance = Float.MAX_VALUE;
    HashSet<Integer> dotSet = new HashSet<>();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        float distance = getDistance(dots[i], dots[j]);
        graphMatrix[i][j] = distance;
        graphMatrix[j][i] = distance;
        if (minDistance > distance) {
          minDistance = distance;
          dotSet = new HashSet<>();
          dotSet.add(i);
          dotSet.add(j);
        }
      }
    }

    Queue<Edge> edgePQ = new PriorityQueue<>((e1, e2) -> {
      if (e1.distance < e2.distance) {
        return -1;
      } else if (e1.distance > e2.distance) {
        return 1;
      } else {
        return 0;
      }
    });
    Integer[] initDots = dotSet.toArray(new Integer[2]);
    for (int j = 0; j < n; j++) {
      if (initDots[0] != j) {
        edgePQ.offer(new Edge(initDots[0], j, graphMatrix[initDots[0]][j]));
      }
      if (initDots[1] != j) {
        edgePQ.offer(new Edge(initDots[1], j, graphMatrix[initDots[1]][j]));
      }
    }

    float answer = minDistance;
    while (dotSet.size() < n) {
      Edge edge = edgePQ.poll();
      if (dotSet.contains(edge.a)) {
        if (!dotSet.contains(edge.b)) {
          dotSet.add(edge.b);
          for (int to = 0; to < n; to++) {
            if (!dotSet.contains(to)) {
              edgePQ.offer(new Edge(edge.b, to, graphMatrix[edge.b][to]));
            }
          }
          answer += edge.distance;
        }
      } else if (dotSet.contains(edge.b)) {
        dotSet.add(edge.a);
        for (int to = 0; to < n; to++) {
          if (!dotSet.contains(to)) {
            edgePQ.offer(new Edge(edge.a, to, graphMatrix[edge.a][to]));
          }
        }
        answer += edge.distance;
      }
    }

    System.out.printf("%.2f", answer);
    br.close();
  }

  static class Edge {
    int a;
    int b;
    float distance;

    Edge(int from, int to, float distance) {
      this.a = from;
      this.b = to;
      this.distance = distance;
    }
  }

  static float getDistance(float[] dotA, float[] dotB) {
    return (float) Math.sqrt(Math.pow(dotA[0] - dotB[0], 2) + Math.pow(dotA[1] - dotB[1], 2));
  }
}