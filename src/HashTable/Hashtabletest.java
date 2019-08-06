package HashTable;
import java.util.LinkedList;

class HashTable2 {
	class Node {
		String key;
		String value;

		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
		public String getValue() {
			return this.value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
	// 해시테이블 버킷
	LinkedList<Node>[] Node;
	
	public HashTable2(int size) {
		this.Node = new LinkedList[size];
	}

	int HashFunction(String key) {
		int hashCode = 0;
		for (char ascii : key.toCharArray()) {
			hashCode += ascii * 31;
		}
		return hashCode;
	}

	int getIndex(int hash) {
		return hash % this.Node.length;
	}

	// 엔트리 검색
	Node searchKey(LinkedList<Node> list, String key) {
		if (list == null)
			return null;

		// 노드 검사
		for (Node node : list) {
			// 노드를 검사하여 해당하는 키값이 있는 노드를 리턴
			if (node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}
	// 해쉬테이블 put, get
	public void put(String key, String value) {
		int hash = HashFunction(key);
		int index = getIndex(hash);

		// 인덱스에 해당하는 버킷의 연결리스트 주소를 얻어온다.
		LinkedList<Node> list = Node[index];

		// 인덱스에 해당하는 버킷에 연결리스트가 없는상태이면 연결리스트 생성해서 버킷에 등록.
		if (list == null) {
			list = new LinkedList<Node>();
			Node[index] = list;
		}
		// 해당 인덱스에 존재하는 연결리스트들(노드) 검색
		Node node = searchKey(list, key);
		// 해당 인덱스에 속한 연결리스트 중에 해당 키가 존재하지 않는다면,
		if (node == null) {
			// 연결리스트 추가
			list.addLast(new Node(key, value));
		} else {
			// 해당 키가 있다면, 노드에 값 덮어쓰기.
			node.setValue(value);
		}
	}
	public String get(String key) {
		int hash = HashFunction(key);
		int index = getIndex(hash);
		// 인덱스에 해당하는 버킷의 연결리스트 주소를 얻어온다.
		LinkedList<Node> list = Node[index];
		// 해당 인덱스에 존재하는 연결리스트들(노드) 검색
		Node node = searchKey(list, key);
		// 해당 인덱스에 속한 연결리스트 중에 해당 키가 존재하지 않는다면, Not found 리턴, 있다면 키에 해당하는 노드 값 리턴
		return node == null ? "Not found" : node.getValue();
	}
}
public class Hashtabletest {

	public static void main(String args[]) {
		HashTable2 hashTable = new HashTable2(4);
		hashTable.put("ace", "1234");
		hashTable.put("two", "1235");
		hashTable.put("cao", "1236");
		hashTable.put("ni", "1237");
		hashTable.put("ma", "1238");

		System.out.println(hashTable.get("ace"));
		System.out.println(hashTable.get("two"));
		System.out.println(hashTable.get("cao"));
		System.out.println(hashTable.get("ni"));
		System.out.println(hashTable.get("ma"));
		System.out.println(hashTable.get("ma2"));
	}
}
