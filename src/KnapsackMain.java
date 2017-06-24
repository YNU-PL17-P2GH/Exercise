import org.jruby.Ruby;
import org.jruby.embed.ScriptingContainer;


public class KnapsackMain {
	public void knapsackMain(Ruby r){
		Knapsack myKnapsack = new Knapsack();
		ScriptingContainer container = new ScriptingContainer();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/knapsack.rb");
		System.out.println("ナップサック問題");
		container.callMethod(r.getCurrentContext(), "knapsack", myKnapsack);
		myKnapsack.printResult();
		//メソッドの未定義可
		//container.runScriptlet("undef search\n");
		ExerciseMain.undefRubyMethods(container);
	}
}
