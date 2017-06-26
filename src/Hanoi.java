

public class Hanoi {
	private int[][] tower; 
	private int[] index;
	private boolean failFlag = false;
	public Hanoi(){
		tower = new int[3][5];
		index = new int[3];
		for(int i = 0; i < tower[0].length ;i++){
			tower[0][i] = 0;
			tower[1][i] = tower[0].length - i;
			tower[2][i] = 0;
		}
		index[0] = 0;
		index[1] = 5;
		index[2] = 0;
	}
	
	public void move(int from, int to){
		if(failFlag){
			return;
		}
		System.out.println(from + "->" + to);
		if(index[from] == 0){
			failFlag = true;
			return;
		}
		if(tower[to][index[to]] > tower[from][index[from] - 1]){
			failFlag = true;
			return;
		}
		tower[to][index[to]] = tower[from][index[from] - 1];
		tower[from][index[from] - 1] = 0;
		index[to]++;
		index[from]--;
		printTower();
	}
	
	public void printTower(){
		for(int j = 0; j < tower.length; j++){
			for(int i = 0; i < tower[j].length ;i++){
				System.out.print(tower[j][i]);
			}
			System.out.println("     " + index[j]);
		}
	}
}
