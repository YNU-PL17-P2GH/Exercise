import org.jruby.Ruby;
import org.jruby.embed.ScriptingContainer;


public class NQueensMain {
	public void nQueenMain(Ruby r){
		ScriptingContainer container = new ScriptingContainer();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/nqueen.rb");
		NQueens nQueens = new NQueens();
		nQueens.printBoard();
		container.callMethod(r.getCurrentContext(), "nqueen", nQueens);
		nQueens.printBoard();
		nQueens.printResult();

		//メソッドの未定義化
		ExerciseMain.undefRubyMethods(container);
	}
}
