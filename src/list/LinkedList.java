package list;

public class LinkedList<T> {

	private Node<T> head;

	public Node<T> getHead() {
		return this.head;
	}

	public void addAtStart(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}

	public void setHead(Node<T> data) {
		this.head = data;
	}

	public Node<T> deleteAtStart() {
		Node<T> toDel = this.head;
		this.head = this.head.getNextNode();
		return toDel;
	}

	public Node<T> find(T data) {
		Node<T> curr = this.head;
		while (curr != null) {
			if (curr.getClass().equals(data)) {
				return curr;
			}
			curr = curr.getNextNode();
		}
		return null;
	}

	public int length() {
		if (head == null)
			return 0;
		int length = 0;
		Node<T> curr = this.head;
		while (curr != null) {
			length += 1;
			curr = curr.getNextNode();
		}
		return length;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public String toString() {
		String res = "";
		Node<T> curr = this.head;
		while (curr != null) {
			res += curr + ", ";
			curr = curr.getNextNode();
		}
		return res;
	}



	public static void main(String[] args) {
		LinkedList<Integer> integers = new LinkedList<Integer>();

		integers.addAtStart(5);
		integers.addAtStart(10);
		integers.addAtStart(2);
		integers.addAtStart(12);
		integers.addAtStart(19);
		integers.addAtStart(20);
		System.out.println(integers.length());
		System.out.println(integers.find(120));
	}

}
