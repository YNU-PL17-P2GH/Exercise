

public class Knapsack {
	private int[][] item = {{168, 496}, {10, 45}, {145, 325}, {60, 347}, {10, 61}, {124, 486}, {124, 446}, {105, 22}, {126, 110}, {184, 475}};
	private int[][] returnItem;	//itemがRuby側で書き換えられないようにするため
	//1,4,5,6?
	private int capacity = 300;

	private boolean[] selectItem;
	private int myCapacity = 0;

	private boolean failFlag = false;		//失敗したとき

	public Knapsack() {
		selectItem = new boolean[item.length];
		for(int i = 0; i < selectItem.length; i++){
			selectItem[i] = false;
		}
		returnItem = new int[item.length][item[0].length];
	}

	public int getCapacity(){
		return capacity;
	}

	public int[] getItem(int i){
		returnItem[i][0] = item[i][0];
		returnItem[i][1] = item[i][1];
		return returnItem[i];
	}

	public int getItemNum(){
		return item.length;
	}

	public void pickItem(int i){
		if(failFlag){
			return;
		}
		if(myCapacity > capacity){	//失敗
			failFlag = true;
			return;
		}
		if(selectItem[i]){	//失敗
			failFlag = true;
			return;
		}

		selectItem[i] = true;
	}

	public void printResult(){
		System.out.println("正常終了:" + !failFlag);
		int c = 0, v = 0;
		for(int i = 0; i < selectItem.length; i++){
			if(selectItem[i]){
				System.out.println("選択:" + i + " 価値:" + item[i][1] + " 重さ:" + item[i][0]);
				c = c + item[i][0];
				v = v + item[i][1];
			}
		}
		System.out.println("価値合計:" + v);
		System.out.println("総重量:" + c);
	}
}
