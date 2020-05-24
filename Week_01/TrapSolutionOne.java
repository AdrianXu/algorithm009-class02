class TrapSolutionOne {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < height.length; i++){
            while(!stack.empty() && height[i] > height[stack.peek()]){
                int h = stack.pop();
                if(stack.empty()){
                    break;
                }
                int left = stack.peek();
                int distance = i - left -1;
                h = Math.min(height[left],height[i]) - height[h];
                sum = sum + (distance * h);
            }
            stack.push(i);
        }
        return sum;
    }
}