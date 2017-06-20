import java.util.Random;


public class SearchArray {
	private int[] array;
	private int targetID;		//探す数値の添え字
	private int count;
	private int result;		//プレイヤーの答え
	public SearchArray(){
		array = new int[100];
		init();
	}

	public void init(){
		Random r = new Random();
		array[0] = r.nextInt(100);
		for(int i = 1; i < array.length; i++){
			array[i] = array[i - 1] + r.nextInt(100);
		}

		targetID = r.nextInt(array.length);
		initResult();
	}

	public void initResult(){
		result = -1;
		count = 0;
	}

	public int checkElement(int i, int target){	//ターゲットを探す
		count++;
		if(array[i] == target){		//範囲外だと例外吐いてくれるはず
			return 0;
		}else if(array[i] > target){
			return -1;
		}else{
			return 1;
		}
	}

	public int length(){
		return array.length;
	}

	public void setResult(int r){
		result = r;
	}

	public void printCount(){
		System.out.println(count);
	}

	public void printTarget(){
		System.out.println(targetID + " " + array[targetID]);
	}

	public void printSuccess(){
		System.out.println((result == targetID));
	}

	public void printArray(){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public int getTarget() {
		return array[targetID];
	}
}
