package search;

import java.io.*;
import java.util.*;

public class BJ_1991 {

    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertNode(head, root, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();
        
    }

    public static void insertNode(Node temp, char root, char left, char right) {

        if (temp.root == root) { // 노드 선언
            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = (right == '.' ? null : new Node(right, null, null));
        } else { // 값 입력
            if (temp.left != null) insertNode(temp.left, root, left, right);
            if (temp.right != null) insertNode(temp.right, root, left, right);
        }

    }

    // 전위순회
    public static void preOrder(Node node){
        if(node==null) return;
        System.out.print(node.root);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위순회
    public static void inOrder(Node node){
        if(node==null) return;
        inOrder(node.left);
        System.out.print(node.root);
        inOrder(node.right);
    }

    // 후위순회
    public static void postOrder(Node node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.root);
    }

    public static class Node {

        char root;
        Node left;
        Node right;

        public Node(char root, Node left, Node right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }

    }
}
