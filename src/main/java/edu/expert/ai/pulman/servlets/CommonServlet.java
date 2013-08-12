package edu.expert.ai.pulman.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class CommonServlet extends HttpServlet
{
    private static final long serialVersionUID = -5197334696243663375L;

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }
    
    @Override
    public void destroy()
    {
        super.destroy();
    }
}
