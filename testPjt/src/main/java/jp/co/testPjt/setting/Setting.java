package jp.co.testPjt.setting;

/**
 * 各種設定を保持するための定数クラス
 * @author masahisa
 *
 */
public class Setting {

	/**
	 * APIのURL
	 */
	public static final String API_URL = "https://api.github.com/repos/spring-projects/spring-boot/issues";

	/**
	 * ファイルの出力先
	 */
	public static final String FILE = "D:\\workspace\\codingTest\\testPjt\\output\\codingTest.txt";

	/**
	 * タブ
	 */
	public static final String TAB = "\t";

	/**
	 * 改行コード
	 */
	public static final String NEW_LINE = "\r\n";

	/**
	 * 改行コードを文字列置換するための定数
	 */
	public static final String STRING_NEW_LINE = "\\\\r\\\\n";

	/**
	 * タイトルの長さ
	 */
	public static final int TITLE_LENGTH = 10;

	/**
	 * ボディの長さ
	 */
	public static final int BODY_LENGTH = 30;

}
