import org.jruby.Ruby;
import org.jruby.embed.ScriptingContainer;


public class SearchMain {
	public void searchMain(Ruby r){
		SearchArray array = new SearchArray();
		//array.printArray();
		ScriptingContainer container = new ScriptingContainer();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/linearsearch.rb");
		System.out.println("線形検索");
		container.callMethod(r.getCurrentContext(), "search", array, array.getTarget());
		array.printTarget();
		array.printCount();
		array.printSuccess();

		//メソッドの未定義可
		//container.runScriptlet("undef search\n");
		ExerciseMain.undefRubyMethods(container);

		array.initResult();
		container = new ScriptingContainer();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/binarysearch.rb");
		System.out.println("二分検索");
		container.callMethod(r.getCurrentContext(), "search", array, array.getTarget());
		array.printTarget();
		array.printCount();
		array.printSuccess();
		ExerciseMain.undefRubyMethods(container);
	}
}
