package jp.co.testPjt.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * issuesのAPIからデータを取得するクラス
 * @author masahisa
 *
 */
public class GetDataFromIssuesApi {

    private static final String API_URL  = "https://api.github.com/repos/spring-projects/spring-boot/issues";
    private static URL               url = null;
    private static BufferedReader    br  = null;
    private static InputStreamReader isr = null;

    /**
     * 実際にAPIを叩いて得たJSONを文字列として返す
     * @return writeContent APIから取得したデータ
     */
    public String conectGetJson() throws Exception {
        String readLine     = "";
        String writeContent = "";

        try {
        	url = new URL( API_URL );
        } catch ( Exception e ) {
        	e.printStackTrace();
        }

        /* ここから読み込むための定型文 */
        isr = new InputStreamReader( url.openStream() );
        br  = new BufferedReader( isr );

        //ここで読み込んだ内容を変数に保存している
        while (( readLine = br.readLine() ) != null ) {
        	writeContent = writeContent + readLine;
        }

        return writeContent;
	}
}