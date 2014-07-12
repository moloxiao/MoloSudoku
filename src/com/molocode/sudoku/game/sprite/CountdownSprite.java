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
	private static float elapse;
	private static float totaltime;

	public CountdownSprite(IBitmapRes bitmapRes, int pX, int pY, int width,
			int height, float totaltime) {
		super(bitmapRes, pX, pY, width, height);
		CountdownSprite.totaltime = totaltime;
	}

	public void cleanCountTime() {
		elapse = 0.0f;
	}

	@Override
	public void onDrawSelf(Canvas canvas) {
		String time = CountdownSprite.getTime(elapse);
		float width = PaintManager.getInstance().getTextBlack64Paint()
				.measureText(time);
		canvas.drawText(time, getX() + (getWidth() - width) / 2, getY() + 60
				* EngineOptions.getScreenScaleY(), PaintManager.getInstance()
				.getTextBlack64Paint());
	}

	@Override
	protected void onUpdateSelf(float secondsElapsed) {
		elapse += secondsElapsed;
	}

	public static String getTime(float totalSecondsElapsed) {
		int time = (int) totalSecondsElapsed;
		int count = (int) (totaltime - time);
		return String.valueOf(count);
	}

	public static int getPassTime() {
		return Integer.valueOf(getTime(elapse));
	}

}
