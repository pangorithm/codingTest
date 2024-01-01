import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[] inOrder;
  static int[] postOrder;
  static int[] leftChild;
  static int[] rightChild;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(br.readLine());
    inOrder = new int[n];
    postOrder = new int[n];

    StringTokenizer st1 = new StringTokenizer(br.readLine());
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      inOrder[i] = Integer.parseInt(st1.nextToken());
      postOrder[i] = Integer.parseInt(st2.nextToken());
    }

    leftChild = new int[n + 1];
    rightChild = new int[n + 1];

    makeTree(0, n - 1, 0, n - 1);
    searchByPreOrder(postOrder[n - 1]);

    System.out.println(sb);
    br.close();
  }

  static int makeTree(int inStart, int inEnd, int postStart, int postEnd) {
    if (inStart <= inEnd && postStart <= postEnd) {

      int root = postOrder[postEnd];
      int rootIndexByInOrder = inStart;
      for (int i = inStart; i <= inEnd; i++) {
        if (inOrder[i] == root) {
          rootIndexByInOrder = i;
          break;
        }
      }

      int leftTreeSize = rootIndexByInOrder - inStart;
      leftChild[root] = makeTree(inStart, rootIndexByInOrder - 1, postStart, postStart + leftTreeSize - 1);
      rightChild[root] = makeTree(rootIndexByInOrder + 1, inEnd, postStart + leftTreeSize, postEnd - 1);

      return root;
    }

    return 0;
  }

  static void searchByPreOrder(int node) {
    if (node == 0) {
      return;
    }

    sb.append(node).append(" ");
    searchByPreOrder(leftChild[node]);
    searchByPreOrder(rightChild[node]);
  }

}
