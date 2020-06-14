class RobotSimSolution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0}; 
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> blockSet = new HashSet<>();
        for(int i = 0 ; i < obstacles.length; i++){
            blockSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        int maxSquare = 0;
        int dr_index = 0;
        int x = 0, y = 0;
        for(int command: commands){
            if(command == -1){
                dr_index = (dr_index + 1) % 4;
            }else if(command == -2){
                dr_index = (dr_index + 3) % 4;
            }else{
                for(int i = 1; i <= command; i++){
                    int nextX = x + dx[dr_index];
                    int nextY = y + dy[dr_index];
                    if(blockSet.contains(nextX + "," + nextY)){
                        break;
                    }else{
                        x = nextX;
                        y = nextY;
                        maxSquare = Math.max(maxSquare, x*x + y*y);
                    }
                }
            }
        }
        return maxSquare;
    }
}