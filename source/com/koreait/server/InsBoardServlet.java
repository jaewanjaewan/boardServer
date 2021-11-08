package com.koreait.server;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ins")
public class InsBoardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String json = Utils.getJson(req);
        Gson gson = new Gson();
        BoardVO vo = gson.fromJson(json, BoardVO.class);
        System.out.println(vo.getTitle());
        System.out.println(vo.getCtnt());
        System.out.println(vo.getWriter());

        BoardDAO.insBoard(vo);
    }
}
