package com.olympic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.olympic.service.OlympicService;
import com.olympic.service.OlympicServiceImpl;

public class RankController implements OlympicController {
	OlympicService os = new OlympicServiceImpl();
	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		System.out.println(action + "?????");
		try {
			switch (action != null ? action : "NULL") {
				case "addInter":
					System.out.println(req.getParameter("name"));
					os.addInter(req);
					break;
				default:
					
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String view = "/WEB-INF/views/InterRank.jsp";
		req.getRequestDispatcher(view).forward(req, res);
	}

}
