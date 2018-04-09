package jp.co.testPjt.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JsonデータをFormに格納するクラス
 * @author masahisa
 *
 */
public class ParseJson {

	@SuppressWarnings("unchecked")
	public List<HashMap<String, String>> parseJsonToList ( String data) {
		List<HashMap<String, String>> listJson = new ArrayList<HashMap<String, String>>();

		ObjectMapper mapper = new ObjectMapper();

		try {
			listJson = mapper.readValue(data, List.class);
		} catch (JsonParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		} catch (JsonMappingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}

		return listJson;
	}
}
