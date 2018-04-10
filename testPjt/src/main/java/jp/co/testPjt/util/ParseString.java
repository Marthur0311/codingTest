package jp.co.testPjt.util;

import java.util.ArrayList;
import java.util.List;

import jp.co.testPjt.form.IssuesForm;
import jp.co.testPjt.setting.Setting;

/**
 * 文字列の変換処理を行うクラス
 * @author masahisa
 *
 */
public class ParseString {

	/**
	 * 取得したデータにタイトルの後にタブ、ボディの後に改行コードを挿入する
	 * @param listData 取得したデータ
	 * @return outputData タイトルとボディをタブ区切りにしたList
	 */
	public List<IssuesForm> parseStringTab (List<IssuesForm> listData) {

		List<IssuesForm> outputData = new ArrayList<IssuesForm>();
		int i = 1;
		IssuesForm issues = null;

		for (IssuesForm data : listData) {
			issues = new IssuesForm();

			if (i == listData.size()) {
				issues.setTitle(data.getTitle() + "	");
				issues.setBody(data.getBody());

			} else if (i < listData.size()) {
				issues.setTitle(data.getTitle() + Setting.TAB);
				issues.setBody(data.getBody() + Setting.NEW_LINE);
			}
			outputData.add(i - 1, issues);
			i++;
		}

		return outputData;
	}

	/**
	 * タイトルとボディに含まれる改行コードを文字列に変換する
	 * @param listData 取得したデータ
	 * @return outputData 文字列内の改行コードを文字列にしたList
	 */
	public List<IssuesForm> parseStringNewLine (List<IssuesForm> listData) {

		List<IssuesForm> outputData = new ArrayList<IssuesForm>();
		int i = 0;
		IssuesForm issues = null;

		for (IssuesForm data : listData) {
			issues = new IssuesForm();

			issues.setTitle(data.getTitle().replaceAll(Setting.NEW_LINE, Setting.STRING_NEW_LINE));
			issues.setBody(data.getBody().replaceAll(Setting.NEW_LINE, Setting.STRING_NEW_LINE));

			outputData.add(i, issues);
			i++;
		}

		return outputData;
	}
}
