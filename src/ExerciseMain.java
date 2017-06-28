import org.jruby.Ruby;
import org.jruby.RubyArray;
import org.jruby.RubyFixnum;
import org.jruby.embed.ScriptingContainer;


public class ExerciseMain {

	public static void main(String[] args) {
		Ruby r = Ruby.newInstance();
		//ソート
		//(new SortMain()).sortMain(r);
		//ハノイ
		//(new HanoiMain()).hanoiMain(r);
		//サーチ
		//(new SearchMain()).searchMain(r);
		//ナイトのツアー
		//(new KnightMain()).knightMain(r);
		//ナップサック
		//(new KnapsackMain()).knapsackMain(r);
		//nクイーン
		//(new NQueensMain()).nQueenMain(r);
		//A*探索
		(new LabyrinthMain()).labyrinthMain(r);
		
		//ハローワールド
		//(new HelloRubyMain()).helloRubyMain(r);
	}

	//完全に思いつきなので正攻法があれば報告ください
	public static void undefRubyMethods(ScriptingContainer container){		//自作Rubyメソッドの未定義化(除去)
		RubyArray methods = (RubyArray)container.runScriptlet(org.jruby.embed.PathType.RELATIVE, "rubySrc/methodclear.rb");
		//System.out.println(methods);
		for(int i = 0; i < RubyFixnum.fix2int(methods.length()); i++){
			container.runScriptlet("undef " + methods.get(i).toString() + "\n");
		}
		//container.runScriptlet("p Object.private_instance_methods(false)\n");
	}

}
