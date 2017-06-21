import org.jruby.Ruby;
import org.jruby.embed.ScriptingContainer;


public class HelloRubyMain {
	public void helloRubyMain(Ruby r) {
		ScriptingContainer container = new ScriptingContainer();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/setout.rb");
		//標準出力変更
		container.callMethod(r.getCurrentContext(), "setStringOut");
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/helloruby.rb");
		System.out.println("java " +container.callMethod(r.getCurrentContext(), "getStdOut"));
		container.callMethod(r.getCurrentContext(), "setStdOut");
	}
}
