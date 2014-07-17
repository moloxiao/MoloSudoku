package com.molocode.sudoku.game;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;
import com.molocode.sudoku.Journey.LifeJourney;
import com.molocode.sudoku.Journey.degree.Degree;
import com.molocode.sudoku.Journey.degree.DegreeManager;
import com.molocode.sudoku.Journey.examination.Examination;
import com.molocode.sudoku.Journey.school.School;
import com.molocode.sudoku.Journey.school.SchoolInfo;
import com.molocode.sudoku.Journey.school.SchoolManager;
import com.molocode.sudoku.domain.PlayerInfo;
import com.molocode.sudoku.game.domain.BaseBoard;
import com.molocode.sudoku.game.sprite.ChessControlPanelSprite;
import com.molocode.sudoku.game.sprite.Chessboard44Sprite;
import com.molocode.sudoku.game.sprite.CountdownSprite;
import com.molocode.sudoku.game.sprite.ExamFailSprite;
import com.molocode.sudoku.game.sprite.ExamSuccessSprite;
import com.molocode.sudoku.game.sprite.GunnerBtnSprite;
import com.molocode.sudoku.game.sprite.GunnerSprite;

public class GameScene44 extends BaseSudokuScene {
	private GameActivity activity;
	private Examination examination;
	private int degreeId;
	private int schoolprogress;
	private int schoolLevel;
	List<Examination> exams;// 日常考试列表
	List<Examination> enterExams;// 升学考试列表
	private boolean isEnterExam = false;// 是否处于升学考状态

	public GameScene44(Activity activity) {
		super(activity);
		this.activity = (GameActivity) activity;
		this.schoolLevel = DegreeManager.getDegree(
				LifeJourney.getInstance().getDegreeId()).getSchoolInfo().schoolLevel;
		setSchoolProgrerss();// 设置当前progress
		setExaminationList();// 设置所有的考试
		Log.e("com.poxiao.suduko", "this.schoolLevel=" + this.schoolLevel);
		this.examination = getExamination(schoolprogress);
		showExamInfo(this.examination);
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
		registerTouch(failSprite);
		registerTouch(settingSprite);
		registerTouch(chessboard44Sprite);
		registerTouch(chessControlPanelSprite);
		registerTouch(settingBtnSprite);
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
		Log.i("MOLO_DEBUG", "success game on scene44");
		// 停止计时器
		countdownSprite.stopCountdown();
		// 获取最新新的progress
		setSchoolProgrerss();
		if ((exams.size() - 1) == schoolprogress) {
			Log.i("com.poxiao.suduko", "获得升学考试");
			showUpDialog();
		} else if (exams.size() == schoolprogress) {
			Log.i("com.poxiao.suduko", "通过升学考试");
			// 保存当前毕业的学校
			School school = SchoolManager.getSchool(DegreeManager.getDegree(
					degreeId).getSchoolInfo());
			school.setGraduateHere(true);
			showSelectDialog();
		} else {
			// 显示过关界面
			Log.i("com.poxiao.suduko", "updateUiSuccessGame schoolprogress="
					+ schoolprogress);
			successSprite.showScoreLevel();
			successSprite.setVisible(true);
		}
		schoolprogress++;
		// 保存新的progress
		saveSchoolProgrerss(schoolprogress);
		Log.i("com.poxiao.suduko", " GameScene44 degreeId=" + degreeId
				+ ";progress" + schoolprogress);
		// 添加成功记录
		PlayerInfo info = PlayerInfo.getPlayerInfo(activity);
		int levelsCompleted = info.getLevelsCompleted();
		Log.i("com.poxiao.suduko", "levelsCompleted=" + levelsCompleted);
		info.setLevelsCompleted(levelsCompleted + 1);
		PlayerInfo.setPlayerInfo(activity, info);
	}

	@Override
	public void updateUiShowSetting() {
		settingSprite.setVisible(true);
	}

