import org.jruby.Ruby;
import org.jruby.embed.ScriptingContainer;


public class KnightMain {

	public void knightMain(Ruby r) {
		ScriptingContainer container = new ScriptingContainer();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/knight.rb");
		Knight knight = new Knight();
		knight.printBoard();
		container.callMethod(r.getCurrentContext(), "tour", knight);
		knight.printBoard();
		knight.printResult();

		//メソッドの未定義化
		//container.runScriptlet("undef tour\nundef tourSub\n");
		//container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/methodclear.rb");
		ExerciseMain.undefRubyMethods(container);

		knight.nextBoard();
		knight.printBoard();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/greedyknight.rb");
		container.callMethod(r.getCurrentContext(), "tour", knight);
		knight.printBoard();
		knight.printResult();

		
		//メソッドの未定義化
		//container.runScriptlet("undef tour\nundef tourSub\nundef getNextJumps\n");
		ExerciseMain.undefRubyMethods(container);
		
		knight.nextBoard();
		knight.printBoard();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/greedyknight2.rb");
		container.callMethod(r.getCurrentContext(), "tour", knight);
		knight.printBoard();
		knight.printResult();
		//メソッドの未定義化
		ExerciseMain.undefRubyMethods(container);
	}

}
