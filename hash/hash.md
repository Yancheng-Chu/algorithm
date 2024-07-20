## 哈希表（Hash Table）的理解与作用

### 哈希表的理解

哈希表（Hash Table）是一种数据结构，通过将键（key）映射到值（value），以便高效地查找、插入和删除操作。哈希表通过哈希函数将键值转换为数组中的索引，以实现快速访问。


### 哈希表的作用

1. **快速查找**：可以在常数时间内找到数据。
2. **快速插入和删除**：可以在常数时间内插入和删除数据。
3. **键值对存储**：允许存储键值对，使得根据键快速查找对应的值。


### 时间复杂度

- **查找**：O(1)
- **插入**：O(1)
- **删除**：O(1)

哈希表的时间复杂度为 O(1) 是基于平均情况的假设，即哈希函数能够将键均匀分布在哈希表中，从而避免大量碰撞（collisions）。当发生碰撞时，通过链地址法（chaining）或开放地址法（open addressing）等方法来解决，这些方法在大多数情况下仍能保持较低的时间复杂度。

### 哈希表在算法中的作用

1. **数据去重**：通过哈希表可以快速去除重复元素。
2. **计数统计**：使用哈希表来统计元素出现的次数，例如词频统计。
3. **快速查找**：在需要频繁查找数据的场景中使用哈希表以提高效率。
4. **缓存实现**：哈希表常用于实现缓存（如 LRU 缓存）。


### 何时使用哈希表（Hashtable）

- **哈希表**：适用于需要快速查找、插入和删除的场景。


### 示例题目

1. **两数之和**：Given an integer array nums and an integer target value target, please find the two integers in the array whose sum is the target value target, and return their array indices.  
Example 1:
Input: nums=[2,7,11,15], target=9
Output: [0,1]
Explanation: Because nums [0]+nums [1]==9, returns [0,1].

Example 2:
Input: nums=[3,2,4], target=6
Output: [1,2]

Example 3:
Input: nums=[3,3], target=6
Output: [0,1]  

2. **词频统计**：统计一段文本中每个单词出现的次数。使用哈希表可以在 O(n) 时间内完成统计。
3. **有效的括号**：检查一串括号字符串是否有效。使用哈希表存储括号对，可以快速检查匹配关系。
