import org.jruby.Ruby;
import org.jruby.embed.ScriptingContainer;


public class SortMain {

	public void sortMain(Ruby r){
		ArrayOperator arrayOperator = new ArrayOperator();
		System.out.println("ソート前");
		arrayOperator.printArray();
		ScriptingContainer container = new ScriptingContainer();
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/bubblesort.rb");
		System.out.println("バブルソート");
		container.callMethod(r.getCurrentContext(), "sort", arrayOperator);
		System.out.println(arrayOperator.checkArray());
		arrayOperator.printArray();
		arrayOperator.printCount();
		
		//メソッドの未定義化(問題があるかは不明だが除去しておいた方が無難な気がする)
		container.runScriptlet("undef sort\n");

		arrayOperator.initArray();
		container = new ScriptingContainer();
		System.out.println("選択ソート");
		container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/selectionsort.rb");
		container.callMethod(r.getCurrentContext(), "sort", arrayOperator);
		System.out.println(arrayOperator.checkArray());
		arrayOperator.printArray();
		arrayOperator.printCount();
	}
}
