package jp.co.testPjt.controller.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.testPjt.form.IssuesForm;
import jp.co.testPjt.util.GetData;
import jp.co.testPjt.util.Output;
import jp.co.testPjt.util.ParseJson;
import jp.co.testPjt.util.ParseString;
import jp.co.testPjt.util.SubstrData;

/**
 * indexから呼び出され、処理を行った後にtest/resultに遷移するコントローラークラス
 * @author masahisa
 *
 */
@Controller
@EnableAutoConfiguration
public class StartTestController
{
	/**
	 * データの取得と出力を行い、test/resultに遷移する
	 * @param model パラメータ
	 * @return test/result 遷移先URL
	 */
	@RequestMapping("/startTest")
	public String startTest(Model model){

		// データの取得
		GetData data = new GetData("api");
		String strData = data.GetDataString();
		if ( "error".equals(strData) || strData.isEmpty()) {
			return "error";
		}

		// データの加工
		ParseJson parseJson = new ParseJson();
		List<HashMap<String, String>> listData = parseJson.parseJsonToList(strData);
		if (listData.isEmpty()) {
			return "error";
		}

		List<IssuesForm> outputData = new ArrayList<IssuesForm>();

		// 文字列の抽出
		SubstrData substrTenLength = new SubstrData();
		outputData = substrTenLength.substrListData(listData);

		// タブ区切り
		ParseString parseString = new ParseString();
		outputData = parseString.parseStringTab(outputData);

		// 出力
		Output output = new Output();
		output.outputSystemOut(outputData);

		return "test/result";
	}
}