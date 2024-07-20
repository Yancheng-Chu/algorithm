## Hash Table 的理解与作用

### 哈希表的理解

哈希表是一种数据结构，通过将key映射到value，以便高效地查找、插入和删除操作。哈希表通过哈希函数将键值转换为数组中的索引，以实现快速访问。


### 哈希表的作用

1. **快速查找**：可以在常数时间内找到数据。
2. **快速插入和删除**：可以在常数时间内插入和删除数据。
3. **键值对存储**：允许存储键值对，使得根据键快速查找对应的值。


### 时间复杂度

哈希函数将键映射到哈希表中的一个位置，这个位置称为Hash Bucket。当需要存储或检索一个键时，哈希表会通过哈希函数计算出键对应的哈希桶位置，然后在该位置进行操作。
无论哈希表中存储了多少元素，对于常数个元素的操作，其所需的平均时间是固定的。  

在理想情况下，如果哈希函数能够均匀分布键到表中的位置，那么冲突的概率会很低，查找操作的平均时间复杂度仍然是 O(1)。

但是，如果所有键都发生了冲突，导致所有键值对都存储在同一个链表中，那么哈希表的性能就会退化到链表的水平，查找操作的时间复杂度变为 O(N)，其中 N 是键值对的总数。  

当发生碰撞时，通过chaining或open addressing等方法来解决。

### 哈希表在算法中的作用

1. **数据去重**：通过哈希表可以快速去除重复元素。
2. **计数统计**：使用哈希表来统计元素出现的次数，例如词频统计。
3. **快速查找**：在需要频繁查找数据的场景中使用哈希表以提高效率。
4. **缓存实现**：哈希表常用于实现缓存（如 LRU 缓存）。


### 何时使用哈希表

- **哈希表**：适用于需要快速查找、插入和删除的场景。


### 示例题目

1. **Sum of two numbers**：Given an integer array nums and an integer target value target, please find the two integers in the array whose sum is the target value target, and return their array indices.  


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

1. **词频统计**：统计一段文本中每个单词出现的次数。
