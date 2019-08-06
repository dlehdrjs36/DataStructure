package HashTable;
import java.util.LinkedList;

/***
 * Buckits
 * 
 * @author User
 *
 */
class hashtb {
	/***
	 * Slot
	 */
	private LinkedList<synonym>[] node;

	/***
	 * Entity Data Structure
	 * 
	 * @author User
	 *
	 */
	class synonym {
		String key;
		Object value;

		void setKey(String key) {
			this.key = key;
		}

		void setValue(Object value) {
			this.value = value;
		}

		String getKey() {
			return key;
		}

		Object getValue() {
			return value;
		}
	}

	public hashtb(int size) {
		this.node = new LinkedList[size];
	}

	private final int getHash(String key) {
		// Key값을 Char형으로 쪼갠다.
		char[] token = key.toCharArray();
		int hash = 0;
		for (char c : token) {
			hash = hash * 31 + c;
		}
		return hash;
	}
	private int getIndex(String key) {
		return getHash(key) % node.length;
	}

	/*
	public void put(String key, Object value) {
		int index = getIndex(key);
		
		
		if ( node[index] == null || node[index].equals("")) {
			node[index] = new LinkedList<synonym>();	
			
		}
	}*/
}

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
