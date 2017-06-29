import java.awt.Point;
import java.util.ArrayList;




public class Labyrinth {
	private int map[][] = {{1,1,1,1,1,0,1,1,1,1,1,1,1,1},		//仮の迷路 1は壁
							{1,0,0,0,0,0,0,0,0,0,1,1,0,1},
							{1,0,1,1,1,0,1,1,1,0,1,1,0,1},
							{1,0,0,0,1,0,1,0,1,0,1,1,0,1},
							{1,1,1,0,1,0,1,0,1,0,1,1,0,1},
							{1,0,0,0,1,0,1,0,1,0,1,1,0,1},
							{1,0,1,1,1,0,1,0,1,0,1,1,0,1},
							{1,0,0,0,1,0,0,0,1,0,1,1,0,1},
							{1,1,1,0,1,1,1,1,1,0,1,1,0,1},
							{1,0,0,0,0,0,0,0,1,0,0,0,0,1},
							{1,1,1,1,1,0,1,1,1,1,1,1,1,1}
			};
	private int returnMap[][];		//mapが書き換えられないため
	private int start[] = {5, 0};
	private int returnStart[];
	private int goal[] = {5, 10};
	private int returnGoal[] = {5, 10};
	private boolean failFlag = false;
	private ArrayList<Point> result = new ArrayList<Point>();

	public int[] getStartPos(){
		returnStart = new int[2];
		returnStart[0] = start[0];
		returnStart[1] = start[1];
		return returnStart;
	}

	public int[] getGoalPos(){
		returnGoal = new int[2];
		returnGoal[0] = goal[0];
		returnGoal[1] = goal[1];
		return returnGoal;
	}

	public int[][] getMap(){
		returnMap = new int[map.length][map[0].length];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				returnMap[i][j] = map[i][j];
			}
		}
		return returnMap;
	}

	public void setResult(int x, int y){
		if(failFlag){
			return;
		}
		if(x < 0 || x >= map[0].length || y < 0 || y >= map.length || map[y][x] != 0){
			failFlag = true;
			return;
		}
		map[y][x] = 2;
		result.add(new Point(x, y));
	}

	public void printMap(){
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				if(map[i][j] == 0){
					System.out.print(' ');
				}else if(map[i][j] == 1){
					System.out.print('#');
				}else if(map[i][j] == 2){
					System.out.print('V');
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	public void printResult(){
		for(int i = 0; i < result.size(); i++){
			System.out.print("[" + (int)result.get(i).getX() + ", " + (int)result.get(i).getY() +"] ");
		}
		System.out.println();
	}
}
