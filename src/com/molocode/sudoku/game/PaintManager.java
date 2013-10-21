package com.molocode.sudoku.game;

import com.hifreshday.android.pge.engine.options.EngineOptions;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;

public class PaintManager {

	private static PaintManager instance;
	private float scale;
	
	private Paint dialogBgPaint;
	private Paint choicedBgPaint;
	private Paint whitePaint;
	private Paint textWhitePaint;
	private Paint textBlackPaint;
	
	private Paint textBlack40Paint;
	
	
	public static void initPaintManager(Context context) {
		instance = new PaintManager(context);
	}
	
	public static PaintManager getInstance() {
		return instance;
	}
	
	private PaintManager(){
	}
	
	private PaintManager(Context context) {
		scale = EngineOptions.getScreenScaleX()>EngineOptions.getScreenScaleY()?
				EngineOptions.getScreenScaleY():EngineOptions.getScreenScaleX();
				
		dialogBgPaint = new Paint();
		whitePaint = new Paint();
		textWhitePaint = new Paint();
		choicedBgPaint = new Paint();
		textBlackPaint = new Paint();
		textBlack40Paint = new Paint();
		initPaint(context);
	}
	
	private void initPaint(Context context) {
		dialogBgPaint.setARGB(85, 0, 0, 0);
		dialogBgPaint.setStyle(Paint.Style.FILL);
		dialogBgPaint.setAntiAlias(true);
		
		choicedBgPaint.setARGB(175, 0, 0, 0);
		choicedBgPaint.setStyle(Paint.Style.FILL);
		choicedBgPaint.setAntiAlias(true);

		
		whitePaint.setColor(Color.WHITE);
		whitePaint.setStyle(Paint.Style.FILL);
		whitePaint.setAntiAlias(true);
		whitePaint.setStrokeWidth((float) 4.0*scale); 
		
		textWhitePaint.setColor(Color.WHITE);
		textWhitePaint.setStyle(Paint.Style.FILL);
		textWhitePaint.setAntiAlias(true);
		textWhitePaint.setTextSize(64*scale);
		
		textBlackPaint.setColor(Color.BLACK);
		textBlackPaint.setStyle(Paint.Style.FILL);
		textBlackPaint.setAntiAlias(true);
		textBlackPaint.setTextSize(64*scale);
		
		textBlack40Paint.setColor(Color.BLACK);
		textBlack40Paint.setStyle(Paint.Style.FILL);
		textBlack40Paint.setAntiAlias(true);
		textBlack40Paint.setTextSize(40*scale);
	}
	
	public Paint getTextBlack40Paint() {
		return textBlack40Paint;
	}
	
	public Paint getTextBlackPaint() {
		return textBlackPaint;
	}
	
	public Paint getChoicedPaint() {
		return choicedBgPaint;
	}
	
	public Paint getTextWhitePaint(){
		return textWhitePaint;
	}
	
	public Paint getDialogBgPaint() {
		return dialogBgPaint;
	}

	public Paint getWhitePaint() {
		return whitePaint;
	}
}