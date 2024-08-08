package com.olympic.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.olympic.dao.OlympicDAO;
import com.olympic.dao.OlympicDAOImpl;
import com.olympic.model.International;

public class OlympicServiceImpl implements OlympicService{
	OlympicDAO od = new OlympicDAOImpl();
	@Override
	public void addInter(HttpServletRequest req) throws Exception {
		String name = req.getParameter("name");
		String content = req.getParameter("content");
		
		// 이미지 가져오기
		Part part = req.getPart("flag");
		String header = part.getHeader("content-disposition");
		int start = header.indexOf("filename=");
		String flag = header.substring(start+10, header.length()-1);
		
		// 이미지 저장
		if (flag != null && !flag.isEmpty()) {
			part.write(flag);
		}
		
		International in = new International(name, flag, content);
		od.addInter(in);
	}

	@Override
	public void deleteInter(HttpServletRequest req) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		od.deleteInter(id);
	}

	@Override
	public void modifyInter(HttpServletRequest req) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		International inter = od.getInter(id);
		System.out.println("서비스" + inter);
		String name = req.getParameter("name");
		String content = req.getParameter("content");
		int gold = Integer.parseInt(req.getParameter("gold"));
		int silver = Integer.parseInt(req.getParameter("silver"));
		int bronze = Integer.parseInt(req.getParameter("bronze"));
		
		System.out.println(name+"?"+content+"?"+gold+"?"+silver+"?"+bronze+"?");
		inter.setName(name);
		inter.setContent(content);
		inter.setGold(gold);
		inter.setSilver(silver);
		inter.setBronze(bronze);
		
		// 이미지 가져오기
		Part part = req.getPart("flag");
		String header = part.getHeader("content-disposition");
		int start = header.indexOf("filename=");
		String flag = header.substring(start+10, header.length()-1);
		
		// 이미지 저장
		if (flag != null && !flag.isEmpty()) {
			part.write(flag);
			inter.setFlag(flag);
		}
		// DAO가 DB에 삽입.
		od.modifyInter(inter);
	}

	@Override
	public int sumMedal(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<International> getRank() throws Exception {
		return od.getRank();
	}

	@Override
	public International getInter(HttpServletRequest req) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		return od.getInter(id);
	}

}
