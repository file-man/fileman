package com.fileman.document;

import java.util.List;

import com.data.kit.utils.StringUtils;

public class Cell {

	private String mKey;
	private String mValue;

	public Cell(String key, String value) {
		mKey = key;
		mValue = value;
	}
	
	public static final Cell parse(String data) {
		List<String> cell = StringUtils.splitGetFirstByKey(data, Configuration.SEPARATOR_VALUE, true);
		
		return new Cell(cell.get(0), cell.get(1));
	}

	public String getKey() {
		return mKey;
	}
	
	public String getValue() {
		return mValue;
	}
	
	@Override
	public String toString() {
		return mKey + Configuration.SEPARATOR_VALUE + mValue;
	}
}
