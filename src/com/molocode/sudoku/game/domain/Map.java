package com.molocode.sudoku.game.domain;

public class Map {
	
	public static final int MAP_TYPE_44 = 0;
	public static final int MAP_TYPE_66 = 1;
	public static final int MAP_TYPE_99_1 = 2;
	
	/**
	 * 获取章节下关卡的数量
	 * @param dificuty
	 * @return
	 */
	public static int getChapterLevels(int dificuty) {
		switch(dificuty) {
		case MAP_TYPE_44:
			return MAPS44.length;
		case MAP_TYPE_66:
			return MAPS66.length;
		case MAP_TYPE_99_1:
			return MAPS99.length;
		}
		return 0;
	}
	
	/**
	 * 返回数独的结果
	 * @param type
	 * @param level
	 * @return
	 */
	public static int[] getCellMapsResult(int type, int level) {
		switch(type) {
		case MAP_TYPE_44:
			return getcells(level, MAPS44_RESULT);
		case MAP_TYPE_66:
			return getcells(level, MAPS66_RESULT);
		case MAP_TYPE_99_1:
			return getcells(level, MAPS99_RESULT);
		}
		return null;
	}

	public static int[] getCellMaps(int type, int level) {
		switch(type) {
		case MAP_TYPE_44:
			return getcells(level, MAPS44);
		case MAP_TYPE_66:
			return getcells(level, MAPS66);
		case MAP_TYPE_99_1:
			return getcells(level, MAPS99);
		}
		return null;
	}
	
	private static int[] getcells(int level, String[] maps) {
		if( maps.length > level) {
			return formatMaps(maps[level]);
		}else {
			return formatMaps(maps[level%maps.length]);
		}
	}
	
	private static int[] formatMaps(String map) {
		if(map == null) {
			return null;
		}
		int[] results = new int[map.length()];
		for(int i=0;i<map.length();i++) {
			results[i] = map.charAt(i) - '0';
		}
		return results;
	}
	
	private static String[] MAPS44 = {
		"3041010003141003",
		"4301004301300402",
		"1020030440010142",
		"0204402020311300",
		"2104002012030410",		// 5
		"2040040210300301",
		"3400003403100103",
		"3001140003044030",
		"4200002414000041",
		"0000300000400230",		//10
		"0400000410000030",
		"2000300200000040",
		"0010000003020200",
		"0400000000300204",
		"0001042000003000",		// 15
		"0030200000003400",
		"0403010000400000",
		"0002300004000040",
		"0003200040000010",
		"2030430000000002"};		// 20		
	
	private static String[] MAPS44_RESULT = {
		"3241413223141423",
		"4321124321343412",
		"1423231442313142",
		"3214412324311342",
		"2134432112433412",
		"2143341212344321",
		"3421123443122143",
		"3241142323144132",
		"4213312414322341",
		"0000300000400230",		//TODO : 10
		"0400000410000030",
		"2000300200000040",
		"0010000003020200",
		"0400000000300204",
		"0001042000003000",		// 15
		"0030200000003400",
		"0403010000400000",
		"0002300004000040",
		"0003200040000010",
		"2030430000000002"};	
	
	private static String[] MAPS66 = {
		"412030053142320014541326164203030460",
		"540263306510213056050130465321130605"};
	
	
	private static String[] MAPS66_RESULT = {
		"412635653142326514541326164253235461",
		"541263326514213456654132465321132645"};
	
