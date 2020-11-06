package JUnitTest;

import static org.junit.Assert.*;
import org.junit.Test;

import lru.item;
import lru.lruCache;
import org.junit.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class LRUTestCases {

	@Test
    public void set_method() {
		lruCache lrucache = new lruCache(4);
		lrucache.set(7, 100);
		item pItem=lrucache.getCache_map().get(7);
		assertEquals(pItem.getKey(), 7);
		assertEquals(pItem.getValue(), 100);
    }
	@Test
    public void cache_size() {
		lruCache lrucache = new lruCache(4);
		assertEquals(lrucache.getSize(), 4);
    }
	@Test
    public void cache_Head_End() {
		lruCache lrucache = new lruCache(3);
		lrucache.set(7, 100);
		lrucache.set(0, 99);
		lrucache.set(1, 98);
		lrucache.set(2, 97);
		
		item pItem_head=lrucache.getCache_map().get(2);
		item pItem_end=lrucache.getCache_map().get(0);
		assertEquals(pItem_head.getKey(), 2);
		assertEquals(pItem_head.getValue(), 97);
		assertEquals(pItem_end.getKey(), 0);
		assertEquals(pItem_end.getValue(), 99);
    }
	
	@Test
    public void get_method() {
		lruCache lrucache = new lruCache(3);
		lrucache.set(7, 100);
		lrucache.set(0, 99);
		lrucache.set(1, 98);
		lrucache.set(2, 97);
		lrucache.set(3, 90);
		lrucache.set(5, 91);
		int value_1=lrucache.get(5);
		int value_2=lrucache.get(2);
		int value_3=lrucache.get(0);
		assertEquals(value_1, 91);
		assertEquals(value_2, 97);
		assertEquals(value_3, -1);		
    }

	@Test
    public void cache_map_items() {
		lruCache lrucache = new lruCache(4);
		lrucache.set(7, 100);
		lrucache.set(0, 99);
		lrucache.set(1, 98);
		lrucache.set(2, 97);
		lrucache.set(3, 90);
		lrucache.set(3, 91);
		lrucache.set(6, 94);
		lrucache.set(0, 95);
		item pItem_1=lrucache.getCache_map().get(0);
		item pItem_2=lrucache.getCache_map().get(6);
		item pItem_3=lrucache.getCache_map().get(3);
		item pItem_4=lrucache.getCache_map().get(2);

		assertEquals(pItem_1.getKey(), 0);
		assertEquals(pItem_1.getValue(), 95);
		assertEquals(pItem_2.getKey(), 6);
		assertEquals(pItem_2.getValue(), 94);
		assertEquals(pItem_3.getKey(), 3);
		assertEquals(pItem_3.getValue(), 91);
		assertEquals(pItem_4.getKey(), 2);
		assertEquals(pItem_4.getValue(), 97);
	}
}
