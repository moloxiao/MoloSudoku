package com.molocode.sudoku.game.res;

import java.util.HashMap;

import android.content.res.Resources;
import android.graphics.Bitmap;

import com.hifreshday.android.pge.engine.Engine;
import com.hifreshday.android.pge.view.res.GameBitmapUtil;
import com.hifreshday.android.pge.view.res.IBitmapRes;

public class GameRes implements IBitmapRes {
	
	private static Resources res;
    
    private HashMap<Integer, Integer> resMap = new HashMap<Integer,Integer>();
    private HashMap<Integer, Bitmap> resBitmapMap = new HashMap<Integer, Bitmap>();


    public GameRes(Resources res) {
    		Engine.isRecycle = false;
        GameRes.res = res;
        initRes();
    }
    
	private void initRes() {
		// TODO 初始化资源文件
		
	}

	@Override
	public Bitmap getBitmap(int key) {
		Bitmap bmp = resBitmapMap.get(key);
		if(bmp == null) {
			bmp = getBitmap(res, resMap.get(key));
			if(bmp!=null) {
				resBitmapMap.put(key, bmp);
			}
		}
		
		return bmp;
	}
	
	private static Bitmap getBitmap(Resources res, int resId) {
		return GameBitmapUtil.loadBitmap(res, resId);
	}

	@Override
	public Bitmap getDefalutBitmap() {
		return null;
	}

	@Override
	public String getResName() {
		return null;
	}

	@Override
	public void recycle() {
		Engine.isRecycle = true;
		if(resBitmapMap != null && resBitmapMap.size()>0) {
			for(Bitmap bmp : resBitmapMap.values()) {
				GameBitmapUtil.recycleBitmap(bmp);
			}
		}
	}

}
