package com.olympic.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Olympic", urlPatterns = { "/olympic/*" })
public class OlympicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, OlympicController> controllerMap = new HashMap<>();
    public OlympicServlet() {
        super();
        controllerMap.put("/olympic/rank", new RankController());
        controllerMap.put("/olympic/inter-detail", new InterController());
    }
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
    	String requestURI = req.getRequestURI();
    	System.out.println(requestURI);
    	OlympicController controller = controllerMap.get(requestURI);
    	if (controller == null) {
    		res.setStatus(HttpServletResponse.SC_NOT_FOUND);
    		return;
    	}
    	controller.process(req, res);    	
	}

}
