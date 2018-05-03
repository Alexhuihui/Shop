package servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import entity.ClassifyTwo;
import dao.DbDao;

import java.sql.*;
import java.util.ArrayList;



@SuppressWarnings("unused")
public class ClassifyTwoOperatorServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,java.io.IOException
	{
		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "display":
			display(request, response);
			break;
		case "add":
			add(request, response);
			break;
		case "add_plus":
			addDb(request, response);
		case "delete":
			deleteDb(request, response);
		case "edit":
			edit(request, response);
			break;
		case "edit_plus":
			editDb(request, response);
			break;
		default:
			break;
		}
	}
	
	private void deleteDb(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RequestDispatcher rd;
		DbDao dd = new DbDao("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/shopbase","root","qwerty123");
		ResultSet rs = null;
		
		
		try 
		{
			String classifytwoid = request.getParameter("classifytwoId");
			dd.modify("delete from tb_classifytwo where classifytwoid = ?", classifytwoid);
			ArrayList<ClassifyTwo> classifytwos = new ArrayList<ClassifyTwo>();
			rs = dd.query("select * from tb_classifytwo");
			
			while(rs.next())
			{
				ClassifyTwo classifytwo = new ClassifyTwo();
				classifytwo.setClassifytwoid(rs.getString("classifytwoid"));
				classifytwo.setClassifytwoname(rs.getString("classifytwoname"));
				classifytwo.setClassifyoneid(rs.getString("classifyoneid"));
				classifytwos.add(classifytwo);
			}
			
			//把结果集放入request中
			request.setAttribute("classifytwos", classifytwos);
			// 获取转发对象
			rd = request.getRequestDispatcher("/ClassifyTwoDisplay.jsp");
			// 转发请求
			rd.forward(request,response);
			dd.closeConn();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private void addDb(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RequestDispatcher rd;
		DbDao dd = new DbDao("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/shopbase?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","qwerty123");
		ResultSet rs = null;
		
		
		try 
		{
			String classifyoneid = request.getParameter("classifyoneid");
			String classifytwoname = request.getParameter("classifytwoname");
			dd.insert("insert into tb_classifytwo (classifytwoname, classifyoneid)"
					+ "values(?, ?)", classifytwoname,classifyoneid);

			ArrayList<ClassifyTwo> classifytwos = new ArrayList<ClassifyTwo>();
			rs = dd.query("select * from tb_classifytwo");
			while(rs.next())
			{
				ClassifyTwo classifytwo = new ClassifyTwo();
				classifytwo.setClassifytwoid(rs.getString("classifytwoid"));
				classifytwo.setClassifytwoname(rs.getString("classifytwoname"));
				classifytwo.setClassifyoneid(rs.getString("classifyoneid"));
				classifytwos.add(classifytwo);
			}
			
			//把结果集放入request中
			request.setAttribute("classifytwos", classifytwos);
			// 获取转发对象
			rd = request.getRequestDispatcher("/ClassifyTwoDisplay.jsp");
			// 转发请求
			rd.forward(request,response);
			dd.closeConn();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RequestDispatcher rd;
		try 
		{
			// 获取转发对象
			rd = request.getRequestDispatcher("/ClassifyTwoAdd.jsp");
			// 转发请求
			rd.forward(request,response);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private void editDb(HttpServletRequest request, HttpServletResponse response) throws ServletException,java.io.IOException{
		// TODO Auto-generated method stub
		RequestDispatcher rd;
		DbDao dd = new DbDao("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/shopbase?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","qwerty123");
		ResultSet rs = null;
		try 
		{
			String classifytwoname = request.getParameter("classifytwoname");
			String classifyoneid = request.getParameter("classifyoneid");
			String classifytwoid = request.getParameter("classifytwoid");
			dd.modify("update tb_classifytwo set classifytwoname = ?, classifyoneid = ? where classifytwoid = ?"
					,classifytwoname,classifyoneid, classifytwoid);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		try 
		{
			rs = dd.query("select * from tb_classifytwo");
			ArrayList<ClassifyTwo> classifytwos = new ArrayList<ClassifyTwo>();
			
			while(rs.next())
			{
				ClassifyTwo classifytwo = new ClassifyTwo();
				classifytwo.setClassifytwoid(rs.getString("classifytwoid"));
				classifytwo.setClassifytwoname(rs.getString("classifytwoname"));
				classifytwo.setClassifyoneid(rs.getString("classifyoneid"));
				classifytwos.add(classifytwo);
			}
			
			//把结果集放入request中
			request.setAttribute("classifytwos", classifytwos);
			// 获取转发对象
			rd = request.getRequestDispatcher("/ClassifyTwoDisplay.jsp");
			// 转发请求
			rd.forward(request,response);
			dd.closeConn();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void edit(HttpServletRequest request,HttpServletResponse response) throws ServletException,java.io.IOException{
		// TODO Auto-generated method stub
		RequestDispatcher rd;
		DbDao dd = new DbDao("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/shopbase?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","qwerty123");
		ResultSet rs = null;
		String classifytwoid = request.getParameter("classifytwoId");
		try 
		{
			rs = dd.query("select * from tb_classifytwo where classifytwoid = ?", classifytwoid);
			while(rs.next())
			{
				ClassifyTwo classifytwo = new ClassifyTwo();
				classifytwo.setClassifytwoid(rs.getString("classifytwoid"));
				classifytwo.setClassifytwoname(rs.getString("classifytwoname"));
				classifytwo.setClassifyoneid(rs.getString("classifyoneid"));
				//把结果集放入request中
				request.setAttribute("classifytwo", classifytwo);
			}
			
			// 获取转发对象
			rd = request.getRequestDispatcher("/ClassifyTwoEdit.jsp");
			// 转发请求
			rd.forward(request,response);
			dd.closeConn();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void display(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,java.io.IOException
	{
		RequestDispatcher rd;
		DbDao dd = new DbDao("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/shopbase?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","qwerty123");
		ResultSet rs = null;
		try 
		{
			rs = dd.query("select * from tb_classifytwo");
			ArrayList<ClassifyTwo> classifytwos = new ArrayList<ClassifyTwo>();
			
			while(rs.next())
			{
				ClassifyTwo classifytwo = new ClassifyTwo();
				classifytwo.setClassifytwoid(rs.getString("classifytwoid"));
				classifytwo.setClassifytwoname(rs.getString("classifytwoname"));
				classifytwo.setClassifyoneid(rs.getString("classifyoneid"));
				classifytwos.add(classifytwo);
			}
			
			//把结果集放入request中
			request.setAttribute("classifytwos", classifytwos);
			// 获取转发对象
			rd = request.getRequestDispatcher("/ClassifyTwoDisplay.jsp");
			// 转发请求
			rd.forward(request,response);
			dd.closeConn();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}




















