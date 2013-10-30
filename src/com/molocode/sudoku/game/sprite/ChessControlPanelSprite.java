package com.molocode.sudoku.game.sprite;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;

import com.hifreshday.android.pge.engine.options.EngineOptions;
import com.hifreshday.android.pge.entity.shape.sprite.Sprite;
import com.hifreshday.android.pge.view.res.IBitmapRes;
import com.molocode.sudoku.game.BaseSudokuScene;
import com.molocode.sudoku.game.PaintManager;

public class ChessControlPanelSprite extends Sprite {

	private final static int CONTROL_CELL_NUMBER = 5;
	private static final int RECT_WIDTH = 80;
	private static final int RECT_LINE_WIDTH = 4;
	
	public static final int X = 28;
	public static final int Y = 600;
	public static final int WIDTH = 424;
	public static final int HEIGHT = 88;
	public static final int HEIGHT_2 = 172;
	
	private Rect[] rectControlline1 = new Rect[CONTROL_CELL_NUMBER];
	private static final String[] ControlTitleLine1 = {"1", "2", "3", "4", "C"};
	private Rect[] rectControlline2 = new Rect[CONTROL_CELL_NUMBER];
	private static final String[] ControlTitleLine2 = {"5", "6", "7", "8", "9"};
	
	private boolean singleline = true;
	
	public ChessControlPanelSprite(IBitmapRes bitmapRes, int pX, int pY,
			int width, int height, boolean single) {
		super(bitmapRes, pX, pY, width, height);
		singleline = single;
		initRect();
	}

	private void initRect() {
		for(int i=0;i<CONTROL_CELL_NUMBER;i++) {
			rectControlline1[i] = new Rect(
					getX() + (int)((RECT_LINE_WIDTH*(i+1) + i*RECT_WIDTH)*EngineOptions.getScreenScaleX()),
					getY() + (int)((RECT_LINE_WIDTH)*EngineOptions.getScreenScaleY()),
					getX() + (int)((RECT_LINE_WIDTH*(i+1) + (i+1)*RECT_WIDTH)*EngineOptions.getScreenScaleX()),
					getY() + (int)((RECT_WIDTH + RECT_LINE_WIDTH)*EngineOptions.getScreenScaleY()));
			if(!singleline) {
				rectControlline2[i] = new Rect(
						rectControlline1[i].left,
						rectControlline1[i].bottom + (int)((RECT_LINE_WIDTH)*EngineOptions.getScreenScaleY()),
						rectControlline1[i].right,
						rectControlline1[i].bottom + (int)((RECT_WIDTH + RECT_LINE_WIDTH)*EngineOptions.getScreenScaleY()));
				
			}
		}
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_DOWN && 
				getRect().contains((int)event.getX(), (int)event.getY())) {
			for(int i=0;i<CONTROL_CELL_NUMBER;i++) {
				if(rectControlline1[i].contains((int)event.getX(), (int)event.getY())) {
					((BaseSudokuScene)(getParent())).updateUiNumberChangeRequest(
							ChessControlPanelSprite.getPositionControlNumberline1(i));
					return true;
				}
				if(!singleline) {
					if(rectControlline2[i].contains((int)event.getX(), (int)event.getY())) {
						Log.i("MOLO_DEBUG", "rectControlline2[" + i+ "] click");
						((BaseSudokuScene)(getParent())).updateUiNumberChangeRequest(
								ChessControlPanelSprite.getPositionControlNumberline2(i));
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void onDrawSelf(Canvas canvas) {
		drawLines(canvas);
		drawTitle(canvas);
	}

	private void drawTitle(Canvas canvas) {
		float height = PaintManager.getInstance().getTextWhite64Paint().measureText(ControlTitleLine1[0]);
		for(int i=0;i<CONTROL_CELL_NUMBER;i++) {
			float width = PaintManager.getInstance().getTextWhite64Paint().measureText(ControlTitleLine1[i]);
			canvas.drawText(ControlTitleLine1[i], 
					rectControlline1[i].left + (RECT_LINE_WIDTH + ((RECT_WIDTH - width)/2))*EngineOptions.getScreenScaleX(), 
					rectControlline1[i].top + (RECT_LINE_WIDTH + ((RECT_WIDTH - height)/2) + height)*EngineOptions.getScreenScaleY(), 
					PaintManager.getInstance().getTextWhite64Paint());
			if(!singleline) {
				canvas.drawText(ControlTitleLine2[i], 
						rectControlline2[i].left + (RECT_LINE_WIDTH + ((RECT_WIDTH - width)/2))*EngineOptions.getScreenScaleX(), 
						rectControlline2[i].top + (RECT_LINE_WIDTH + ((RECT_WIDTH - height)/2) + height)*EngineOptions.getScreenScaleY(), 
						PaintManager.getInstance().getTextWhite64Paint());
			}
		}
		
	}

	private void drawLines(Canvas canvas) {
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
		if(!singleline) {
			canvas.drawLine(
					getX(), getY() + getHeight()/2 + EngineOptions.getScreenScaleY()*2, 
					getX() + getWidth(), getY() + getHeight()/2 + EngineOptions.getScreenScaleY()*2, 
					PaintManager.getInstance().getWhitePaint());
		}
	}
	
	private void drawSplitLine(Canvas canvas) {
		canvas.drawLine(
				getX() + EngineOptions.getScreenScaleX()*86, getY(), 
				getX() + EngineOptions.getScreenScaleX()*86, getY()  + getHeight(),
				PaintManager.getInstance().getWhitePaint());
		canvas.drawLine(
				getX() + EngineOptions.getScreenScaleX()*170, getY(), 
				getX() + EngineOptions.getScreenScaleX()*170, getY()  + getHeight(),
				PaintManager.getInstance().getWhitePaint());
		canvas.drawLine(
				getX() + EngineOptions.getScreenScaleX()*254, getY(), 
				getX() + EngineOptions.getScreenScaleX()*254, getY()  + getHeight(),
				PaintManager.getInstance().getWhitePaint());
		canvas.drawLine(
				getX() + EngineOptions.getScreenScaleX()*338, getY(), 
				getX() + EngineOptions.getScreenScaleX()*338, getY()  + getHeight(),
				PaintManager.getInstance().getWhitePaint());
	}
	
	private static int getPositionControlNumberline1(int position) {
		switch(position) {
		case 0:
			return 1;
		case 1:
			return 2;
		case 2:
			return 3;
		case 3:
			return 4;
		case 4:
			return 0;
		}
		return 0;
	}
	
	private static int getPositionControlNumberline2(int position) {
		switch(position) {
		case 0:
			return 5;
		case 1:
			return 6;
		case 2:
			return 7;
		case 3:
			return 8;
		case 4:
			return 9;
		}
		return 0;
	}
}
