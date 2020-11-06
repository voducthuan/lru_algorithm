// Duc-Thuan Vo
// Email: thuanvd@ryerson.ca

package lru;
public class item {
	int key;
	int value;
	item pre_item;
	item next_item;

	public item(int pKey, int pValue){
		this.key=pKey;
		this.value=pValue;
		pre_item=null;
		next_item=null;
	}
	 
	public int getKey() {
		return key;
	}

	public void setKey(int pKey) {
		this.key = pKey;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int pValue) {
		this.value = pValue;
	}

	public item getPre_item() {
		return pre_item;
	}

	public void setPre_item(item pPre_item) {
		this.pre_item = pPre_item;
	}

	public item getNext_item() {
		return next_item;
	}

	public void setNext_item(item pNext_item) {
		this.next_item = pNext_item;
	}


}
