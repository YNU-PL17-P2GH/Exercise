import org.jruby.Ruby;


public class ExerciseMain {

	public static void main(String[] args) {
		Ruby r = Ruby.newInstance();
		//ソート
		//(new SortMain()).sortMain(r);
		//ハノイ
		(new HanoiMain()).hanoiMain(r);
	}

}
