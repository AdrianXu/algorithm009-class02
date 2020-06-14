学习笔记

本周学习深度优先搜索，广度优先搜索，贪心算法，二分查找

深度优先搜索：
   深度优先搜索递归写法
   
    >    visited = set() 
         def dfs(node, visited):
            if node in visited: # terminator
                # already visited 
                return 
            visited.add(node) 
            # process current node here. 
            ...
            for next_node in node.children(): 
                if next_node not in visited: 
                    dfs(next_node, visited)
   非递归写法
   
    >   def DFS(self, tree): 
        if tree.root is None: 
            return [] 
        visited, stack = [], [tree.root]
        while stack: 
            node = stack.pop() 
            visited.add(node)
            process (node) 
            nodes = generate_related_nodes(node) 
            stack.push(nodes) 
        # other processing work 
        ...

广度优先搜索
>   
    # Python
    def BFS(graph, start, end):
        visited = set()
    	queue = [] 
    	queue.append([start]) 
    	while queue: 
    		node = queue.pop() 
    		visited.add(node)
    		process(node) 
    		nodes = generate_related_nodes(node) 
    		queue.push(nodes)
    	# other processing work 
    	...
    
贪心算法
   贪心算法是一种在每一步选择中都采取在当前状态下最好或最优的选择，从而希望导致结果全局最好或最优的算法。
    
   贪心算法与动态规划的不同在于它对每个子问题的解决方案都作出选择，不能回退；动态规划则会保存以前的运算
接过，并根据以前的结果对当前进行选择，有回退功能；

   贪心算法可以解决一些最优化问题，如：求图中最小生成树，求哈夫曼编码等。然而对于工程和生活中的问题，贪心
一般不能得到我们的所要求的答案；

   一旦一个问题可以通过贪心算法解决，那么贪心法一般是解决这个问题的最好办法。由于贪心法的高效性以及其所求
得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题；

   适用场景：
        问题能够分解成子问题解决，子问题的最优解能够递推到最终问题的最优解，这种子问题最优解称为最优子结构；
        
二分查找
   1、目前函数单调性（单调递增或递减）；
    
   2、存在上下界（bounded）；
    
   3、能够通过索引访问（index accessible）；
    
   二分查找代码模版
>    
    # Python
    left, right = 0, len(array) - 1 
    while left <= right: 
    	  mid = (left + right) / 2 
    	  if array[mid] == target: 
    		    # find the target!! 
    		    break or return result 
    	  elif array[mid] < target: 
    		    left = mid + 1 
    	  else: 
    		    right = mid - 1

作业：使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
     
   查找半序数组无序的地方等同于查找里面的最小的值的问题，代码如下，同样适用二分查找的模式，左右夹逼进行查找，
当左右下标相等的时候就找到了最小值，也就是半序数组中间无序的地方；
    
    > class Solution {
        public int findMin(int[] nums) {
            int l = 0, r = nums.length - 1;
            while(l < r){
                int mid = (l + r) / 2;
                if(nums[mid] < nums[r]){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            return nums[l];
        }
     }

    