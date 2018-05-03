package servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import dao.DbDao;

import javax.servlet.annotation.*;

import java.sql.*;

import java.io.PrintWriter;
import java.io.IOException;

@SuppressWarnings({ "serial", "unused" })
public class LoginServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException,java.io.IOException
	{
		String errMsg = "";
		RequestDispatcher rd;
		String telnum = request.getParameter("telnum");
		String passwd = request.getParameter("passwd");
		try
		{
			DbDao dd = new DbDao("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/shopbase","root","qwerty123");
			// 查询结果集
			ResultSet rs = dd.query("select passwd from tb_user where userid = 1");
			if (rs.next())
			{
				// 用户名和密码匹配
				if (rs.getString("passwd").equals(passwd))
				{
					// 获取session对象
					HttpSession session = request.getSession(true);
					// 设置session属性，跟踪用户会话状态
					session.setAttribute("telnum" , telnum);
					// 获取转发对象
					rd = request.getRequestDispatcher("/Welcome.jsp");
					// 转发请求
					rd.forward(request,response);
				}
				else
				{
					// 用户名和密码不匹配时
					errMsg += "您的用户名密码不符合,请重新输入";
				}
			}
			else
			{
				// 用户名不存在时
				errMsg += "您的用户名不存在,请先注册";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// 如果出错，转发到重新登录
		if (errMsg != null && !errMsg.equals(""))
		{
			rd = request.getRequestDispatcher("/login.jsp");
			request.setAttribute("err" , errMsg);
			rd.forward(request,response);
		}
	}
}
