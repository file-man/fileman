package com.fileman.document;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import com.data.kit.io.File;

public class Document {

	private HashMap<String, Row> mRows;

	public Document() {
		mRows = new HashMap<String, Row>();
	}

	public void loadDocument(String path) throws IOException {
		try (File file = new File(path)) {
			int size = file.getLineCount();

			for (int i = 1; i < size; i++) {
				String line = file.readLine();
				Row row = Row.parse(line);
				mRows.put(row.getID(), row);
			}
		}
	}

	public int getSize() {
		return mRows.size();
	}

	public Row getRow(String id) {
		return mRows.get(id);
	}

	public Collection<Row> getRows() {
		return mRows.values();
	}

	public void addRow(String id, Row row) {
		mRows.put(id, row);
	}

	public void save(String name) {
		try (File dir = new File(Configuration.PATH_BASE);
				File file = new File(Configuration.PATH_BASE + File.getPathSeparator() + name)) {
			if (!dir.exist()) {
				dir.createDir();
			}

			if (file.exist()) {
				file.delete();
			} else {
				file.createNewFile();
			}

			for (Row row : mRows.values()) {
				file.writeLine(row.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
