import org.jruby.Ruby;
import org.jruby.embed.ScriptingContainer;
import org.jruby.runtime.builtin.IRubyObject;


public class SortMain {
	
	public void sortMain(Ruby r){
		ArrayOperator arrayOperator = new ArrayOperator();
		System.out.println("ソート前");
		arrayOperator.printArray();
		ScriptingContainer container = new ScriptingContainer();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "bubblesort.rb");
		System.out.println("バブルソート");
		container.callMethod(r.getCurrentContext(), "sort", arrayOperator);
		System.out.println(arrayOperator.checkArray());
		arrayOperator.printArray();
		arrayOperator.printCount();
		
		arrayOperator.initArray();
		container = new ScriptingContainer();
		System.out.println("選択ソート");
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "selectionsort.rb");
		container.callMethod(r.getCurrentContext(), "sort", arrayOperator);
		System.out.println(arrayOperator.checkArray());
		arrayOperator.printArray();
		arrayOperator.printCount();
	}
}
