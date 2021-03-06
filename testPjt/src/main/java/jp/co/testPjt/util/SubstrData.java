package jp.co.testPjt.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jp.co.testPjt.form.IssuesForm;
import jp.co.testPjt.setting.Setting;

/**
 * 渡されたデータを10文字区切りにするクラス
 * @author masahisa
 *
 */
public class SubstrData {

	/**
	 * 渡されたデータからタイトルとボディのみを抜き出して文字列を抽出する
	 * @param listData 取得したデータ
	 * @return
	 */
	public List<IssuesForm> substrListData(List<HashMap<String, String>> listDatas) {
		List<IssuesForm> data = new ArrayList<IssuesForm>();
		IssuesForm issues = null;

		String title = "";
		String body = "";
		int i = 0;

		for (HashMap<String, String> listData : listDatas) {
			issues = new IssuesForm();

			title = substrAssignLength(Setting.TITLE_LENGTH, listData.get("title"));
			body = substrAssignLength(Setting.BODY_LENGTH, listData.get("body"));

			issues.setTitle(title);
			issues.setBody(body);

			data.add(i, issues);

			i++;
		}
		return data;
	}

	private String substrAssignLength (int length, String str) {
		if (str.length() < length) {
			length = str.length();
		}
		str = str.substring(0, length);

		return str;
	}
}
