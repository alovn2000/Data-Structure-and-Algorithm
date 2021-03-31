class Heap {
    int MAX_SIZE = 100000;
    Node[] item;
    int size;

    public Heap() {
        this.item = new Node[MAX_SIZE];
        this.size = 0;
    }

    class Node {
        int key;
        int meta_data;

        public Node(int key, int meta_data) {
            this.key = key;
            this.meta_data = meta_data;
        }
    }

    private int parent(int i) { return i / 2; }
    private int left(int i) { return i * 2; }
    private int right(int i) { return i * 2 + 1; }


    public void push(int key, int metadata)
    {
        item[++size] = new Node(key, metadata);
        up(size);
    }


    public Node pop()
    {
        Node ret = item[1];
        item[1] = item[--size];
        down(1);
        return ret;
    }


    private void up(int i)
    {
        while (i > 1 && item[i].key > item[parent(i)].key) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void down(int i)
    {
        int biggest = i;
        if (left(i) <= size && item[i].key < item[left(i)]. key) biggest = left(i);
        if (right(i) <= size && item[i].key < item[right(i)]. key) biggest = right(i);
        if (biggest != i) {
            swap(i,biggest);
            down(biggest);
        }

    }

    void swap(int i , int j)
    {
        Node temp = item[i];
        item[i] = item[j];
        item[j] = temp;
    }

    void deleteAt(int key)
    {
        int pos = 0;
        for (int i = 1 ; i < size; i++) {
            if (item[i].key == key)
            {
                pos = i;
                break;
            }
        }
        if (pos == 0) return;
        item[pos] = item[--size];
        up(pos);
        down(pos);
    }
}
