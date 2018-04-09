package jp.co.testPjt.util;

import java.util.ArrayList;
import java.util.List;

import jp.co.testPjt.form.IssuesForm;

public class ParseString {

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
				issues.setTitle(data.getTitle() + "	");
				issues.setBody(data.getBody() + "	");
			}
			outputData.add(i - 1, issues);
			i++;
		}

		return outputData;
	}
}
