学习笔记

本周主要学习了 泛型递归、树的递归、分治、回溯算法

泛型递归
    通过函数体来进行循环（计算机汇编反复跳到之前的指令执行）：
    向下进入，向上又回到原来一层；
    java递归代码模版
>   # Java
    public void recur(int level, int param) { 
      // terminator 递归终结条件
      if (level > MAX_LEVEL) { 
        // process result 
        return; 
      }
      // process current logic 处理当前层逻辑
      process(level, param); 
      // drill down 到下一层
      recur( level: level + 1, newParam); 
      // restore current status 清理这一层
    }

  思维要点
    1、不要人肉递归；
    2、找到最近最简方法，拆解成可重复解决子问题；
    3、数学归纳法思维；
    
分治
    分治代码模版
>   # Python
    def divide_conquer(problem, param1, param2, ...): 
      # recursion terminator 终结递归
      if problem is None: 
    	print_result 
    	return 
      # prepare data 准备数据
      data = prepare_data(problem) 
      subproblems = split_problem(problem, data) 
      # conquer subproblems 分解子问题下探处理
      subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
      subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
      subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
      …
      # process and generate the final result 子结果组合
      result = process_result(subresult1, subresult2, subresult3, …)
    	
      # revert the current level states 清理当前层
      
回溯
    采用试错思想，分布解决问题
    