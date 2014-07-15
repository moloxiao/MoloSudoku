package com.molocode.sudoku.game.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School {

	public static final int SCHOOL_TYPE_ABLE = 0;
	public static final int SCHOOL_TYPE_DEGREEUNABLE = 1;
	public static final int SCHOOL_TYPE_AGEUNABLE = 2;

	private int id;
	private String name;
	private String location;
	private int schoolType;// 0普通学校，1重点学校 ，2私立学校
	private int playerUsed;// 0玩家没来过，1玩家来过
	private int playProperty;// 0可读学校,1学历不可读，2年龄不可读
	List<Examination> examinations;// 当前学校考试的列表

	public School() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

	public int getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(int schoolType) {
		this.schoolType = schoolType;
	}

	public int getPlayerUsed() {
		return playerUsed;
	}

	public void setPlayerUsed(int playerUsed) {
		this.playerUsed = playerUsed;
	}

	public int getPlayProperty() {
		return playProperty;
	}

	public void setPlayProperty(int playProperty) {
		this.playProperty = playProperty;
	}

	public static List<Examination> getExaminationlistById(int id) {
		return getExaminationsByMap(getDefaultMap(id));
	}

	// 获取当前学校里的所有考试
	private static List<Examination> getExaminationsByMap(
			Map<Integer, String> map) {
		List<Examination> examinations = new ArrayList<Examination>();
		for (int i = 0; i < map.size(); i++) {
			String examInfo = map.get(i);
			String[] examinfos = examInfo.split("#");
			Examination exam = new Examination();
			exam.setExaminationName(examinfos[0]);
			exam.setPassTime(Integer.valueOf(examinfos[1]));
			exam.setMapType(Integer.valueOf(examinfos[2]));
			exam.setMapId(Integer.valueOf(examinfos[3]));
			exam.setExamLevel(Integer.valueOf(examinfos[4]));
			examinations.add(exam);
		}
		return examinations;
	}

	private static Map<Integer, String> getDefaultMap(int id) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		switch (id) {
		case 0:
			map = getMap0();
			break;
		case 1:
			map = getMap1();
			break;
		case 2:
			map = getMap2();
			break;
		case 3:
			map = getMap3();
			break;
		case 4:
			map = getMap4();
			break;
		case 5:
			map = getMap5();
			break;
		case 6:
			map = getMap6();
			break;
		case 7:
			map = getMap7();
			break;
		case 8:
			map = getMap8();
			break;
		case 9:
			map = getMap9();
			break;
		case 10:
			map = getMap10();
			break;
		case 11:
			map = getMap11();
			break;
		case 12:
			map = getMap12();
			break;
		case 13:
			map = getMap13();
			break;
		case 14:
			map = getMap14();
			break;
		default:
			map = getMap1();
			break;
		}
		return map;
	}

	// examinationName-passTime-mapType-mapId
	private static Map<Integer, String> getMap0() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "A1年级期末考#180#0#1#1");
		map.put(1, "A2年级期末考#150#0#2#2");
		map.put(2, "A3年级期末考#120#0#3#3");
		map.put(3, "A4年级期末考#90#0#4#4");
		map.put(4, "A5年级期末考#60#0#5#5");
		map.put(5, "A小升初考试#30#0#6#6");
		return map;
	}

	// examinationName-passTime-mapType-mapId
	private static Map<Integer, String> getMap1() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "B1年级期末考#180#0#1#1");
		map.put(1, "B2年级期末考#150#0#2#2");
		map.put(2, "B3年级期末考#120#0#3#3");
		map.put(3, "B4年级期末考#90#0#4#4");
		map.put(4, "B5年级期末考#60#0#5#5");
		map.put(5, "B小升初考试#30#0#6#6");
		return map;
	}

	// examinationName-passTime-mapType-mapId
	private static Map<Integer, String> getMap2() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "C1年级期末考#180#0#1#1");
		map.put(1, "C2年级期末考#150#0#2#2");
		map.put(2, "C3年级期末考#120#0#3#3");
		map.put(3, "C4年级期末考#90#0#4#4");
		map.put(4, "C5年级期末考#60#0#5#5");
		map.put(5, "C小升初考试#30#0#6#6");
		return map;
	}

	// examinationName-passTime-mapType-mapId
	private static Map<Integer, String> getMap3() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "A7年级上期末考#180#0#1#1");
		map.put(1, "A7年级下期末考#150#0#2#2");
		map.put(2, "A8年级上期末考#120#0#3#3");
		map.put(3, "A8年级下期末考#90#0#4#4");
		map.put(4, "A9年级上期末考#60#0#5#5");
		map.put(5, "A中考#30#0#6");
		return map;
	}

	// examinationName-passTime-mapType-mapId
	private static Map<Integer, String> getMap4() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "B7年级上期末考#180#0#1#1");
		map.put(1, "B7年级下期末考#150#0#2#2");
		map.put(2, "B8年级上期末考#120#0#3#3");
		map.put(3, "B8年级下期末考#90#0#4#4");
		map.put(4, "B9年级上期末考#60#0#5#5");
		map.put(5, "B中考#30#0#6");
		return map;
	}

	// examinationName-passTime-mapType-mapId
	private static Map<Integer, String> getMap5() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "C7年级上期末考#180#0#1#1");
		map.put(1, "C7年级下期末考#150#0#2#2");
		map.put(2, "C8年级上期末考#120#0#3#3");
		map.put(3, "C8年级下期末考#90#0#4#4");
		map.put(4, "C9年级上期末考#60#0#5#5");
		map.put(5, "C中考#30#0#6");
		return map;
	}

	// examinationName-passTime-mapType-mapId
	private static Map<Integer, String> getMap6() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "A高一上期末考#180#1#1#1");
		map.put(1, "A高一下期末考#150#1#2#2");
		map.put(2, "A高二上期末考#120#1#3#3");
		map.put(3, "A高二下期末考#90#1#4#4");
		map.put(4, "A高三上期末考#60#1#5#5");
		map.put(5, "A高考#30#1#6");
		return map;
	}

	// examinationName-passTime-mapType-mapId
	private static Map<Integer, String> getMap7() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "B高一上期末考#180#1#1#1");
		map.put(1, "B高一下期末考#150#1#2#2");
		map.put(2, "B高二上期末考#120#1#3#3");
		map.put(3, "B高二下期末考#90#1#4#4");
		map.put(4, "B高三上期末考#60#1#5#5");
		map.put(5, "B高考#30#1#6");
		return map;
	}

	// examinationName-passTime-mapType-mapId
	private static Map<Integer, String> getMap8() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "C高一上期末考#180#1#1#1");
		map.put(1, "C高一下期末考#150#1#2#2");
		map.put(2, "C高二上期末考#120#1#3#3");
		map.put(3, "C高二下期末考#90#1#4#4");
		map.put(4, "C高三上期末考#60#1#5#5");
		map.put(5, "C高考#30#1#6#6");
		return map;
	}

	// examinationName-passTime-mapType-mapId
	private static Map<Integer, String> getMap9() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "A大一上期末考#180#1#1#1");
		map.put(1, "A大一下期末考#150#1#2#2");
		map.put(2, "A大二上期末考#120#1#3#3");
		map.put(3, "A大二下期末考#90#1#4#4");
		map.put(4, "A大三上期末考#60#1#5#5");
		map.put(5, "A大三下期末考#30#1#6#6");
		map.put(6, "A大四下期末考#30#1#6#7");
		map.put(7, "A毕业论文#30#1#6#8");
		return map;
	}

	// examinationName-passTime-mapType-mapId
	private static Map<Integer, String> getMap10() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "B大一上期末考#180#1#1#1");
		map.put(1, "B大一下期末考#150#1#2#2");
		map.put(2, "B大二上期末考#120#1#3#3");
		map.put(3, "B大二下期末考#90#1#4#4");
		map.put(4, "B大三上期末考#60#1#5#5");
		map.put(5, "B大三下期末考#30#1#6#6");
		map.put(6, "B大四下期末考#30#1#6#7");
		map.put(7, "B毕业论文#30#1#6#8");
		return map;
	}

	// examinationName-passTime-mapType-mapId
	private static Map<Integer, String> getMap11() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "C大一上期末考#180#1#1#1");
		map.put(1, "C大一下期末考#150#1#2#2");
		map.put(2, "C大二上期末考#120#1#3#3");
		map.put(3, "C大二下期末考#90#1#4#4");
		map.put(4, "C大三上期末考#60#1#5#5");
		map.put(5, "C大三下期末考#30#1#6#6");
		map.put(6, "C大四下期末考#30#1#6#7");
		map.put(7, "C毕业论文#30#1#6#8");
		return map;
	}

	// examinationName-passTime-mapType-mapId
	private static Map<Integer, String> getMap12() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "A研一上期末考#180#0#1#1");
		map.put(1, "A研一下期末考#150#0#2#2");
		map.put(2, "A研二上期末考#120#0#3#3");
		map.put(3, "A研二下期末考#90#0#4#4");
		map.put(4, "A研三上期末考#60#0#5#5");
		map.put(5, "A毕业论文#30#0#6#6");
		return map;
	}

	// examinationName-passTime-mapType-mapId
	private static Map<Integer, String> getMap13() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "B研一上期末考#180#0#1#1");
		map.put(1, "B研一下期末考#150#0#2#2");
		map.put(2, "B研二上期末考#120#0#3#3");
		map.put(3, "B研二下期末考#90#0#4#4");
		map.put(4, "B研三上期末考#60#0#5#5");
		map.put(5, "B毕业论文#30#0#6#6");
		return map;
	}

	// examinationName-passTime-mapType-mapId
	private static Map<Integer, String> getMap14() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "C研一上期末考#180#0#1#1");
		map.put(1, "C研一下期末考#150#0#2#2");
		map.put(2, "C研二上期末考#120#0#3#3");
		map.put(3, "C研二下期末考#90#0#4#4");
		map.put(4, "C研三上期末考#60#0#5#5");
		map.put(5, "C毕业论文#30#0#6#6");
		return map;
	}
}
