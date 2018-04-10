package jp.co.testPjt.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JsonデータをFormに格納するクラス
 * @author masahisa
 *
 */
public class ParseJson {

	/**
	 * JsonデータをList<HashMap<String, String>>型にして返却
	 * @param data Jsonデータ
	 * @return listJson JsonデータのList<HashMap<String, String>>型
	 * @throws Exception エラー
	 */
	@SuppressWarnings("unchecked")
	public List<HashMap<String, String>> parseJsonToList ( String data) throws IOException {
		List<HashMap<String, String>> listJson = new ArrayList<HashMap<String, String>>();

		ObjectMapper mapper = new ObjectMapper();

		try {
			listJson = mapper.readValue(data, List.class);
		} catch (Exception e) {
			throw e;
		}

		return listJson;
	}
}
