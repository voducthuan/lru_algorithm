
//Duc-Thuan Vo
//Email: thuanvd@ryerson.ca

package lru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class lruCache {
	int size;
	HashMap<Integer, item> cache_map;
	item head;
	item end;
	
	public lruCache(int pSize){
		this.size=pSize;
		this.cache_map=new HashMap<>();
		this.head= null;
		this.end=null;
	}
	
	public int getSize() {
		return size;
	}

	public HashMap<Integer, item> getCache_map() {
		return cache_map;
	}

	public item getHead() {
		return head;
	}

	public item getEnd() {
		return end;
	}

	public void reset(){
		this.cache_map=new HashMap<>();
		this.head= null;
		this.end=null;
	}
	
	public int get(int key) {
		int result=-1;
		if(cache_map.containsKey(key)){
			item pItem = cache_map.get(key);
			move(pItem);
			add(pItem);
			return pItem.value;
		}
		return result;
	}

	public void move(item pItem){
		if (pItem.pre_item!=null) {
			pItem.pre_item.next_item=pItem.next_item;
		}else{
			head=pItem.next_item;
		}
		if (pItem.next_item!=null) {
			pItem.next_item.pre_item=pItem.pre_item;
		}else{
			end=pItem.pre_item;
		}
	}
	
	public void delete(int key){
		if (cache_map.containsKey(key)) {
			if (cache_map.get(key).pre_item!=null) {
				cache_map.get(key).pre_item.next_item=cache_map.get(key).next_item;
			}else{
				head=cache_map.get(key).next_item;
			}
			if (cache_map.get(key).next_item!=null) {
				cache_map.get(key).next_item.pre_item=cache_map.get(key).pre_item;
			}else{
				end=cache_map.get(key).pre_item;
			}
		}
	}
	
	public void set(int key, int value) {
		if (cache_map.containsKey(key)) {
			item pItem=cache_map.get(key);
			pItem.value=value;
			move(pItem);
			add(pItem);
		}else{
			item new_item=new item(key, value);
			if (cache_map.size()==size) {
				cache_map.remove(end.key);
				move(end);
				add(new_item); 
			}else{
				add(new_item);
			}
			cache_map.put(key, new_item);
		}
	}		
	
	public void add(item pItem){
		pItem.next_item=head;
		pItem.pre_item=null;
		if(head!=null){
			head.pre_item = pItem;
		}	
		head = pItem;
		if(end ==null){
			end = head;
		}	
	}

	public void info(){
		System.out.println("----------LRU information------------");
		System.out.println("Map item:"+Arrays.asList(cache_map));
		System.out.println("Head key: "+head.key);
		System.out.println("Head value:"+head.value);
		System.out.println("End key:"+end.key);
		System.out.println("End value:"+end.value);
	}
	
	public static void main(String args[]) throws IOException{
		lruCache lrucache = new lruCache(3);
		lrucache.set(7, 100);
		lrucache.set(0, 99);
		lrucache.set(1, 98);
		lrucache.set(2, 97);
		lrucache.set(0, 96);
		lrucache.set(3, 95);
		lrucache.set(0, 91);
		lrucache.set(4, 82);
		
		lrucache.info();
		
		System.out.println("-----------Getting Items-------------");
		System.out.println(lrucache.get(2));
		System.out.println(lrucache.get(4));
		System.out.println(lrucache.get(3));
		
	}
}
