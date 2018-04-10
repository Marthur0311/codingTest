package jp.co.testPjt.controller.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.testPjt.form.IssuesForm;
import jp.co.testPjt.setting.Setting;
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
		String strData;
		try {
			strData = data.GetDataString();
		} catch (Exception e) {
			model.addAttribute("e", e);
			return "error";
		}
		if ( strData.isEmpty()) {
			model.addAttribute("e", "取得結果が空です");
			return "error";
		}

		// データの加工
		ParseJson parseJson = new ParseJson();
		List<HashMap<String, String>> listData = new ArrayList<HashMap<String, String>>();
		try {
			listData = parseJson.parseJsonToList(strData);
		} catch (IOException e) {
			model.addAttribute("e", e);
			return "error";
		}
		if (listData.isEmpty()) {
			model.addAttribute("e", "変換結果が空です");
			return "error";
		}

		List<IssuesForm> outputData = new ArrayList<IssuesForm>();

		// 文字列の抽出
		SubstrData substrTenLength = new SubstrData();
		outputData = substrTenLength.substrListData(listData);

		// 改行コードの置換
		ParseString parseString = new ParseString();
		outputData = parseString.parseStringNewLine(outputData);

		// タブ + 改行区切り
		outputData = parseString.parseStringTab(outputData);

		// 標準出力 + ファイル出力
		Output output = new Output();
		output.outputSystemOut(outputData);
		try {
			output.outputFile(outputData);
		} catch (IOException e) {
			model.addAttribute("e", e);
			return "error";
		}

		// 画面への出力
		model.addAttribute("outputDir", Setting.FILE);
		model.addAttribute("outputDatas", outputData);

		return "test/result";
	}
}