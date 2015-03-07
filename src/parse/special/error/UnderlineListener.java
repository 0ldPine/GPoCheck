package parse.special.error;

/////////////////////////////////////////////////////
//                    _ooOoo_                      //
//                   o8888888o                     //
//                   88" . "88                     //
//                   (| ^_^ |)                     //
//                   O\  =  /O                     //
//                ____/`---'\____                  //
//              .'  \\|     |//  `.                //
//             /  \\|||  :  |||//  \               //
//            /  _||||| -:- |||||-  \              //
//            |   | \\\  -  /// |   |              //
//            | \_|  ''\---/''  |   |              //
//            \  .-\__  `-`  ___/-. /              //
//          ___`. .'  /--.--\  `. . ___            //
//        ."" '<  `.___\_<|>_/___.'  >'"".         //
//      | | :  `- \`.;`\ _ /`;.`/ - ` : | |        //
//      \  \ `-.   \_ __\ /__ _/   .-` /  /        //
//========`-.____`-.___\_____/___.-`____.-'========//
//                     `=---='                     //
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
//佛祖保佑,永无BUG!
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//

import org.antlr.v4.runtime.*;

public class UnderlineListener extends BaseErrorListener {
	public static int errorCount = 0;

	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
		errorCount++;
		System.err.println("line " + line + ":" + charPositionInLine + " " + msg);
		underlineError(recognizer, (Token) offendingSymbol, line, charPositionInLine);
	}

	protected void underlineError(Recognizer<?, ?> recognizer, Token offendingToken, int line, int charPositionInLine) {
		CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();
		String input = tokens.getTokenSource().getInputStream().toString();
		String[] lines = input.split("\n");
		String errorLine = lines[line - 1];
		System.err.println(errorLine);
		String preLineSpace = getSpaceTabString(errorLine);
		System.err.print(preLineSpace);
		for (int i = 0; i < charPositionInLine - 1; i++)
			System.err.print(" ");
		int start = offendingToken.getStartIndex();
		int stop = offendingToken.getStopIndex();
		if (start >= 0 && stop >= 0) {
			for (int i = start; i <= stop; i++)
				System.err.print("^");
		}
		System.err.println();
	}

	private String getSpaceTabString(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '\t' && str.charAt(i) != ' ')
				return str.substring(0, i);
		}
		return "";
	}
}
