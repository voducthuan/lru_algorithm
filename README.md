# LRU Cache

**A. To run the program**

1. Execute java class
   e.g., java lru_run
2. Or execute jar file
   e.g., java -jar lru_cache.jar

LRU cache program supports options of 3 cases (they can be modified manually) for running.

Example:

Selecting cases (1),  (2) and (3) for running.....
1. Case 1
   - Cache size: 4
   - Input: (7,100) (0,99) (1,98) (2,97) (0,96) (3,95) (0,91) (4,82) (2,85)
   - Get items: keys=0, 3, 1
2. Case 2
   - Cache size: 3
   - Input: (7,100) (0,99) (1,98) (2,97) (0,96) (3,95) (0,91) (4,82) (2,85)
   - Get items: keys=4, 2, 1
3. Case 3
   - Cache size: 4 
   - Input: (1,100) (5,79) (6,78) (3,87) (8,76) (9,85) (10,91) (9,82) (7,85)
   - Get items: keys=9, 5, 7

Input case number (1), (2) or (3): 1

Sample output of case 1:

----------LRU information------------
Map item:[{0=lru.item@15db9742, 2=lru.item@6d06d69c, 3=lru.item@7852e922, 4=lru.item@4e25154f}]
Head key: 2
Head value:85
End key:3
End value:95
-----------Getting Items-------------
Key 0, value: 91
Key 3, value:95
Key 1, value:-1


**B. JUnit test in LRU Cache**

LRU program has LRUTestCases.java to support test cases on: set method, get method, size of cache, head item, end item, map items.
