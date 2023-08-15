import java.util.*;

class Solution {
    ArrayList<Integer> preList;
    ArrayList<Integer> postList;
    
    public int[][] solution(int[][] nodeinfo) {
        ArrayList<Node> nodeList = new ArrayList<>();
        
        for(int i = 0; i < nodeinfo.length; i++){
            nodeList.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        Collections.sort(nodeList, (v1, v2) -> { // y기준으로 내림차순, x기준으로 오름차순 정렬
            int temp = v2.y - v1.y;
            if(temp == 0){
                return v1.x - v2.x;
            }
            return temp;
        });   
        
        for(int i = 1; i < nodeList.size(); i++){ // 이진트리생성
            setBinaryTree(nodeList.get(0), nodeList.get(i));
        }
        // for(int i = 0; i < nodeList.size(); i++){
        //     System.out.println(nodeList.get(i).printNodeInfo());
        // }
        
        int[][] answer = new int[2][nodeinfo.length];        
        preList = new ArrayList<Integer>();
        postList = new ArrayList<Integer>();
        preorder(nodeList.get(0));
        postorder(nodeList.get(0));
        for(int i = 0; i < nodeinfo.length; i++){
            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }
        
        return answer;
    }
    
    void preorder(Node n){
        preList.add(n.no);
        if(n.left != null){
            preorder(n.left);
        }
        if(n.right != null){
            preorder(n.right);
        }
    }
    
    void postorder(Node n){
        if(n.left != null){
            postorder(n.left);
        }
        if(n.right != null){
            postorder(n.right);
        }
        postList.add(n.no);
    }
    
    void setBinaryTree(Node p, Node c){
        if(p.x > c.x){
            if(p.left == null){
                p.left = c;
            } else {
                setBinaryTree(p.left, c);
            }
        } else {
            if(p.right == null){
                p.right = c;
            } else {
                setBinaryTree(p.right, c);
            }
        }
    }
    
    class Node {
        int no;
        int x;
        int y;
        Node left = null;
        Node right = null;
        
        Node(int no, int x, int y){
            this.no = no;
            this.x = x;
            this.y = y;
        }
        
        String printNodeInfo(){
            return String.format("no:%2d, x:%2d, y:%2d, left:%2d, right:%2d",
                                 this.no, this.x, this.y,
                                 this.left == null ? 0 : this.left.no,
                                 this.right == null ? 0 : this.right.no);
        }
    }
}