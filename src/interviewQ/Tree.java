package interviewQ;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    TNode root;

    Tree(){

    }
// BFS
    public int maxDepthOfBinaryTree(TNode root){
        Queue<TNode> q1 = new LinkedList<>();

        if(root != null ){
            q1.add(root);
        }

        int level = 0;
        while (!q1.isEmpty()){
            int length = q1.size();
            for (int i = 0; i < length; i++) {
                TNode node = q1.poll();
                if (node.left !=null){
                    q1.add(node.left);
                }
                if (node.right !=null){
                    q1.add(node.right);
                }
            }
            level++;
        }
        return level;
    }


    // width of a tree
//    public int maxWidthBinaryTree(TNode root){
//        Queue<TNode> q1 = new LinkedList<>();
//
//        if(root != null ){
//            q1.add(root);
//        }
//
//        int level = 0, int max
//        int localLevelLength = 0;
//        while (!q1.isEmpty()){
//            int length = q1.size();
//            for (int i = 0; i < length; i++) {
//                TNode node = q1.poll();
//                if (node.left !=null){
//                    q1.add(node.left);
//                    localLevelLength++;
//                }
//                if (node.right !=null){
//                    q1.add(node.right);
//                    localLevelLength++;
//                }
//            }
//
//            level = Math.max();
//        }
//        return level;
//    }





}
