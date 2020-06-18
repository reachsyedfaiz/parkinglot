package com.syed.lrucache;

import java.util.HashMap;

class Entry {
	int value;
	int key;
	Entry left;
	Entry right;
}


public class LRUCache {

	HashMap<Integer, Entry> lruCache;
	
	Entry start, end;
	
	int LRU_SIZE = 4;
	
	public LRUCache() {
		lruCache = new HashMap<Integer, Entry>();
	}

	public int getEntry(int key) {
		if (lruCache.containsKey(key)) 
		{
			Entry entry = lruCache.get(key);
			remove(entry);
			addToTop(entry);
			return entry.value;
		}
		return -1;
	}

	public void putEntry(int key, int value) {
		if (lruCache.containsKey(key)) 
		{
			Entry entry = lruCache.get(key);
			entry.value = value;
			remove(entry);
			addToTop(entry);
		} else {
			Entry newnode = new Entry();
			newnode.left = null;
			newnode.right = null;
			newnode.value = value;
			newnode.key = key;
			if (lruCache.size() > LRU_SIZE) 
			{
				lruCache.remove(end.key);
				remove(end);				
				addToTop(newnode);

			} else {
				addToTop(newnode);
			}

			lruCache.put(key, newnode);
		}
	}
	public void addToTop(Entry node) {
		node.right = start;
		node.left = null;
		if (start != null)
			start.left = node;
		start = node;
		if (end == null)
			end = start;
	}

	public void remove(Entry node) {

		if (node.left != null) {
			node.left.right = node.right;
		} else {
			start = node.right;
		}

		if (node.right != null) {
			node.right.left = node.left;
		} else {
			end = node.left;
		}
	}
	public static void main(String[] args) throws java.lang.Exception {
		LRUCache lrucache = new LRUCache();
		lrucache.putEntry(1, 1);
		lrucache.putEntry(10, 15);
		lrucache.putEntry(15, 10);
		lrucache.putEntry(10, 16);
		lrucache.putEntry(12, 15);
		lrucache.putEntry(18, 10);
		lrucache.putEntry(13, 16);

		System.out.println(lrucache.getEntry(1));
		System.out.println(lrucache.getEntry(10));
		System.out.println(lrucache.getEntry(15));

	}
}