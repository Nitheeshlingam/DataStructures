public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size = 0;
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail == null){
            node.next = tail;
            tail = node;
        }
        size++;
    }

    public void insertLast(int val){
        if(size == 0){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val,int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public Node get(int index){
        Node node = head;
        for(int i=0; i<index;i++){
            node = node.next;
        }
        return node;
    }

    public int deleteFirst(){
        if(size == 0)return -1;
        int val = head.value;
        head = head.next;
        if(head == null) tail = null;
        size--;
        return val;
    }

    public int delete(int index){
        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public int deleteLast(){
        if(size == 1) return deleteFirst();
        Node prev = get(size - 2);
        int val = prev.next.value;
        prev.next = null;
        size--;
        return val;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + "-> ");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void reverse(){
        if(size < 2) return ;
        Node prev = null;
        Node present = head;
        Node next = head.next;
        while(present!=null){
            present.next = prev;
            prev = present;
            present = next;
            if(next!=null) next = next.next;
        }
        head = prev;
    }

    public Node middleNode(Node head) {
        if(head == null) return head;
        Node temp = head;
        int size=1;
        while(temp.next!= null){
            temp = temp.next;
            size++;
        }
        int midIndex = size/2;
        return get(midIndex);
    }

    public static void main(String args[]){
        LL first = new LL();
        first.insertFirst(0);
        first.insertFirst(1);
        first.insertLast(2);
        first.insert(3,3);
        first.insert(10,1);
        first.insertLast(5);
        first.display();
        System.out.println(first.deleteFirst());
        first.display();
        System.out.println(first.deleteLast());
        first.display();
        System.out.println(first.delete(3));
        first.display();
        first.reverse();
        first.display();
    }
}
