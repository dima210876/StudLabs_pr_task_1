package my.studlabs.project.controller;

import my.studlabs.project.service.DataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(
        urlPatterns = "/numbers",
        name = "MainServlet",
        displayName = "MainServlet",
        description = "Servlet for practical task #1",
        loadOnStartup = 1
)
public class MainServlet extends HttpServlet
{
    private static final DataService dataService = new DataService();

    @Override
    public void init() throws ServletException
    {
        System.out.println("Исходные данные: " + dataService.getList(false));
        System.out.println("Отсортированные данные: " + dataService.getList(true));
    }

    @Override
    public void destroy() { }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setAttribute("numbers", dataService.getList(false).toArray());
        this.getServletContext().getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setAttribute("numbers", dataService.getList(true).toArray());
        this.getServletContext().getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }
}
