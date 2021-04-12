import java.util.TreeMap;

public class Solution {
    static class BST
    {
        Node root;

        class Node
        {
            int key;
            int id;
            int left_child,right_child;
            Node left,right;

            public Node(int key, int id, Node left, Node right) {
                this.key = key;
                this.id = id;
                this.left_child = 0;
                this.right_child = 0;
                this.left = left;
                this.right = right;
            }
        }

        Node insert(int key, int id)
        {
            Node add_node = new Node(key, id, null, null);
            this.root = insertRecur(this.root ,add_node);
            return add_node;
        }

        private Node insertRecur(Node node, Node add_node) {
            if (node == null)
                return add_node;
            if (add_node.key < node.key) {
                node.left_child++;
                node.left = insertRecur(node.left, add_node);
            }
            if (add_node.key > node.key) {
                node.right_child++;
                node.right = insertRecur(node.right, add_node);
            }
            return node;
        }

        Node search(int key)
        {
            return searchRecur(this.root,key);
        }


        private Node searchRecur(Node node, int key)
        {
            if (node == null)
                return null;
            if (key < node.key)
                return searchRecur(node.left, key);
            if (key > node.key)
                return searchRecur(node.right,key);
            return node;
        }

        void delete(int key)
        {
            this.root = deleteRecur(this.root, key);
        }

        private Node deleteRecur(Node node, int key) {
            if (node == null)
                return null;
            if (key < node.key) {
                node.left_child--;
                node.left = deleteRecur(node.left, key);
            }
            else if (key > node.key) {
                node.right_child--;
                node.right = deleteRecur(node.right, key);
            }
            else {
                if (node.left == null) {
                    node.right_child--;
                    return node.right;
                }
                if (node.right == null) {
                    node.left_child--;
                    return node.left;
                }
                Node tmp = minVal(node.right);
                node.right_child--;
                node.key = tmp.key;
                node.id = tmp.id;
                node.right = deleteRecur(node.right, tmp.key);
            }
            return node;
        }

        private Node minVal(Node node)
        {
            Node current = node;
            Node ret = current;
            while (current != null) {
                ret = current;
                current = current.left;
            }
            return ret;
        }
        
        Node getRank(Node node)
        {
            
        }
    }

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        BST tree = new BST();
        tree.insert(10,1);
        tree.insert(15,2);
        tree.insert(5,4);
        tree.insert(12,3);
        tree.insert(17,3);
        tree.insert(14,3);
        tree.insert(11,3);
        tree.insert(3,3);
        tree.insert(6,3);
        tree.delete(11);
        System.out.println();
    }
}
