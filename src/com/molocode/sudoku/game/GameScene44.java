package com.molocode.sudoku.game;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.sax.StartElementListener;
import android.util.Log;

import com.molocode.sudoku.Journey.LifeJourney;
import com.molocode.sudoku.Journey.degree.Degree;
import com.molocode.sudoku.Journey.degree.DegreeManager;
import com.molocode.sudoku.Journey.examination.ExamScore;
import com.molocode.sudoku.Journey.examination.Examination;
import com.molocode.sudoku.Journey.school.ProgressManager;
import com.molocode.sudoku.Journey.school.SchoolInfo;
import com.molocode.sudoku.Journey.school.SchoolManager;
import com.molocode.sudoku.domain.PlayerInfo;
import com.molocode.sudoku.game.domain.BaseBoard;
import com.molocode.sudoku.game.domain.Map;
import com.molocode.sudoku.game.sprite.ChessControlPanelSprite;
import com.molocode.sudoku.game.sprite.Chessboard44Sprite;
import com.molocode.sudoku.game.sprite.CountdownSprite;
import com.molocode.sudoku.game.sprite.ExamFailSprite;
import com.molocode.sudoku.game.sprite.ExamSuccessSprite;
import com.molocode.sudoku.game.sprite.GunnerBtnSprite;
import com.molocode.sudoku.game.sprite.GunnerSprite;
import com.molocode.sudoku.yard.activity.SchoolTreeActivity;

public class GameScene44 extends BaseSudokuScene {
	private GameActivity activity;
	private Examination examination;
	private int degreeId;
	private int schoolprogress;
	private int schoolLevel;

	public GameScene44(Activity activity) {
		super(activity);
		this.activity = (GameActivity) activity;
		this.schoolLevel = DegreeManager.getDegree(
				LifeJourney.getInstance().getDegreeId()).getSchoolInfo().schoolLevel;
		Log.e("com.poxiao.suduko", "this.schoolLevel=" + this.schoolLevel);
		this.examination = getExamination();
		((GameActivity) activity).showExamInfo(examination);
	}

	private Chessboard44Sprite chessboard44Sprite;
	private ChessControlPanelSprite chessControlPanelSprite;
	private GunnerBtnSprite settingBtnSprite;
	private GunnerSprite settingSprite;
	private ExamSuccessSprite successSprite;
	private ExamFailSprite failSprite;
	private CountdownSprite countdownSprite;

	private void initSprite() {
		chessboard44Sprite = new Chessboard44Sprite(null, Chessboard44Sprite.X,
				Chessboard44Sprite.Y, Chessboard44Sprite.WIDTH,
				Chessboard44Sprite.HEIGHT);
		chessboard44Sprite.initCells(BaseBoard.getCellMap(examination
				.getQuestions()));
		attachChild(chessboard44Sprite);

		countdownSprite = new CountdownSprite(null, CountdownSprite.X,
				CountdownSprite.Y, CountdownSprite.WIDTH,
				CountdownSprite.HEIGHT, examination.getPassLevel().pass);
		attachChild(countdownSprite);

		chessControlPanelSprite = new ChessControlPanelSprite(null,
				ChessControlPanelSprite.X, ChessControlPanelSprite.Y,
				ChessControlPanelSprite.WIDTH, ChessControlPanelSprite.HEIGHT,
				true);
		attachChild(chessControlPanelSprite);

		settingBtnSprite = new GunnerBtnSprite(null, GunnerBtnSprite.X,
				GunnerBtnSprite.Y, GunnerBtnSprite.WIDTH,
				GunnerBtnSprite.HEIGHT);
		attachChild(settingBtnSprite);

		successSprite = new ExamSuccessSprite(null, ExamSuccessSprite.X,
				ExamSuccessSprite.Y, ExamSuccessSprite.WIDTH,
				ExamSuccessSprite.HEIGHT);
		attachChild(successSprite);
		failSprite = new ExamFailSprite(null, ExamFailSprite.X,
				ExamFailSprite.Y, ExamFailSprite.WIDTH, ExamFailSprite.HEIGHT);
		attachChild(failSprite);
		settingSprite = new GunnerSprite(null, GunnerSprite.X, GunnerSprite.Y,
				GunnerSprite.WIDTH, GunnerSprite.HEIGHT);
		attachChild(settingSprite);

		initTouch();
	}

