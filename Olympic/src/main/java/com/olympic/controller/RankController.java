package com.olympic.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.olympic.model.International;
import com.olympic.service.OlympicService;
import com.olympic.service.OlympicServiceImpl;

public class RankController implements OlympicController {
	OlympicService os = new OlympicServiceImpl();
	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		try {
			switch (action != null ? action : "NULL") {
				case "addInter":
					os.addInter(req);
					res.sendRedirect(req.getRequestURI());
					return;
				case "deleteInter":
					os.deleteInter(req);
					res.sendRedirect(req.getRequestURI());
					return;
				case "modifyInter":
					os.modifyInter(req);
					res.sendRedirect(req.getRequestURI());
					return;
				case "NULL":
				default:
					System.out.println("올림픽 메달 순위");
					List<International> rankList = os.getRank();
					System.out.println(rankList);
					req.setAttribute("rankList", rankList);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", null);
		}
		
		
		String view = "/WEB-INF/views/InterRank.jsp";
		req.getRequestDispatcher(view).forward(req, res);
	}

}
