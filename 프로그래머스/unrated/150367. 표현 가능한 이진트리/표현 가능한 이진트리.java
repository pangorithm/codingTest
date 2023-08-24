class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            String numStr = Long.toString(numbers[i], 2);
            int length = 1;
            while(length <= numStr.length()){
                length <<= 1;
            }
            numStr = "0".repeat(length - numStr.length() - 1) + numStr;
            // System.out.println(numStr);
            
            char[] chs = numStr.toCharArray();
            Node[] nodes = new Node[chs.length];
            for(int j = 0; j < chs.length; j++){
                nodes[j] = new Node(chs[j] == '0' ? true : false);
            }
            
            makeTree(nodes, 0, nodes.length - 1);
            
            int canMakeBinaryTree = 1;
            for(Node node : nodes){
                // System.out.println(node.string());
                if(node.isDummy && node.l != -1){
                    if(!nodes[node.l].isDummy || !nodes[node.r].isDummy){
                        canMakeBinaryTree = 0;
                        break;
                    }
                }
            }
            // System.out.println(canMakeBinaryTree);
            answer[i] = canMakeBinaryTree;
        }
        
        return answer;
    }
                
    int makeTree(Node[] nodes, int start, int end){
        if (start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        Node node = nodes[mid];
        node.l = makeTree(nodes, start, mid - 1);
        node.r = makeTree(nodes, mid + 1, end);
        return mid;
    }
    
    class Node{
        boolean isDummy;
        int l = -1;
        int r = -1;
        
        Node(boolean isDummy){
            this.isDummy = isDummy;
        }

        String string(){
            return String.format("%b %d %d", this.isDummy, this.l, this.r);
        }
    }    
}