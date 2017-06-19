import java.util.Random;

public class ArrayOperator {
	private int array[];
	private int initArray[];
	private int count = 0;
	public ArrayOperator(){
		array = new int[80];
		initArray = new int[80];
		for(int i = 0; i < array.length; i++){
			array[i] = i / 8;
		}
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
	
	public boolean compare(int i, int j){
		if(array[i] >= array[j]){
			return true;
		}else{
			return false;
		}
	}
	
	public void exchange(int i, int j){
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
	
	public boolean chackArray(){
		for(int i = 0; i < array.length; i++){
			if(array[i] != i / 8){
				return false;
			}
		}
		return true;
	}
}
