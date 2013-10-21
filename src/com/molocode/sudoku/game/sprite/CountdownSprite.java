package com.molocode.sudoku.game.sprite;

import android.graphics.Canvas;
import com.hifreshday.android.pge.engine.options.EngineOptions;
import com.hifreshday.android.pge.entity.shape.sprite.Sprite;
import com.hifreshday.android.pge.view.res.IBitmapRes;
import com.molocode.sudoku.game.PaintManager;

public class CountdownSprite extends Sprite {

	public static final int X = 100;
	public static final int Y = 10;
	public static final int WIDTH = 280;
	public static final int HEIGHT = 80;
	
	public CountdownSprite(IBitmapRes bitmapRes, int pX, int pY, int width,
			int height) {
		super(bitmapRes, pX, pY, width, height);
	}
	
	@Override
	public void onDrawSelf(Canvas canvas) {
		float width = PaintManager.getInstance().getTextBlackPaint().measureText("00:00");
		canvas.drawText("00:00", 
				getX() + (getWidth()-width)/2, 
				getY() + 60*EngineOptions.getScreenScaleY(), 
				PaintManager.getInstance().getTextBlackPaint());
	}
	
	@Override
	protected void onUpdateSelf(float secondsElapsed) {
		// TODO : 计时器
		// TODO : 计时器到后要弹出失败的界面
	}
	
}