	private static String[] MAPS99 = {
		"030800000905600700001093200806500000040030000000000000472306950019487060368259010", 
		"052006000160900004049803620400000800083201590001000002097305240200009056000100970",
		"052400100100002030000813025400007010683000597070500002890365000010700006006004970",
		"302000089068052734009000000400007000083201590000500002000000200214780350530000908",
		"402000007000080420050302006090030050503060708070010060900406030015070000200000809",
		"060091080109680405050040106600000200023904710004000003907020030305079602040150070",
		"060090380009080405050300106001008200020904010004200900907006030305070600046050070",
		"402000380109607400008300106090030004023964710800010060907006500005809602046000809",
		"400091000009007425058340190691000000003964700000000963087026530315800600000150009",
		"380001004002600070000487003000040239201000406495060000600854000070006800800700092",
		"007520060002009008006407000768005009031000450400300781000804300100200800050013600",
		"380000000540009078000407503000145209000908000405362000609804000170200045000000092",
		"007001000540609078900487000760100230230000056095002081000854007170206045000700600",
		"007021900502009078006407500000140039031908450490062000009804300170200805004710600",
		"086500204407008090350009000009080601010000080608090300000200076030800409105004820",
		"086507000007360100000000068249003050500000007070100342890000000002056400000904820",
		"000007230420368000050029768000080650000602000078090000894230070000856019065900000",
		"906000200400368190350400000209080051013040980670090302000001076032856009005000803",
		"095002000700804001810076500476000302000000000301000857003290075500307006000400130",
		"005002740002850901810000500070501302008723600301609050003000075509017200087400100",
		"605102740732004001000000020400501300008020600001609007060000000500300286087405109",
		"695102040700800000000970023076000090900020004020000850160098000000007006080405139",
		"090002748000004901800906500470500090008000600020009057003208005509300000287400030",
		"001009048089070030003106005390000500058602170007000094900708300030040860870300400",
		"600039708000004600000100025002017506408000103107850200910008000005900000806320009",
		"620500700500270631040100005302000086000090000160000204900008050235041007006005019",
		"080130002140902007273080000000070206007203900502040000000060318600308024400021050",
		"980100402046950000200684001010009086007000900590800070700465008000098720408001059",
		"085100400000950007073684001010070080067203940090040070700465310600098000008001650",
		"085100460146000807070004001300009080067000940090800003700400010601000724038001650",
		"085130462006000007270680090000009200060213040002800000020065018600000700438021650"};
	
	private static String[] MAPS99_RESULT = {
		"030800000905600700001093200806500000040030000000000000472306950019487060368259010", 
		"052006000160900004049803620400000800083201590001000002097305240200009056000100970",
		"052400100100002030000813025400007010683000597070500002890365000010700006006004970",
		"302000089068052734009000000400007000083201590000500002000000200214780350530000908",
		"402000007000080420050302006090030050503060708070010060900406030015070000200000809",
		"060091080109680405050040106600000200023904710004000003907020030305079602040150070",
		"060090380009080405050300106001008200020904010004200900907006030305070600046050070",
		"402000380109607400008300106090030004023964710800010060907006500005809602046000809",
		"400091000009007425058340190691000000003964700000000963087026530315800600000150009",
		"380001004002600070000487003000040239201000406495060000600854000070006800800700092",
		"007520060002009008006407000768005009031000450400300781000804300100200800050013600",
		"380000000540009078000407503000145209000908000405362000609804000170200045000000092",
		"007001000540609078900487000760100230230000056095002081000854007170206045000700600",
		"007021900502009078006407500000140039031908450490062000009804300170200805004710600",
		"086500204407008090350009000009080601010000080608090300000200076030800409105004820",
		"086507000007360100000000068249003050500000007070100342890000000002056400000904820",
		"000007230420368000050029768000080650000602000078090000894230070000856019065900000",
		"906000200400368190350400000209080051013040980670090302000001076032856009005000803",
		"095002000700804001810076500476000302000000000301000857003290075500307006000400130",
		"005002740002850901810000500070501302008723600301609050003000075509017200087400100",
		"605102740732004001000000020400501300008020600001609007060000000500300286087405109",
		"695102040700800000000970023076000090900020004020000850160098000000007006080405139",
		"090002748000004901800906500470500090008000600020009057003208005509300000287400030",
		"001009048089070030003106005390000500058602170007000094900708300030040860870300400",
		"600039708000004600000100025002017506408000103107850200910008000005900000806320009",
		"620500700500270631040100005302000086000090000160000204900008050235041007006005019",
		"080130002140902007273080000000070206007203900502040000000060318600308024400021050",
		"980100402046950000200684001010009086007000900590800070700465008000098720408001059",
		"085100400000950007073684001010070080067203940090040070700465310600098000008001650",
		"085100460146000807070004001300009080067000940090800003700400010601000724038001650",
		"085130462006000007270680090000009200060213040002800000020065018600000700438021650"};
}
