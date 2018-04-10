package jp.co.testPjt.util;

import jp.co.testPjt.service.GetDataFromIssuesApi;

/**
 * データを取得するクラス
 * @author masahisa
 *
 */
public class GetData {

	private String type = "";

	/**
	 * コンストラクタ
	 * @param type 取得元（api・・・API）
	 */
	public GetData (String type) {
		this.type = type;
	}

	/**
	 * コンストラクタによって指定された取得元からデータを取得し、文字列で返す
	 * @return data 取得したデータ
	 * @throws Exception エラー
	 */
	public String GetDataString () throws Exception {
		String data = "";

		if ( type.equals("api")) {
			// APIからの取得
			GetDataFromIssuesApi api = new GetDataFromIssuesApi();
			try {
				data = api.conectGetJson();
			} catch (Exception e) {
	        	throw e;
			}
		}
		return data;
	}
}
