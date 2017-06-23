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
		
		container.runScriptlet("undef tour\nundef tourSub\n");

		knight.nextBoard();
		knight.printBoard();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/greedyknight.rb");
		container.callMethod(r.getCurrentContext(), "tour", knight);
		knight.printBoard();
		
		container.runScriptlet("undef tour\nundef tourSub\nundef getNextJumps\n");

		knight.nextBoard();
		knight.printBoard();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/greedyknight2.rb");
		container.callMethod(r.getCurrentContext(), "tour", knight);
		knight.printBoard();
	}

}
