public class Maze{

	public static void main(String[] args){
		
		//新建一个二位数组
		int[][] map = new int[8][7];
		
		//设置迷宫障碍
		for(int i = 0; i < map[0].length; i++){
		
			map[0][i] = 1;
			map[7][i] = 1;
		
		}
		for(int i = 0; i < map.length; i++){
		
			map[i][0] = 1;
			map[i][6] = 1;
		
		}
		map[3][1] = 1;
		map[3][2] = 1;
		map[2][2] = 1;
		
		//迷宫地图
		System.out.println("迷宫的地图======");
		for(int i = 0; i < map.length; i++){
		
			for(int j = 0; j < map[i].length; j++){
			
				System.out.print(map[i][j] + " ");
			
			}
			
			System.out.println();
		
		}
		
		//创建一个对象
		Tool T = new Tool();
		
		T.findWay(map, 1, 1);
		
		//遍历数组
		System.out.println("走迷宫的线路");
		for(int i = 0; i < map.length; i++){
		
			for(int j = 0; j < map[i].length; j++){
			
				System.out.print(map[i][j] + " ");
			
			}
			
			System.out.println();
		
		}
	
	}

}
class Tool{

	//0表示可以走，1表示障碍物，2表示可以走，3表示走过，但走不通，是死路
	//走路策略：下->右->上->左，总共有六种走路策略
	public boolean findWay(int[][] map, int i, int j){
		
		if(map[6][5] == 2){
		
			return true;
		
		}else{
		
			if(map[i][j] == 0){
			
				map[i][j] = 2;
				if(findWay(map, i+1, j)){//下
					return true;
				}else if(findWay(map, i, j+1)){//右
					return true;
				}else if(findWay(map, i-1, j)){//上
					return true;
				}else if(findWay(map, i, j-1)){//左
					return true;
				}else{
					map[i][j] = 3;
					return false;
				}
			
			}else{
			
				return false;
			
			}
		
		}
	
	}

}