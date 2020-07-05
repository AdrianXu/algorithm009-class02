学习笔记
    
   本周主要学习动态规划，分治加最优子结构，将复杂的问题分解成重复子问题，
   与递归和分治没有根本上区别；
   
   共性：找到重复子问题
   
   差异性：最优子结构，中途可以淘汰次优解
   
   
   1、人肉递归很累，效率低；
   
   2、找到最近最简方法，拆解成可重复解决子问题；
   
   3、数学归纳法思维；
   
   本质寻找重复性 -> 计算机指令集
   
   人肉递归先画出状态树、重复子状态分析；
   
递归代码模版
  
    public void recur(int level, int param) { 
    // terminator 递归终止条件
    if (level > MAX_LEVEL) { 
      // process result 
      return; 
    }
    // process current logic 执行当前逻辑
    process(level, param); 
    // drill down 递归进入下一层
    recur( level: level + 1, newParam); 
    // restore current status 清除当前层状态
    }

分治代码模版

    def divide_conquer(problem, param1, param2, ...): 
      # recursion terminator 
      if problem is None: 
    	print_result 
    	return 
      # prepare data 
      data = prepare_data(problem) 
      subproblems = split_problem(problem, data) 
      # conquer subproblems 
      subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
      subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
      subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
      …
      # process and generate the final result 
      result = process_result(subresult1, subresult2, subresult3, …)
    	
      # revert the current level states

