学习笔记

本周学习了字典树，并查集，高级搜索，另外了解了红黑树和AVL树

字典树
   即Trie树，又称单词查找树或键树，是一种树形结构树，典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。
   
   优点：最大限度的减少无谓的字符串比较，查询效率比哈希表高；
   
   基本性质
   
   1、结点本身不存完整单词；
   
   2、从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串；
   
   3、每个结点的所有子结点路径代表的字符都不相同；
   
    class Trie(object):
     
   	def __init__(self): 
   		self.root = {} 
   		self.end_of_word = "#" 
    
   	def insert(self, word): 
   		node = self.root 
   		for char in word: 
   			node = node.setdefault(char, {}) 
   		node[self.end_of_word] = self.end_of_word 
    
   	def search(self, word): 
   		node = self.root 
   		for char in word: 
   			if char not in node: 
   				return False 
   			node = node[char] 
   		return self.end_of_word in node 
    
   	def startsWith(self, prefix): 
   		node = self.root 
   		for char in prefix: 
   			if char not in node: 
   				return False 
   			node = node[char] 
   		return True

并查集

   适用场景，组团、配对问题；
   
   基本操作
   
   makeSet(s):建立一个新的并查集，其中包含s个单元素集合；
   
   unionSet(s,y):把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并。
   
   find(x):找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以。

     class UnionFind { 
     	private int count = 0; 
     	private int[] parent; 
     	public UnionFind(int n) { 
     		count = n; 
     		parent = new int[n]; 
     		for (int i = 0; i < n; i++) { 
     			parent[i] = i;
     		}
     	} 
     	public int find(int p) { 
     		while (p != parent[p]) { 
     			parent[p] = parent[parent[p]]; 
     			p = parent[p]; 
     		}
     		return p; 
     	}
     	public void union(int p, int q) { 
     		int rootP = find(p); 
     		int rootQ = find(q); 
     		if (rootP == rootQ) return; 
     		parent[rootP] = rootQ; 
     		count--;
     	}
     }
     
剪枝、DFS、BFS

初级搜索

1、朴素搜索

2、优化方式：不重复、剪枝

3、搜索方向
    
   DFS：depth first search 深度优先搜索
   
   BFS：breadth first search 广度优先搜索
    
   双向搜索、启发式搜索
   
启发式搜索
    
启发式函数：h(n),它用来评价那些结点最有希望的是一个我们要找的结点，会返回一个非负实数，也可以认为是从结点n的目标结点路径的估计成本；

启发式函数是一种告知搜索方向的方法，它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标；
    
    def AstarSearch(graph, start, end):
    	pq = collections.priority_queue() # 优先级 —> 估价函数
    	pq.append([start]) 
    	visited.add(start)
    	while pq: 
    		node = pq.pop() # can we add more intelligence here ?
    		visited.add(node)
    		process(node) 
    		nodes = generate_related_nodes(node) 
       unvisited = [node for node in nodes if node not in visited]
    		pq.push(unvisited)
    		
AVL树  

1、平衡二叉搜索树

2、平衡因子{-1, 0, 1}(左子树高度减去右子树高度，有时相反)

3、通过旋转操作进行平衡（左旋，右旋，左右旋，有左旋）

不足：需要额度存储信息，调整次数频繁

红黑树（Red-black Tree）

红黑树是一种近似平衡的二叉搜索树（Binary Search Tree），它能确保任何一个结点的左右子树高度差小于两倍；

每个结点要么红色，要么黑色；

根结点是黑色；

每个叶结点（空结点）是黑色的；

不能有相邻接的两个红色结点；

从任一结点到其每个叶子结点所有路径都包含相同数目的黑色结点。