	private void initTouch() {
		registerTouch(successSprite);
		registerTouch(settingSprite);
		registerTouch(chessboard44Sprite);
		registerTouch(chessControlPanelSprite);
		registerTouch(settingBtnSprite);
		registerTouch(failSprite);
	}

	@Override
	public void onUnloadResources() {
		// TODO 需要手动释放的资源
	}

	@Override
	public void updateUiNumberChangeRequest(int number) {
		chessboard44Sprite.numberChangeRequest(number);
	}

	@Override
	public void updateUiSuccessGame() {
		// 停止计时器
		countdownSprite.stopCountdown();
		Log.i("MOLO_DEBUG", "success game on scene44");
		if (ProgressManager.getInstance().getEntranceExams()) {
			int score=ExamScore.getInstance().getScorebyTime(
							CountdownSprite.getPassTime(),
							examination);
			ExamScore.getInstance().saveExamScore(score);
			activity.startActivity(new Intent(activity,
					SchoolTreeActivity.class));
		}
		// 添加成功记录
		PlayerInfo info = PlayerInfo.getPlayerInfo(activity);
		int levelsCompleted = info.getLevelsCompleted();
		Log.i("com.poxiao.suduko", "levelsCompleted=" + levelsCompleted);
		info.setLevelsCompleted(levelsCompleted + 1);
		PlayerInfo.setPlayerInfo(activity, info);
		// 获取新的progress
		setSchoolProgrerss();
		schoolprogress++;
		if (ProgressManager.getInstance().studyProgress(degreeId,
				schoolprogress)) {
			ProgressManager.getInstance().setEntranceExams(true);
			Log.e("com.poxiao.suduko", "历尽多年磨练，你已今非昔比，参加升学考试吧");
			activity.startActivity(new Intent(activity,
					SchoolTreeActivity.class));
		} else {
			successSprite.setVisible(true);
		}
		Log.i("com.poxiao.suduko", " GameScene44 degreeId=" + degreeId
				+ ";progress" + schoolprogress);
	}

	@Override
	public void updateUiShowSetting() {
		settingSprite.setVisible(true);
	}

	@Override
	public void reStartGame() {
		chessboard44Sprite.initCells(BaseBoard.getCellMap(examination
				.getQuestions()));
		countdownSprite.cleanCountTime();
	}

	@Override
	public void onLoadResources(Resources res, AssetManager assertManager) {
		initSprite();
	}

	@Override
	protected void onUpdateSelf(float secondsElapsed) {
		checkTimeOut();
	}

	/**
	 * 下一局
	 */
	@Override
	public void next() {
		// level++;
		reStartGame();
	}

	// 获取本次考试的信息
	private Examination getExamination() {
		degreeId = LifeJourney.getInstance().getDegreeId();
		setSchoolProgrerss();
		List<Examination> exams = null;
		if (ProgressManager.getInstance().getEntranceExams()) {
			exams = Examination.getEnterDegreeExaninationList(degreeId);
		} else {
			exams = Examination.getExaminationList(degreeId);
		}
		if (null == exams) {
			Log.e("com.poxiao.suduko", "GameScene44 exams is null");
		}
		return exams.get(schoolprogress);
	}

	private void setSchoolProgrerss() {
		for (int i = 0; i < Degree.getSchoolSequence().length; i++) {
			SchoolInfo info = Degree.getSchoolSequence()[i];
			if (degreeId == info.degreeId && schoolLevel == info.schoolLevel) {
				schoolprogress = SchoolManager.getSchool(info).getProgress();
			}
		}
	}

	// 判断时间是否超时
	private void checkTimeOut() {
		float time = CountdownSprite.getPassTime();
		if (time == 0) {
			failSprite.setVisible(true);
			countdownSprite.stopCountdown();
		}
	}

	private void showUpDialog() {
		activity.runOnUiThread(new Runnable() {
			public void run() {
				// 弹出升学考试
				AlertDialog.Builder builder = new Builder(activity);
				builder.setMessage("经过书山题海的磨练，你已今非昔比，是否参加初中升学考试");
				builder.setTitle("升学考试");
				builder.setPositiveButton("一举成名", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						next();
					}
				});
				builder.setNegativeButton("外出打工", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						quitGame();
					}
				});
				builder.create().show();

			}
		});
	}
}
