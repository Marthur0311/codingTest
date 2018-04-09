package jp.co.testPjt.form;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 取得したデータを保持するBean
 * @author masahisa
 *
 */
public class IssuesForm {

	@JsonProperty("title")
	private String title;

	@JsonProperty("body")
	private String body;

	/**
	 * titleを取得
	 * @return title
	 */
	public String getTitle () {
		return this.title;
	}

	/**
	 * titleを設定
	 * @param title
	 */
	public void setTitle (String title) {
		this.title = title;
	}

	/**
	 * bodyを取得
	 * @return body
	 */
	public String getBody () {
		return this.body;
	}

	/**
	 * bodyを設定
	 * @param body
	 */
	public void setBody (String body) {
		this.body = body;
	}

	/**
	 * 値をすべてクリアする
	 */
	public void clear () {
		this.title = "";
		this.body = "";
	}
}
