package lru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lru_run {

	public static void case_1(){
		lruCache lrucache = new lruCache(4);
		lrucache.set(7, 100);
		lrucache.set(0, 99);
		lrucache.set(1, 98);
		lrucache.set(2, 97);
		lrucache.set(0, 96);
		lrucache.set(3, 95);
		lrucache.set(0, 91);
		lrucache.set(4, 82);
		lrucache.set(2, 85);
		
		lrucache.info();
		
		System.out.println("-----------Getting Items-------------");
		System.out.println("Key 0, value: "+lrucache.get(0));
		System.out.println("Key 3, value:"+lrucache.get(3));
		System.out.println("Key 1, value:"+lrucache.get(1));
	}
	
	public static void case_2(){
		lruCache lrucache = new lruCache(3);
		lrucache.set(7, 100);
		lrucache.set(0, 99);
		lrucache.set(1, 98);
		lrucache.set(2, 97);
		lrucache.set(0, 96);
		lrucache.set(3, 95);
		lrucache.set(0, 91);
		lrucache.set(4, 82);
		lrucache.set(2, 85);
		
		lrucache.info();
		
		System.out.println("-----------Getting Items-------------");
		System.out.println("Key 4, value:"+lrucache.get(4));
		System.out.println("Key 2, value:"+lrucache.get(2));
		System.out.println("Key 1, value:"+lrucache.get(1));
	}

	public static void case_3(){
		lruCache lrucache = new lruCache(4);
		lrucache.set(1, 100);
		lrucache.set(5, 79);
		lrucache.set(6, 78);
		lrucache.set(3, 87);
		lrucache.set(8, 76);
		lrucache.set(9, 85);
		lrucache.set(10, 91);
		lrucache.set(9, 82);
		lrucache.set(7, 85);
		
		lrucache.info();
		
		System.out.println("-----------Getting Items-------------");
		System.out.println("Key 9, value:"+lrucache.get(9));
		System.out.println("Key 5, value:"+lrucache.get(5));
		System.out.println("Key 7, value:"+lrucache.get(7));
		
	}
	
	public static void main(String args[]) throws IOException{
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));  
 		System.out.println("Selecting cases (1),  (2) and (3) for running.....");
		System.out.println("1. Case 1");
		System.out.println("   - Cache size: 4");
		System.out.println("   - Input: (7,100) (0,99) (1,98) (2,97) (0,96) (3,95) (0,91) (4,82) (2,85)");
		System.out.println("   - Get items: keys=0, 3, 1");
		System.out.println("2. Case 2");
		System.out.println("   - Cache size: 3");
		System.out.println("   - Input: (7,100) (0,99) (1,98) (2,97) (0,96) (3,95) (0,91) (4,82) (2,85)");
		System.out.println("   - Get items: keys=4, 2, 1");
		System.out.println("3. Case 3");
		System.out.println("   - Cache size: 4 ");
		System.out.println("   - Input: (1,100) (5,79) (6,78) (3,87) (8,76) (9,85) (10,91) (9,82) (7,85)");
		System.out.println("   - Get items: keys=9, 5, 7");
		System.out.println();
		System.out.print("Input case number (1), (2) or (3): ");
		String select = reader.readLine();
		if (select.equals("1")) {
			case_1();
		}
		if (select.equals("2")) {
			case_2();
		}
		if (select.equals("3")) {
			case_3();
		}
	}
}
