package com.molocode.sudoku.game.sprite;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.hifreshday.android.pge.engine.options.EngineOptions;
import com.hifreshday.android.pge.entity.shape.sprite.Sprite;
import com.hifreshday.android.pge.view.res.IBitmapRes;
import com.molocode.sudoku.game.GameScene44;
import com.molocode.sudoku.game.PaintManager;
import com.molocode.sudoku.game.domain.Board44;
import com.molocode.sudoku.game.domain.Cell;
import com.molocode.sudoku.game.domain.SuccessSudoku;

public class Chessboard44Sprite extends Sprite 
		implements SuccessSudoku{
	
	private final static int CELL_NUMBER = 16;
	private static final int RECT_WIDTH = 100;
	private static final int RECT_LINE_WIDTH = 4;
	
	public static final int X = 30;
	public static final int Y = 100;
	public static final int WIDTH = 420;
	public static final int HEIGHT = 420;
	
	private Rect[] rect44 = new Rect[Board44.CELLS_LENGTH];
	
	private static final int NO_CHOICED = 100;
	private int currentChoicedPosition = NO_CHOICED;
	
	private Board44 board44;

	public Chessboard44Sprite(IBitmapRes bitmapRes, int pX, int pY, int width,
			int height) {
		super(bitmapRes, pX, pY, width, height);
		init44Rect();
	}
	
	public void initCells(Cell[] cells) {
		board44 = new Board44();
		board44.registerSuccess(this);
		board44.initCells(cells);
	}
	
	
	private void init44Rect() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				rect44[i*4 + j] = new Rect(
						getX() + (int)((4*(j+1) + j*100)*EngineOptions.getScreenScaleX()),
						getY() + (int)((4*(i+1) + i*100)*EngineOptions.getScreenScaleY()),
						getX() + (int)((4*(j+1) + (j+1)*100)*EngineOptions.getScreenScaleX()),
						getY() + (int)((4*(i+1) + (i+1)*100)*EngineOptions.getScreenScaleY()));
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_DOWN && 
				getRect().contains((int)event.getX(), (int)event.getY())) {
			for(int i=0;i<16;i++) {
				if(rect44[i].contains((int)event.getX(), (int)event.getY())) {
					if(board44.getCells(i).isInputCell()) {
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
			canvas.drawRect(rect44[currentChoicedPosition], PaintManager.getInstance().getChoicedPaint());
		}
	}


	private void drawNumbers(Canvas canvas) {
		for(int i=0;i<CELL_NUMBER;i++) {
			if(board44.getCells(i).getNumber() != Cell.NOTHING_IN_CELL) {
				float width = PaintManager.getInstance().getTextWhitePaint().measureText(""+board44.getCells(i).getNumber());
				canvas.drawText(""+board44.getCells(i).getNumber(), 
					rect44[i].left + (RECT_LINE_WIDTH + ((RECT_WIDTH - width)/2))*EngineOptions.getScreenScaleX(), 
					rect44[i].top + (RECT_LINE_WIDTH + ((RECT_WIDTH - width)/2) + width)*EngineOptions.getScreenScaleY(), 
					board44.getCells(i).isInputCell()?
						PaintManager.getInstance().getTextWhitePaint():PaintManager.getInstance().getTextBlackPaint());
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
		canvas.drawLine(
				getX() + EngineOptions.getScreenScaleX()*106, getY(), 
				getX() + EngineOptions.getScreenScaleX()*106, getY()  + getHeight(),
				PaintManager.getInstance().getWhitePaint());
		canvas.drawLine(
				getX() + EngineOptions.getScreenScaleX()*210, getY(), 
				getX() + EngineOptions.getScreenScaleX()*210, getY()  + getHeight(),
				PaintManager.getInstance().getWhitePaint());
		canvas.drawLine(
				getX() + EngineOptions.getScreenScaleX()*314, getY(), 
				getX() + EngineOptions.getScreenScaleX()*314, getY()  + getHeight(),
				PaintManager.getInstance().getWhitePaint());
		
		canvas.drawLine(
				getX(), getY() + EngineOptions.getScreenScaleX()*106, 
				getX() + getWidth(), getY()  + EngineOptions.getScreenScaleX()*106,
				PaintManager.getInstance().getWhitePaint());
		canvas.drawLine(
				getX(), getY() + EngineOptions.getScreenScaleX()*210, 
				getX() + getWidth(), getY()  + EngineOptions.getScreenScaleX()*210,
				PaintManager.getInstance().getWhitePaint());
		canvas.drawLine(
				getX(), getY() + EngineOptions.getScreenScaleX()*314, 
				getX() + getWidth(), getY()  + EngineOptions.getScreenScaleX()*314,
				PaintManager.getInstance().getWhitePaint());
		
	}

	private void drawBg(Canvas canvas) {
		canvas.drawRect(getRect(), PaintManager.getInstance().getDialogBgPaint());
	}
	
	public void numberChangeRequest(int number) {
		if( !(board44 != null && board44.getCellsCount() > number) ) {
			return ;
		}
		if(currentChoicedPosition != NO_CHOICED) {
			board44.updateCellInfo(currentChoicedPosition, number);
		}
	}

	@Override
	public void success() {
		((GameScene44)getParent()).updateUiSuccessGame();
	}
}
