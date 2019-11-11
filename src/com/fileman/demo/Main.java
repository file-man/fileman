package com.fileman.demo;

import java.io.IOException;

import com.fileman.document.Cell;
import com.fileman.document.Document;
import com.fileman.document.Row;
import com.fileman.ui.MainUI;

public class Main {

	public static void main(String[] args) throws IOException {
//		Document doc = new Document();

//		for (int i = 0; i < 100; i++) {
//			Row row = new Row(i + "", 10);
//			for (int j = 0; j < 10; j++) {
//				row.addCell("key" + j, new Cell("key" + j, "value"));
//			}
//			doc.addRow(row.getID(), row);
//		}
//		
//		doc.save("doc.txt");
		
//		doc.loadDocument("data/doc.txt");
//
//		for (Row row : doc.getRows()) {
//			System.out.println(row.toString());
//		}
		
		new MainUI();
	}
}