	@Override
	public void reStartGame() {
		this.examination = getExamination(schoolprogress);
		// 展示当前考试的准考信息
		showExamInfo(this.examination);
		chessboard44Sprite.initCells(BaseBoard.getCellMap(examination
				.getQuestions()));
		countdownSprite.cleanCountTime();
		countdownSprite.startCountdown();
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
		reStartGame();
	}

	/**
	 * 获取成绩等级
	 * 
	 * @return
	 */
	public int getScoreLevel() {
		float time = CountdownSprite.getPassTime();
		if (examination.getPassLevel().perfect
				- examination.getPassLevel().perfect < time) {
			return 0;// perfect
		} else if (examination.getPassLevel().perfect
				- examination.getPassLevel().good < time) {
			return 1;// good
		} else {
			return 2;// pass
		}
	}

	/**
	 * 判断时间是否失败
	 */
	private void checkTimeOut() {
		float time = CountdownSprite.getPassTime();
		if (time == 0) {
			countdownSprite.stopCountdown();
			if (isEnterExam) {
				Log.i("com.pxiao.suduko", "升学考失败");
			}
			failSprite.setVisible(true);
		}
	}

	/**
	 * 获取所有考试的信息
	 * 
	 */
	private void setExaminationList() {
		degreeId = LifeJourney.getInstance().getDegreeId();
		this.exams = Examination.getExaminationList(degreeId);// 日常考试类表
		this.enterExams = Examination
				.getEnterDegreeExaninationList(degreeId + 1);// 升学考试列表
	}

	/**
	 * 获取当前考试信息
	 * 
	 * @param progress
	 * @return
	 */
	private Examination getExamination(int progress) {
		if (null != exams && null != enterExams) {
			if (isEnterExam) {
				Log.i("com.pxiao.suduko", "升学考试题"
						+ enterExams.get(0).getExaminationName());
				return enterExams.get(0);
			} else {
				Log.i("com.pxiao.suduko", "日常考试题");
				return exams.get(progress);
			}
		}
		return null;
	}

	/**
	 * 设置学习进度
	 */
	private void setSchoolProgrerss() {
		for (int i = 0; i < Degree.getSchoolSequence().length; i++) {
			SchoolInfo info = Degree.getSchoolSequence()[i];
			if (degreeId == info.degreeId && schoolLevel == info.schoolLevel) {
				schoolprogress = SchoolManager.getSchool(info).getProgress();
			}
		}
	}

	/**
	 * 保存学习进度
	 * 
	 * @param progress
	 */

	private void saveSchoolProgrerss(int progress) {
		for (int i = 0; i < Degree.getSchoolSequence().length; i++) {
			SchoolInfo info = Degree.getSchoolSequence()[i];
			if (degreeId == info.degreeId && schoolLevel == info.schoolLevel) {
				School school = SchoolManager.getSchool(info);
				school.setProgress(progress);
			}
		}
	}

	private void showExamInfo(Examination examination) {
		String name = examination.getExaminationName();
		String number = examination.getExaminationNumber();
		String location = examination.getExaminationLocation();
		int passtime = examination.getPassLevel().pass;
		// TODO 界面展示
		Log.e("com.poxiao.suduko", "name=" + name + ";number=" + number
				+ ";location=" + location + "passtime=" + passtime);
	}

	/**
	 * 升学提示框
	 */
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
						isEnterExam = true;
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

	/**
	 * 选校选着界面
	 */
	private void showSelectDialog() {
		activity.runOnUiThread(new Runnable() {
			public void run() {
				// 弹出升学考试
				AlertDialog.Builder builder = new Builder(activity);
				builder.setMessage("恭喜你通过了升学考");
				builder.setTitle("学校选择");
				builder.setPositiveButton("重点初中", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						// 设置degreeId
						LifeJourney.getInstance().setDegreeId(degreeId + 1);
						// 清除 progress
						saveSchoolProgrerss(0);
					}
				});
				builder.setNegativeButton("贵族初中", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						// TODO　计费点
					}
				});
				builder.create().show();
			}
		});
	}
}
