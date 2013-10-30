package com.molocode.sudoku.game.sprite;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.hifreshday.android.pge.engine.options.EngineOptions;
import com.hifreshday.android.pge.entity.shape.sprite.Sprite;
import com.hifreshday.android.pge.view.res.IBitmapRes;
import com.molocode.sudoku.game.BaseSudokuScene;
import com.molocode.sudoku.game.PaintManager;
import com.molocode.sudoku.game.domain.Board99;
import com.molocode.sudoku.game.domain.Cell;
import com.molocode.sudoku.game.domain.SuccessSudoku;

public class Chessboard99Sprite extends Sprite implements SuccessSudoku{


	private static final int RECT_WIDTH = 44; //68
	private static final int RECT_LINE_WIDTH = 4;
	
	public static final int X = 38;
	public static final int Y = 100;
	public static final int WIDTH = 436;
	public static final int HEIGHT = 436;
	
	private Rect[] rect99 = new Rect[Board99.CELLS_LENGTH];
	
	private static final int NO_CHOICED = 100;
	private int currentChoicedPosition = NO_CHOICED;
	
	private Board99 board99;

	public Chessboard99Sprite(IBitmapRes bitmapRes, int pX, int pY, int width,
			int height) {
		super(bitmapRes, pX, pY, width, height);
		init66Rect();
	}
	
	public void initCells(Cell[] cells) {
		board99 = new Board99();
		board99.registerSuccess(this);
		board99.initCells(cells);
	}
	
	
	private void init66Rect() {
		for(int i=0;i<Board99.SIZE;i++) {
			for(int j=0;j<Board99.SIZE;j++) {
				rect99[i*Board99.SIZE + j] = new Rect(
						getX() + (int)((RECT_LINE_WIDTH*(j) + j*RECT_WIDTH + RECT_LINE_WIDTH/2)*EngineOptions.getScreenScaleX()),
						getY() + (int)((RECT_LINE_WIDTH*(i+1) + i*RECT_WIDTH + RECT_LINE_WIDTH/2)*EngineOptions.getScreenScaleY()),
						getX() + (int)((RECT_LINE_WIDTH*(j) + (j+1)*RECT_WIDTH + RECT_LINE_WIDTH/2)*EngineOptions.getScreenScaleX()),
						getY() + (int)((RECT_LINE_WIDTH*(i+1) + (i+1)*RECT_WIDTH + RECT_LINE_WIDTH/2)*EngineOptions.getScreenScaleY()));
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_DOWN && 
				getRect().contains((int)event.getX(), (int)event.getY())) {
			for(int i=0;i<Board99.CELLS_LENGTH;i++) {
				if(rect99[i].contains((int)event.getX(), (int)event.getY())) {
					if(board99.getCells(i).isInputCell()) {
						currentChoicedPosition = i;
					}
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void onDrawSelf(Canvas canvas) {
		drawBg(canvas);
		drawNumbers(canvas);
		drawChoicedRect(canvas);
		drawLine(canvas);
	}

	private void drawChoicedRect(Canvas canvas) {
		if(currentChoicedPosition != NO_CHOICED) {
			canvas.drawRect(rect99[currentChoicedPosition], PaintManager.getInstance().getChoicedPaint());
		}
	}


	private void drawNumbers(Canvas canvas) {
		for(int i=0;i<Board99.CELLS_LENGTH;i++) {
			if(board99.getCells(i).getNumber() != Cell.NOTHING_IN_CELL) {
				float width = PaintManager.getInstance().getTextWhite40Paint().measureText(""+board99.getCells(i).getNumber());
				canvas.drawText(""+board99.getCells(i).getNumber(), 
					rect99[i].left + (RECT_LINE_WIDTH/2 + ((RECT_WIDTH - width)/2))*EngineOptions.getScreenScaleX(), 
					rect99[i].top + (RECT_LINE_WIDTH/2 + ((RECT_WIDTH - width)/2) + width)*EngineOptions.getScreenScaleY(), 
					board99.getCells(i).isInputCell()?
						PaintManager.getInstance().getTextWhite40Paint():PaintManager.getInstance().getTextBlack40Paint());
			}
		}
	}

	private void drawLine(Canvas canvas) {
		drawRoundRect(canvas);
		drawSplitLine(canvas);
	}

	private void drawRoundRect(Canvas canvas) {
		canvas.drawLine(
				getX(), getY() + EngineOptions.getScreenScaleY()*2, 
				getX() + getWidth(), getY() + EngineOptions.getScreenScaleY()*2, 
				PaintManager.getInstance().getWhitePaint());
		canvas.drawLine(
				getX() + getWidth() - EngineOptions.getScreenScaleX()*2, getY(),
				getX() + getWidth() - EngineOptions.getScreenScaleX()*2, getY() + getHeight(), 
				PaintManager.getInstance().getWhitePaint());
		canvas.drawLine(
				getX() + getWidth(), getY() + getHeight() - EngineOptions.getScreenScaleY()*2,
				getX(), getY() + getHeight() - EngineOptions.getScreenScaleX()*2, 
				PaintManager.getInstance().getWhitePaint());
		canvas.drawLine(
				getX() + EngineOptions.getScreenScaleX()*2, getY() + getHeight(), 
				getX() + EngineOptions.getScreenScaleX()*2, getY(),
				PaintManager.getInstance().getWhitePaint());
	}
	
	private void drawSplitLine(Canvas canvas) {
		for(int i=0;i<Board99.SIZE-1;i++) {
			canvas.drawLine(
					getX() + EngineOptions.getScreenScaleX()*(
							(i+1)*(RECT_WIDTH) + (i-0)*RECT_LINE_WIDTH + RECT_LINE_WIDTH), 
					getY(), 
					getX() + EngineOptions.getScreenScaleX()*(
							(i+1)*(RECT_WIDTH) + (i-0)*RECT_LINE_WIDTH + RECT_LINE_WIDTH), 
					getY() + getHeight(),
					PaintManager.getInstance().getWhitePaint());
			canvas.drawLine(
					getX(), 
					getY() + EngineOptions.getScreenScaleX()*(
							(i+1)*(RECT_WIDTH+RECT_LINE_WIDTH) + RECT_LINE_WIDTH/2), 
					getX() + getWidth(), 
					getY()  + EngineOptions.getScreenScaleX()*(
							(i+1)*(RECT_WIDTH+RECT_LINE_WIDTH) + RECT_LINE_WIDTH/2 ),
					PaintManager.getInstance().getWhitePaint());
		}
	}

	private void drawBg(Canvas canvas) {
		canvas.drawRect(getRect(), PaintManager.getInstance().getDialogBgPaint());
	}
	
	public void numberChangeRequest(int number) {
		if( !(board99 != null && board99.getCellsCount() > number) ) {
			return ;
		}
		if(currentChoicedPosition != NO_CHOICED) {
			board99.updateCellInfo(currentChoicedPosition, number);
		}
	}

	@Override
	public void success() {
		((BaseSudokuScene)getParent()).updateUiSuccessGame();
	}


}
