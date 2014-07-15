package com.molocode.sudoku.Journey.school;

import com.molocode.sudoku.Journey.degree.Degree;
import com.molocode.sudoku.Journey.school.allSchool.MiddleSchoolA;
import com.molocode.sudoku.Journey.school.allSchool.MiddleSchoolB;
import com.molocode.sudoku.Journey.school.allSchool.MiddleSchoolC;
import com.molocode.sudoku.Journey.school.allSchool.PrimarySchoolA;
import com.molocode.sudoku.Journey.school.allSchool.PrimarySchoolB;
import com.molocode.sudoku.Journey.school.allSchool.PrimarySchoolC;

public class SchoolManager {

	public static School getSchool(SchoolInfo schoolInfo) {
		// TODO : 等待实现-more than high 
		if (schoolInfo.degreeId == Degree.PRIMARY){
			if(schoolInfo.schoolLevel == School.LEVELA) {
				return new PrimarySchoolA();
			}else if(schoolInfo.schoolLevel == School.LEVELB) {
				return new PrimarySchoolB();
			}else if(schoolInfo.schoolLevel == School.LEVELC) {
				return new PrimarySchoolC();
			}
		}else if (schoolInfo.degreeId  == Degree.MIDDLE){
			if(schoolInfo.schoolLevel == School.LEVELA) {
				return new MiddleSchoolA();
			}else if(schoolInfo.schoolLevel == School.LEVELB) {
				return new MiddleSchoolB();
			}else if(schoolInfo.schoolLevel == School.LEVELC) {
				return new MiddleSchoolC();
			}
		}
		
		return null;
	}
}
