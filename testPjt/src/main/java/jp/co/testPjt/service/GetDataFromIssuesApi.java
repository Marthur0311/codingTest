package jp.co.testPjt.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import jp.co.testPjt.setting.Setting;

/**
 * issuesのAPIからデータを取得するクラス
 * @author masahisa
 *
 */
public class GetDataFromIssuesApi {

    private static URL               url = null;
    private static BufferedReader    br  = null;
    private static InputStreamReader isr = null;

    /**
     * APIを実行、得たJSONを文字列として返す
     * @return writeContent APIから取得したデータ
     * @throws Exception エラー
     */
    public String conectGetJson() throws Exception {
        String readLine     = "";
        String writeContent = "";

        try {
        	url = new URL( Setting.API_URL );
        } catch ( Exception e ) {
        	throw e;
        }

        /* 読み込み処理 */
        isr = new InputStreamReader( url.openStream() );
        br  = new BufferedReader( isr );

        // 読み込んだ内容を変数に保存
        while (( readLine = br.readLine() ) != null ) {
        	writeContent = writeContent + readLine;
        }

        return writeContent;
	}
}