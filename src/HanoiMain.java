import org.jruby.Ruby;
import org.jruby.embed.ScriptingContainer;


public class HanoiMain {

	public void hanoiMain(Ruby r) {
		ScriptingContainer container = new ScriptingContainer();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "hanoi.rb");
		Hanoi tower = new Hanoi();
		tower.printTower();
		container.callMethod(r.getCurrentContext(), "hanoi", tower, 5);
		tower.printTower();
	}

}
