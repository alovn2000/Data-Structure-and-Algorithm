public class Trie {
    int MAX_SIZE = 28;

    Node root;

    public Trie() {
        this.root = new Node();
    }

    class Node
    {
        int count;
        int is_end;
        Node[] children;
        public Node() {
            this.count = 1;
            this.is_end = 0;
            this.children = new Node[MAX_SIZE];
        }
    }

    int char_to_int(char a)
    {
        return a - 'a';
    }

    void insert(String data)
    {
        int i = 0;
        Node current = root;
        int index;
        while (i < data.length())
        {
            index = char_to_int(data.charAt(i));
            if (current.children[index] == null || current.children[index].count == 0)
                current.children[index] = new Node();
            else
                current.children[index].count++;
            current = current.children[index];
            i++;
        }
        current.is_end++;
    }

    boolean search(String data)
    {
        int i = 0;
        Node current = root;
        int index;
        while (i < data.length())
        {
            index = char_to_int(data.charAt(i));
            if (current.children[index] == null) return false;
            current = current.children[index];
            i++;
        }
        if (current.is_end > 0) return true;
        return false;
    }
}
