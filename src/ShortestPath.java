import java.util.ArrayList;



public class ShortestPath {
	private int[][] path ={{-1, 5, 4, 2,-1,-1},
						   { 5,-1, 2,-1,-1, 6},
						   { 4, 2,-1, 3, 2,-1},
						   { 2,-1, 3,-1, 6,-1},
						   {-1,-1, 2, 6,-1, 4},
						   {-1, 6,-1,-1, 4,-1},};
	private int start = 0;
	private int goal = 5;
	private ArrayList<Integer> resultFrom = new ArrayList<Integer>();
	private ArrayList<Integer> resultTo = new ArrayList<Integer>();
	public int[][] getHavePath(int node){
		int c = 0;
		int[][] allPath = new int[path[node].length][2];
		for(int i = 0; i < path[node].length; i++){
			allPath[i][0] = i;
			allPath[i][1] = path[node][i];
			if(allPath[i][1] >= 0){
				c++;
			}
		}
		if(c == 0){
			return null;
		}
		int[][] rePath = new int[c][2];
		int j = 0;
		for(int i = 0; i < path[node].length; i++){
			if(allPath[i][1] < 0){
				continue;
			}
			rePath[j][0] = allPath[i][0];
			rePath[j][1] = allPath[i][1];
			j++;
		}

		return rePath;
	}

	public int getStart() {
		return start;
	}

	public int getGoal() {
		return goal;
	}

	public void selectPath(int from, int to){
		resultFrom.add(from);
		resultTo.add(to);
	}

	public void printResult(){
		for(int i = 0; i < resultFrom.size(); i++){
			System.out.println(resultFrom.get(i) + "->" + resultTo.get(i));
		}
	}
}
