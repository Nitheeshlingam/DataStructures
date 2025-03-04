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

        List<Integer> resultpost = new ArrayList<>();

        postOrder(root,resultpost);

        System.out.println("postorder Traversal");

        for(int i=0; i< resultpost.size(); i++){
            System.out.print(resultpost.get(i));
        }

    }

}