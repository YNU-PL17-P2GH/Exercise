import org.jruby.Ruby;
import org.jruby.embed.ScriptingContainer;


public class LabyrinthMain {
	public void labyrinthMain(Ruby r){
		Labyrinth myLabyrinth = new Labyrinth();
		ScriptingContainer container = new ScriptingContainer();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/labyrinth.rb");
		System.out.println("迷路探索(A*)");
		myLabyrinth .printMap();
		container.callMethod(r.getCurrentContext(), "solve", myLabyrinth );
		myLabyrinth.printMap();
		myLabyrinth.printResult();
		//メソッドの未定義可
		ExerciseMain.undefRubyMethods(container);
	}
}
