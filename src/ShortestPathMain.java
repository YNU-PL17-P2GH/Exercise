import org.jruby.Ruby;
import org.jruby.embed.ScriptingContainer;


public class ShortestPathMain {
	public void shortestPathMain(Ruby r){
		ShortestPath myShortestPath = new ShortestPath();
		ScriptingContainer container = new ScriptingContainer();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/shortestpath.rb");
		System.out.println("最短経路問題");

		container.callMethod(r.getCurrentContext(), "find", myShortestPath);

		//メソッドの未定義可
		ExerciseMain.undefRubyMethods(container);
	}
}
