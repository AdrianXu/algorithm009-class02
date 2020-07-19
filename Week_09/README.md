学习笔记

# **高级动态规划**

一、递归、分治、动态规划复习

递归：函数调用自身。

分治：分而治之，通常需要使用递归实现。

动态规划：适合有重复子问题的情况，其思想为分治加上最优子结构，通常使用顺推形式进行动态递推。

共性：找到重复子问题。

差异性：最优子结构、中途可以淘汰次优解。

二、进阶版动态规划

动态规划问题的复杂度来源是状态定义和状态转移方程。

状态拥有更多维度（二维、三维或者更多，甚至需要压缩）。
状态转移方程更加复杂。
本质：内功、逻辑思维、数学。

不同路径二

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0){
            return 0;
        }
        int rn = obstacleGrid.length;
        int cn = obstacleGrid[0].length;
        int[][] dp = new int[rn][cn];
        int i = 0;
        while(i < rn && obstacleGrid[i][0] != 1 ){
            dp[i][0] = 1;
            i++;
        }
        int j = 0;
        while(j < cn && obstacleGrid[0][j] != 1 ){
            dp[0][j] = 1;
            j++;
        };
        for(i = 1; i < rn; i++){
            for(j = 1; j < cn; j++){
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[rn-1][cn-1];
    }
    
# **字符串算法**

一、字符串基础知识

在Java和Python中，字符串是不可变的。

在Java中，字符串是引用类型，因此==比较两个字符串的引用是否相同而不是判断字符串内容是否相等，需要通过equals或equalsIgnoreCase判断字符串内容是否相等。

二、字符串匹配算法

字符串匹配算法用于匹配模式在字符串中第一次出现的位置，其中字符串的长度是m，模式的长度是n，满足m>n。

暴力法的时间复杂度是O(mn)。

Rabin-Karp算法基于哈希实现，平均时间复杂度是O(m+n)。

Knuth-Morris-Pratt算法利用最大前缀信息，减少不必要的比较次数，时间复杂度是O(m+n)。