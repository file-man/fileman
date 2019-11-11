package com.fileman.document;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.data.kit.utils.StringUtils;

public class Row {

	private HashMap<String, Cell> mCells;
	private String mID;

	public Row(String id, int size) {
		mID = id;
		mCells = new HashMap<String, Cell>(size);
	}

	public static final Row parse(String data) {
		if (data == null || data.length() < 1) {
			throw new RuntimeException("row data format is invalided");
		}

		List<String> list = StringUtils.splitByKey(data, Configuration.SEPARATOR_COLUMN);
		String id = list.get(0);
		Row row = new Row(id, list.size() - 1);

		for (int i = 1; i < list.size(); i++) {
			Cell cell = Cell.parse(list.get(i));
			row.addCell(cell.getKey(), cell);
		}

		return row;
	}

	public String getID() {
		return mID;
	}

	public void addCell(String key, Cell cell) {
		mCells.put(key, cell);
	}

	public Collection<Cell> getCells() {
		return mCells.values();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(mID);
		for (Cell cell : mCells.values()) {
			sb.append(Configuration.SEPARATOR_COLUMN + cell.toString());
		}

		return sb.toString();
	}
}
