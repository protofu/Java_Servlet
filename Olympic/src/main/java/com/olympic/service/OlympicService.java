package com.olympic.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.olympic.model.International;

public interface OlympicService {
	// 국가 추가
	void addInter(HttpServletRequest req) throws Exception;
	// 국가 삭제
	void deleteInter(HttpServletRequest req) throws Exception;
	// 메달 수정
	void modifyInter(HttpServletRequest req) throws Exception;
	// 국가 매달 합계 계산?
	int sumMedal(HttpServletRequest req) throws Exception;
	// 국가 순위별 정렬
	List<International> getRank() throws Exception;
	// 국가 디테일
	International getInter(HttpServletRequest req) throws Exception;
}
