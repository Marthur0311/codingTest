package jp.co.testPjt.util;

import java.util.List;

import jp.co.testPjt.form.IssuesForm;

public class Output {

	public void outputSystemOut ( List<IssuesForm> listData) {
		for (IssuesForm data : listData) {
			System.out.print(data.getTitle());
			System.out.print(data.getBody());
		}
	}

	public void outputFile ( List<IssuesForm> listData) {
		for (IssuesForm data : listData) {

		}
	}
}
