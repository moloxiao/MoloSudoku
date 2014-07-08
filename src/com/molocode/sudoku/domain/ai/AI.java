package com.molocode.sudoku.domain.ai;

import java.util.ArrayList;
import java.util.List;

import com.molocode.sudoku.game.domain.Map;

public class AI {

	/**
	 * 目前只支持6*6 且是否正确没有判断
	 * @param mapType
	 * @param chapterPosition
	 * @return 提示结果
	 */
	public static List<NotifyCell> getNotifyInfo(int mapType, int chapterPosition) {
		List<NotifyCell> results = new ArrayList<NotifyCell>();
		
		int[] bufferBoard = Map.getCellMaps(mapType, chapterPosition);
		int[] bufferBoardResult = Map.getCellMapsResult(mapType, chapterPosition);
		for(int i=0;i<bufferBoard.length;i++) {
			if(bufferBoard[i] == 0) {
				results.add( new NotifyCell(i,  bufferBoardResult[i], true) );
			}
		}
		return results;
	}
}
