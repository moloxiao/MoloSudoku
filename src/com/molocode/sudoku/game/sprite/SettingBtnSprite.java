package com.molocode.sudoku.game.sprite;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.hifreshday.android.pge.entity.shape.sprite.Sprite;
import com.hifreshday.android.pge.view.res.IBitmapRes;
import com.molocode.sudoku.game.GameScene44;
import com.molocode.sudoku.game.PaintManager;

public class SettingBtnSprite extends Sprite {

	public static final int X = 30;
	public static final int Y = 10;
	public static final int WIDTH = 80;
	public static final int HEIGHT = WIDTH;
	
	public SettingBtnSprite(IBitmapRes bitmapRes, int pX, int pY, int width,
			int height) {
		super(bitmapRes, pX, pY, width, height);
	}
	
	@Override
	public void onDrawSelf(Canvas canvas) {
		canvas.drawCircle(
				getX() + getRect().width()/2, 
				getY() + getRect().width()/2, 
				getRect().width()/2, 
				PaintManager.getInstance().getTextWhitePaint());
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_DOWN && 
				getRect().contains((int)event.getX(), (int)event.getY()) ) {
			((GameScene44)getParent()).updateUiShowSetting();
			return true;
		}
		return false;
	}
}
