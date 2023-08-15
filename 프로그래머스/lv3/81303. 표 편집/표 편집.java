import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Node[] nodeArr = new Node[n];
        
        nodeArr[0] = new Node(0);
        nodeArr[0].l = new Node(-1); // 가상의 끝 노드
        nodeArr[0].l.r = nodeArr[0];
        for(int i = 1; i < n; i++){
            nodeArr[i] = new Node(i);
            nodeArr[i].l = nodeArr[i - 1];
            nodeArr[i - 1].r = nodeArr[i];
        }
        nodeArr[n - 1].r = new Node(n); //가상의 끝 노드
        nodeArr[n - 1].r.l = nodeArr[n - 1];
        
        Node cursor = nodeArr[k];
        
        Stack<Node> deletedStack = new Stack<>();
        
        for(String c : cmd) {
            switch (c.charAt(0)){
                case 'U':
                    int move = Integer.parseInt(c.split(" ")[1]);
                    for(int i = 0; i < move; i++){
                        cursor = cursor.l;
                    }
                    break;
                case 'D':
                    move = Integer.parseInt(c.split(" ")[1]);
                    for(int i = 0; i < move; i++){
                        cursor = cursor.r;
                    }
                    break;
                case 'C':
                    cursor.l.r = cursor.r;
                    cursor.r.l = cursor.l;
                    deletedStack.push(cursor);                    
                    cursor = cursor.r.no == n ? cursor.l : cursor.r;
                    break;
                case 'Z':
                    Node z = deletedStack.pop();
                    z.l.r = z;
                    z.r.l = z;
                    break;
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++){
            answer.append("O");
        }
        while(!deletedStack.empty()){
            int index = deletedStack.pop().no;
            answer.replace(index, index + 1, "X");
        }
        return answer.toString();
    }
    
    class Node{
        int no;
        Node l;
        Node r;
        
        Node(int no){
            this.no = no;
        }
    }
}