

public class NQueens {
	private int[][] direct = {{0, -1}, {1, -1},{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};
	private int[][] board;
	private final int WIDTH = 8;

	private boolean failFlag = false;
	private int[][] queenPlace;
	private int queenCount;

	public NQueens(){
		board = new int[WIDTH][WIDTH];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = 0;
			}
		}
		queenPlace = new int[WIDTH][2];
		queenCount = 0;
	}

	public void boardClear(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = 0;
			}
		}
	}
	
	public void putQueen(int x, int y){
		int nx, ny;
		if(failFlag){
			return;
		}
		if(board[y][x] == 1){	//失敗
			failFlag = true;
			return;
		}
		for(int i = 0; i < 8; i++){
			nx = x + direct[i][0];
			ny = y + direct[i][1];
			while(nx >= 0 && nx < board[0].length && ny >= 0 && ny < board.length){
				if(board[ny][nx] == 1){	//失敗
					failFlag = true;
					return;
				}
				nx = nx + direct[i][0];
				ny = ny + direct[i][1];
				//System.out.println(nx+" "+ ny);
			}
		}
		board[y][x] = 1;
		queenPlace[queenCount][0] = x;
		queenPlace[queenCount][1] = y;
		queenCount++;
	}

	public void printBoard() {
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void printResult() {
		System.out.println(!failFlag);
		for(int i = 0; i < queenPlace.length; i++){
			for(int j = 0; j < 2; j++){
				System.out.print(queenPlace[i][j] + " ");
			}
			System.out.println();
		}
	}
}
