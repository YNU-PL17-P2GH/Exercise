

public class Labyrinth {
	private char map[][] = {{'#','#','#','#','#',' ','#','#','#','#','#','#','#','#'},		//仮の迷路 '#'は壁
							{'#',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','#',' ','#'},
							{'#',' ','#','#','#',' ','#','#','#',' ','#','#',' ','#'},
							{'#',' ',' ',' ','#',' ','#',' ','#',' ','#','#',' ','#'},
							{'#','#','#',' ','#',' ','#',' ','#',' ','#','#',' ','#'},
							{'#',' ',' ',' ','#',' ','#',' ','#',' ','#','#',' ','#'},
							{'#',' ','#','#','#',' ','#',' ','#',' ','#','#',' ','#'},
							{'#',' ',' ',' ','#',' ',' ',' ','#',' ','#','#',' ','#'},
							{'#','#','#',' ','#','#','#','#','#',' ','#','#',' ','#'},
							{'#',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ','#'},
							{'#','#','#','#','#',' ','#','#','#','#','#','#','#','#'}
			};
	private char returnMap[][];		//mapが書き換えられないため
	private int start[] = {5, 0};
	private int returnStart[];
	private int goal[] = {5, 10};
	private int returnGoal[] = {5, 10};

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

	public char[][] getMap(){
		returnMap = new char[map.length][map[0].length];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				returnMap[i][j] = map[i][j];
			}
		}
		return returnMap;
	}

	public void printMap(){
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
