import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static HashMap<String, String> lNodeMap;
  static HashMap<String, String> rNodeMap;

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    lNodeMap = new HashMap<>();
    rNodeMap = new HashMap<>();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      String pNode = st.nextToken();
      lNodeMap.put(pNode, st.nextToken());
      rNodeMap.put(pNode, st.nextToken());
    }

    preOrder("A");
    sb.append("\n");
    inOrder("A");
    sb.append("\n");
    postOrder("A");

    System.out.println(sb);
    in.close();
  }

  static void preOrder(String pNode) {
    if (pNode.equals(".")) {
      return;
    }
    sb.append(pNode);
    preOrder(lNodeMap.get(pNode));
    preOrder(rNodeMap.get(pNode));
  }

  static void inOrder(String pNode) {
    if (pNode.equals(".")) {
      return;
    }
    inOrder(lNodeMap.get(pNode));
    sb.append(pNode);
    inOrder(rNodeMap.get(pNode));
  }

  static void postOrder(String pNode) {
    if (pNode.equals(".")) {
      return;
    }
    postOrder(lNodeMap.get(pNode));
    postOrder(rNodeMap.get(pNode));
    sb.append(pNode);
  }

}
