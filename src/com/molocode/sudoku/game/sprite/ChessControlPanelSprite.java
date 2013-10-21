package com.molocode.sudoku.game.sprite;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.hifreshday.android.pge.engine.options.EngineOptions;
import com.hifreshday.android.pge.entity.shape.sprite.Sprite;
import com.hifreshday.android.pge.view.res.IBitmapRes;
import com.molocode.sudoku.game.GameScene44;
import com.molocode.sudoku.game.PaintManager;

public class ChessControlPanelSprite extends Sprite {

	private final static int CONTROL_CELL_NUMBER = 5;
	private static final int RECT_WIDTH = 80;
	private static final int RECT_LINE_WIDTH = 4;
	
	public static final int X = 28;
	public static final int Y = 600;
	public static final int WIDTH = 424;
	public static final int HEIGHT = 88;
	
	private Rect[] rectControl = new Rect[CONTROL_CELL_NUMBER];
	private static final String[] ControlTitle = {"1", "2", "3", "4", "C"};
	
	public ChessControlPanelSprite(IBitmapRes bitmapRes, int pX, int pY,
			int width, int height) {
		super(bitmapRes, pX, pY, width, height);
		initRect();
	}

	private void initRect() {
		for(int i=0;i<CONTROL_CELL_NUMBER;i++) {
			rectControl[i] = new Rect(
					getX() + (int)((RECT_LINE_WIDTH*(i+1) + i*RECT_WIDTH)*EngineOptions.getScreenScaleX()),
					getY() + (int)((RECT_LINE_WIDTH)*EngineOptions.getScreenScaleY()),
					getX() + (int)((RECT_LINE_WIDTH*(i+1) + (i+1)*RECT_WIDTH)*EngineOptions.getScreenScaleX()),
					getY() + (int)((RECT_WIDTH + RECT_LINE_WIDTH)*EngineOptions.getScreenScaleY()));
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_DOWN && 
				getRect().contains((int)event.getX(), (int)event.getY())) {
			for(int i=0;i<CONTROL_CELL_NUMBER;i++) {
				if(rectControl[i].contains((int)event.getX(), (int)event.getY())) {
					((GameScene44)(getParent())).updateUiNumberChangeRequest(
							ChessControlPanelSprite.getPositionControlNumber(i));
					return true;
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
		float height = PaintManager.getInstance().getTextWhitePaint().measureText(ControlTitle[0]);
		for(int i=0;i<CONTROL_CELL_NUMBER;i++) {
			float width = PaintManager.getInstance().getTextWhitePaint().measureText(ControlTitle[i]);
			canvas.drawText(ControlTitle[i], 
					rectControl[i].left + (RECT_LINE_WIDTH + ((RECT_WIDTH - width)/2))*EngineOptions.getScreenScaleX(), 
					rectControl[i].top + (RECT_LINE_WIDTH + ((RECT_WIDTH - height)/2) + height)*EngineOptions.getScreenScaleY(), 
					PaintManager.getInstance().getTextWhitePaint());
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
	
	private static int getPositionControlNumber(int position) {
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
}
