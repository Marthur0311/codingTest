package jp.co.testPjt.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import jp.co.testPjt.form.IssuesForm;
import jp.co.testPjt.setting.Setting;

/**
 * データの出力用クラス
 * @author masahisa
 *
 */
public class Output {

	File file = new File(Setting.FILE);

	/**
	 * 渡されたデータを標準出力に出力する
	 * @param listData 取得したデータ
	 */
	public void outputSystemOut ( List<IssuesForm> listData) {
		for (IssuesForm data : listData) {
			System.out.print(data.getTitle());
			System.out.print(data.getBody());
		}
	}

	/**
	 * 渡されたデータをファイルに出力する
	 * @param listData 取得したデータ
	 * @return result 出力の成否(true・・・成功、false・・・失敗)
	 * @throws IOException エラー
	 */
	public void outputFile ( List<IssuesForm> listData) throws IOException {
		for (IssuesForm data : listData) {
			try {
				// ファイルの書き込み
				FileWriter fileWriter = new FileWriter(file, true);
				fileWriter.write(data.getTitle());
				fileWriter.write(data.getBody());

				fileWriter.close();
			} catch (IOException e) {
				throw e;
			}
		}
		return;
	}
}
