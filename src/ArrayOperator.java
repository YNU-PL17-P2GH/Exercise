import java.util.Random;

public class ArrayOperator {
	private int array[];		
	private int initArray[];	//init用
	private int count = 0;		//交換回数
	
	public ArrayOperator(){
		array = new int[20];
		initArray = new int[20];
		for(int i = 0; i < array.length; i++){
			array[i] = i ;
		}
		
		//ランダムに
		Random r = new Random();
		for(int i = 0; i < 200; i++){
			this.exchange(r.nextInt(array.length), r.nextInt(array.length));
		}
		for(int i = 0; i < array.length; i++){
			initArray[i] = array[i];
		}
		count = 0;
	}
	
	public void initArray(){
		for(int i = 0; i < array.length; i++){
			array[i] = initArray[i];
		}
		count = 0;
	}
	
	public boolean compare(int i, int j){	//比較
		if(array[i] >= array[j]){
			return true;
		}else{
			return false;
		}
	}
	
	public void exchange(int i, int j){		//交換
		int c = array[i];
		array[i] = array[j];
		array[j] = c;
		count++;
	}
	
	public int length(){
		return array.length;
	}
	
	public void printArray(){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public void printCount(){
		System.out.println(count);
	}
	
	public boolean checkArray(){				//ソートされているか
		for(int i = 0; i < array.length; i++){
			if(array[i] != i){
				return false;
			}
		}
		return true;
	}
}
