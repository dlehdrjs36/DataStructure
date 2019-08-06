package HashTable;

import java.util.LinkedList;

/** 
 * HashTable Sample
 * @author dglee
 *
 */
class HashTables {
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

	LinkedList<Node>[] data;

	public HashTables(int size) {
		// 해쉬테이블 생성시 해쉬테이블 크기만큼 연결리스트 생성
		this.data = new LinkedList[size];
	}

	/***
	 * 해쉬코드를 얻는 메소드
	 * 해쉬코드 값이 같으면 덮어쓰기 된다.
	 * @param key
	 * @return
	 */
	int getHashCode(String key) {
		// 키값(문자열)을 쪼개서 아스키코드를 더한 값을 해쉬코드로 한다.
		int hashCode = 0;
		for (char c : key.toCharArray()) {
			hashCode += c;
		}
		return hashCode;
	}

	/***
	 * 해쉬코드를 통해 저장될 인덱스를 구한다.
	 * 인덱스가 같으면 연결리스트로 다음 연결리스트 주소를 가리키게 한다.
	 * @param hashCode
	 * @return
	 */
	int convertToIndex(int hashCode) {
		return hashCode % data.length;
	}

	Node searchKey(LinkedList<Node> list, String key) {
		if (list == null)
			return null;

		for (Node node : list) {
			if (node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}
	void put(String key, String value) {
		int hashCode = getHashCode(key);
		int index = convertToIndex(hashCode);
		System.out.println("Index :"+ index + " hashCode :" + hashCode + " Key :"+ key + " Value :" + value);
		LinkedList<Node> list = data[index];

		if (list == null) {
			list = new LinkedList<Node>();
			data[index] = list;
		}

		Node node = searchKey(list, key);
		if (node == null) {
			list.addLast(new Node(key, value));
		} else {
			node.setValue(value);
		}
	}

	public String get(String key) {
		int hashCode = getHashCode(key);
		int index = convertToIndex(hashCode);
		LinkedList<Node> list = data[index];
		Node node = searchKey(list, key);

		return node == null ? "Not found" : node.getValue();
	}

}

public class HashTable {
	public static void main(String[] args) {
		HashTables ht = new HashTables(3);
		ht.put("sung", "She is pretty");
		ht.put("jin", "She is model");
		ht.put("hee", "She is angel");
		ht.put("min", "She is cute");
		ht.put("min", "She is cute2");
		System.out.println();
		System.out.println(ht.get("sung"));
		System.out.println(ht.get("jin"));
		System.out.println(ht.get("hee"));
		System.out.println(ht.get("min"));
		System.out.println(ht.get("jae"));
	}
}
