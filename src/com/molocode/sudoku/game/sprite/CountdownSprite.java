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
	
	private float elapse;
	
	public CountdownSprite(IBitmapRes bitmapRes, int pX, int pY, int width,
			int height) {
		super(bitmapRes, pX, pY, width, height);
	}
	
	public void cleanCountTime() {
		elapse = 0.0f;
	}
	
	@Override
	public void onDrawSelf(Canvas canvas) {
		String time = CountdownSprite.getTime(elapse);
		float width = PaintManager.getInstance().getTextBlack64Paint().measureText(time);
		canvas.drawText(time, 
				getX() + (getWidth()-width)/2, 
				getY() + 60*EngineOptions.getScreenScaleY(), 
				PaintManager.getInstance().getTextBlack64Paint());
	}
	
	@Override
	protected void onUpdateSelf(float secondsElapsed) {
		elapse += secondsElapsed;
	}
	
	public static String getTime(float totalSecondsElapsed) {
		int time = (int)totalSecondsElapsed;
		if(time < 60 ) {
			if(time < 10) {
				return "00:0" + time;
			}else {
				return "00:" + time;
			}
		}else {
			int fen = time/60;
			int second = time%60;
			StringBuilder sb = new StringBuilder();
			if(fen >= 10) {
				sb.append(fen+":");
			}else {
				sb.append("0" + fen + ":");
			}
			if(second >= 10){
				sb.append(second+"");
			}else {
			sb.append("0" + second);
			}
			return sb.toString();
		}
	}
	
}
