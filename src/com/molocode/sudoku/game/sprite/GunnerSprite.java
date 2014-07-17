package com.molocode.sudoku.game.sprite;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.hifreshday.android.pge.engine.options.EngineOptions;
import com.hifreshday.android.pge.entity.shape.sprite.Sprite;
import com.hifreshday.android.pge.view.res.IBitmapRes;
import com.molocode.sudoku.game.BaseSudokuScene;
import com.molocode.sudoku.game.PaintManager;

public class GunnerSprite extends Sprite {

	public static final int X = 0;
	public static final int Y = 0;
	public static final int WIDTH = (int) EngineOptions.PORTPRAIT_SCREEN_WIDTH;
	public static final int HEIGHT = (int) EngineOptions.PORTPRAIT_SCREEN_HEIGHT;

	private static final int BTN_WIDTH = 240;
	private static final int BTN_HEIGHT = 80;
	private static final int BTN_OFFSET_Y = 260;
	private static final int BTN_SPLIT_Y = 20;
	private final static int BTN_NUMBER = 3;
	private Rect[] btnRects;

	public GunnerSprite(IBitmapRes bitmapRes, int pX, int pY, int width,
			int height) {
		super(bitmapRes, pX, pY, width, height);
		setVisible(false);
		initRect();
	}

	private void initRect() {
		btnRects = new Rect[BTN_NUMBER];
		for (int i = 0; i < BTN_NUMBER; i++) {
			btnRects[i] = new Rect(
					getX()
							+ (int) ((EngineOptions.PORTPRAIT_SCREEN_WIDTH - BTN_WIDTH) / 2 * EngineOptions
									.getScreenScaleX()),
					getY()
							+ (int) ((BTN_OFFSET_Y + i * BTN_HEIGHT + i
									* BTN_SPLIT_Y) * EngineOptions
										.getScreenScaleY()),
					getX()
							+ (int) (((EngineOptions.PORTPRAIT_SCREEN_WIDTH + BTN_WIDTH) / 2) * EngineOptions
									.getScreenScaleX()), getY()
							+ (int) ((BTN_OFFSET_Y + (i + 1) * (BTN_HEIGHT) + i
									* BTN_SPLIT_Y) * EngineOptions
										.getScreenScaleY()));
		}

	}

	@Override
	public void onDrawSelf(Canvas canvas) {
		canvas.drawRect(EngineOptions.getFullScreenRect(), PaintManager
				.getInstance().getDialogBgPaint());
		drawBtnRect(canvas);
	}

	private void drawBtnRect(Canvas canvas) {
		for (int i = 0; i < BTN_NUMBER; i++) {
			drawBtn(btnRects[i], BTN_NAME[i], canvas);
		}

	}

	private void drawBtn(Rect rect, String text, Canvas canvas) {
		canvas.drawRoundRect(new RectF(rect), 10, 10, PaintManager
				.getInstance().getWhitePaint());

		float offsetX = (rect.width() - PaintManager.getInstance()
				.getTextBlack40Paint().measureText(text)) / 2;
		canvas.drawText(text, rect.left + offsetX, rect.top + 55
				* EngineOptions.getScreenScaleY(), PaintManager.getInstance()
				.getTextBlack40Paint());
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (isVisible()) {
			if (event.getAction() == MotionEvent.ACTION_DOWN
					&& EngineOptions.getFullScreenRect().contains(
							(int) event.getX(), (int) event.getY())) {

				if (btnRects[0]
						.contains((int) event.getX(), (int) event.getY())) {
					((BaseSudokuScene) getParent()).quitGame();
				} else if (btnRects[1].contains((int) event.getX(),
						(int) event.getY())) {
					// TODO 枪手功能，未添加
					((BaseSudokuScene) getParent()).updateUiSuccessGame();
					setVisible(false);
				} else if (btnRects[2].contains((int) event.getX(),
						(int) event.getY())) {
					setVisible(false);
				}
			}
			return true;
		}
		return false;
	}

	private final static String[] BTN_NAME = { "退出", "购买枪手", "回到游戏" };
}
