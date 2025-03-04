package BinaryTree;
import java.util.*;

class TreeNode {
    int data;
    TreeNode left,right;

    TreeNode(){
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data, TreeNode left, TreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class binaryTreeTraversal{
    private static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<Integer> rootlist = new ArrayList<>();
        rootlist.add(root.data);
        result.add(rootlist);
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            List<Integer> list = new ArrayList<>();

            for(int i=0; i<size;i++){
                TreeNode Node = queue.poll();

                if(Node.left != null) {
                    queue.add(Node.left);
                    list.add(Node.left.data);
                }
                if(Node.right != null){
                     queue.add(Node.right);
                     list.add(Node.right.data);
                }
            }
            if(list.size()!=0)
            result.add(list);
        }
        return result;
    }
    private static void postOrder( TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.data);
    }
    private static void preOrder( TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.data);

        preOrder(root.left,list);
        preOrder(root.right,list);

    }
    private static void inOrder(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        inOrder(root.left,list);

        list.add(root.data);

        inOrder(root.right,list);
    }
    public static void main(String[]args){
        TreeNode Node2 = new TreeNode(2);
        TreeNode Node5 = new TreeNode(5);
        TreeNode Node6 = new TreeNode(6);
        TreeNode Node7 = new TreeNode(7);
        TreeNode Node3 = new TreeNode(3,Node5,Node2);
        TreeNode Node4 = new TreeNode(4,Node7,Node6);
        TreeNode root = new TreeNode(1,Node3,Node4);
        List<Integer> result = new ArrayList<>();

        inOrder(root,result);

        System.out.println("Inorder Traversal");

        for(int i=0; i< result.size(); i++){
            System.out.print(result.get(i));
        }
        System.out.println();

        List<Integer> resultpre = new ArrayList<>();

        preOrder(root,resultpre);

        System.out.println("PreOrder Traversal");

        for(int i=0; i< resultpre.size(); i++){
            System.out.print(resultpre.get(i));
        }
        System.out.println();
        List<Integer> resultpost = new ArrayList<>();

        postOrder(root,resultpost);

        System.out.println("postorder Traversal");

        for(int i=0; i< resultpost.size(); i++){
            System.out.print(resultpost.get(i));
        }

        System.out.println();

        System.out.println("levelorder traversal");

        List<List<Integer>> levelOrder = levelOrder(root);

        for(int i=0; i<levelOrder.size();i++){
            for(int j=0; j<levelOrder.get(i).size();j++){
                System.out.print(levelOrder.get(i).get(j)+" ");
            }
            System.out.println();
        }
        
    }

}