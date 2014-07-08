package com.molocode.sudoku.domain;

import java.util.List;

public class Chapter {

	private String name;
	private boolean isLock;
	private List<Level> levels;
	
	public Chapter(String name, boolean isLock, List<Level> levels) {
		super();
		this.name = name;
		this.isLock = isLock;
		this.levels = levels;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLock() {
		return isLock;
	}

	public void setLock(boolean isLock) {
		this.isLock = isLock;
	}

	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}
	
	public static List<Chapter> getChapterInfo() {
		// TODO : 返回本地存储的章节信息 : by molo
		return Chapter.getDefaultChapterInfo();
	}
	
	private static List<Chapter> getDefaultChapterInfo() {
		// TODO : 初始化的章节信息 : by molo
		return null;
	}
}
