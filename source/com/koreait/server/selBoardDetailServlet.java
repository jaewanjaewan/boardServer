package com.koreait.server;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sel")
public class selBoardDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String pIboard = req.getParameter("iboard");
        int pIboard2 = Integer.parseInt(pIboard);
        BoardVO vo = new BoardVO();
        vo.setIboard(pIboard2);
        BoardDAO.selBoard(vo);
        Gson gson = new Gson();
        String json = gson.toJson(vo);
        res.setContentType("text/plain;charset=UTF-8");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        out.print(json);
    }
}
