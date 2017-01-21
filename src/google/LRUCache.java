package google;

import java.util.HashMap;

public class LRUCache {

	public static class CacheNode {
		CacheNode next;
		CacheNode pre;
		int value;
		int key;

		public CacheNode(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

	}

	HashMap<Integer, CacheNode> map = new HashMap<>();
	int size;
	CacheNode head = null;
	CacheNode end = null;

	protected LRUCache(int size) {
		this.size = size;
	}

	public void remove(CacheNode n) {
		if (n.pre != null) {
			n.pre.next = n.next;
		} else {
			head = n.next;
		}

		if (n.next != null) {
			n.next.pre = n.pre;
		} else {
			end = n.pre;
		}

	}

	public void setHead(CacheNode n) {
		n.pre = null;
		n.next = head;

		if (head != null) {
			head.pre = n;
		}

		head = n;

		if (end == null) {
			end = head;
		}

	}

	public int get(int k) {
		if (map.containsKey(k)) {
			CacheNode n = map.get(k);
			remove(n);
			setHead(n);
			return n.value;
		}

		return -1;
	}

	public void put(int k, int v) {
		if (map.containsKey(k)) {
			CacheNode n = map.get(k);
			remove(n);
			n.value = v;
			setHead(n);
		} else {
			CacheNode created = new CacheNode(k, v);
			if (map.size() >= size) {
				map.remove(end.key);
				remove(end);
				map.put(k, created);
				setHead(created);
			} else {

				setHead(created);
			}

			map.put(k, created);

		}
	}

}
