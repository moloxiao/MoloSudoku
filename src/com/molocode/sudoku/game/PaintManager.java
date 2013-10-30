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
	private Paint textWhite64Paint;
	private Paint textBlack64Paint;
	
	private Paint textBlack40Paint;
	private Paint textWhite40Paint;
	
	
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
		textWhite64Paint = new Paint();
		choicedBgPaint = new Paint();
		textBlack64Paint = new Paint();
		textBlack40Paint = new Paint();
		textWhite40Paint = new Paint();
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
		
		textWhite64Paint.setColor(Color.WHITE);
		textWhite64Paint.setStyle(Paint.Style.FILL);
		textWhite64Paint.setAntiAlias(true);
		textWhite64Paint.setTextSize(64*scale);
		
		textBlack64Paint.setColor(Color.BLACK);
		textBlack64Paint.setStyle(Paint.Style.FILL);
		textBlack64Paint.setAntiAlias(true);
		textBlack64Paint.setTextSize(64*scale);
		
		textBlack40Paint.setColor(Color.BLACK);
		textBlack40Paint.setStyle(Paint.Style.FILL);
		textBlack40Paint.setAntiAlias(true);
		textBlack40Paint.setTextSize(40*scale);
		
		textWhite40Paint.setColor(Color.BLACK);
		textWhite40Paint.setStyle(Paint.Style.FILL);
		textWhite40Paint.setAntiAlias(true);
		textWhite40Paint.setTextSize(40*scale);
	}
	
	public Paint getTextWhite40Paint() {
		return textBlack40Paint;
	}
	
	public Paint getTextBlack40Paint() {
		return textBlack40Paint;
	}
	
	public Paint getTextBlack64Paint() {
		return textBlack64Paint;
	}
	
	public Paint getChoicedPaint() {
		return choicedBgPaint;
	}
	
	public Paint getTextWhite64Paint(){
		return textWhite64Paint;
	}
	
	public Paint getDialogBgPaint() {
		return dialogBgPaint;
	}

	public Paint getWhitePaint() {
		return whitePaint;
	}
}