import org.jruby.Ruby;
import org.jruby.embed.ScriptingContainer;
import org.jruby.runtime.builtin.IRubyObject;


public class SortMain {
	
	public static void main(String args[]){
		ArrayOperator arrayOperator = new ArrayOperator();
		Ruby r = Ruby.newInstance();
		ScriptingContainer container = new ScriptingContainer();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "sort1.rb");
		System.out.println("バブルソート");
		container.callMethod(r.getCurrentContext(), "sort", arrayOperator);
		System.out.println(arrayOperator.chackArray());
		arrayOperator.printArray();
		arrayOperator.printCount();
		
		arrayOperator.initArray();
		System.out.println("選択ソート");
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "sort.rb");
		container.callMethod(r.getCurrentContext(), "sort", arrayOperator);
		System.out.println(arrayOperator.chackArray());
		arrayOperator.printArray();
		arrayOperator.printCount();
	}
}
