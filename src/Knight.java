import java.util.ArrayList;




public class Knight {
	private int[][] direct = {{1, 2}, {2, 1},{2, -1}, {1, -2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};
	private int[][] board;
	private int x, y;

	private boolean failFlag = false;
	
	ArrayList<Integer> moveProcess;

	public Knight(){
		x = 0;
		y = 0;
		board = new int[5][5];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = 0;
			}
		}
		board[y][x] = 1;
		moveProcess = new ArrayList<Integer>();
	}

	public void nextBoard(){
		x = 0;
		y = 0;
		board = new int[10][10];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = 0;
			}
		}
		board[y][x] = 1;
		moveProcess = new ArrayList<Integer>();
	}

	public void move(int d){
		//System.out.println(x + " " + y + " "+ d);
		if(failFlag){
			return;
		}
		if( x + direct[d][0] < 0 || x + direct[d][0] >= board[0].length){
			failFlag = true;
			return;
		}
		if( y + direct[d][1] < 0 || y + direct[d][1] >= board.length){
			failFlag = true;
			return;
		}
		if(board[y + direct[d][1]][x + direct[d][0]] != 0){
			failFlag = true;
			return;
		}

		board[y + direct[d][1]][x + direct[d][0]] = 1;
		y = y + direct[d][1];
		x = x + direct[d][0];
		//System.out.println(x + " " + y + " "+ d);
		//printBoard();
		moveProcess.add(d);
		return;
	}

	public int canMoveCount(int d){
		int ny = y + direct[d][1];
		int nx = x + direct[d][0];
		if( x + direct[d][0] < 0 || x + direct[d][0] >= board[0].length){
			return -1;
		}
		if( y + direct[d][1] < 0 || y + direct[d][1] >= board.length){
			return -1;
		}
		if(board[ny][nx] == 1){
			return -1;
		}

		int count = 0;
		board[ny][nx] = 1;
		for(int i = 0; i < 8; i++){
			if( nx + direct[i][0] < 0 || nx + direct[i][0] >= board[0].length){
				continue;
			}
			if( ny + direct[i][1] < 0 || ny + direct[i][1] >= board.length){
				continue;
			}
			if(board[ny + direct[i][1]][nx + direct[i][0]] == 0){
				count++;
			}
		}
		board[ny][nx] = 0;
		return count;
	}
	public boolean canMove(int d){
		int ny = y + direct[d][1];
		int nx = x + direct[d][0];
		if( x + direct[d][0] < 0 || x + direct[d][0] >= board[0].length){
			return false;
		}
		if( y + direct[d][1] < 0 || y + direct[d][1] >= board.length){
			return false;
		}
		if(board[ny][nx] == 1){
			return false;
		}

		return true;
	}

	public void backtrack(int d){
		//System.out.println(x +" "+ y);
		board[y][x] = 0;
		y = y - direct[d][1];
		x = x - direct[d][0];
		//printBoard();
		moveProcess.add(-1);
	}

	public void printBoard(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printResult(){
		System.out.println(!failFlag);
		System.out.println(moveProcess);
	}
}
