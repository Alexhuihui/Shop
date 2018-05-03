package servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import entity.ClassifyOne;
import dao.DbDao;

import javax.servlet.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;



@SuppressWarnings("unused")
public class ClassifyOneOperatorServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

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
			String classifyoneid = request.getParameter("classifyoneid");
			dd.modify("delete from tb_classifyone where classifyoneid = ?", classifyoneid);
			ArrayList<ClassifyOne> classifyones = new ArrayList<ClassifyOne>();
			rs = dd.query("select * from tb_classifyone");
			
			while(rs.next())
			{
				ClassifyOne classifyone = new ClassifyOne();
				classifyone.setClassifyoneid(rs.getString("classifyoneid"));
				classifyone.setClassifyonename(rs.getString("classifyonename"));
				classifyones.add(classifyone);
			}
			
			//把结果集放入request中
			request.setAttribute("classifyones", classifyones);
			// 获取转发对象
			rd = request.getRequestDispatcher("/ClassifyOneDisplay.jsp");
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
			String classifyonename = request.getParameter("classifyonename");
			dd.insert("insert into tb_classifyone (classifyonename)"
					+ "values(?)", classifyonename);

			ArrayList<ClassifyOne> classifyones = new ArrayList<ClassifyOne>();
			rs = dd.query("select * from tb_classifyone");
			while(rs.next())
			{
				ClassifyOne classifyone = new ClassifyOne();
				classifyone.setClassifyoneid(rs.getString("classifyoneid"));
				classifyone.setClassifyonename(rs.getString("classifyonename"));
				classifyones.add(classifyone);
			}
			
			//把结果集放入request中
			request.setAttribute("classifyones", classifyones);
			// 获取转发对象
			rd = request.getRequestDispatcher("/ClassifyOneDisplay.jsp");
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
			rd = request.getRequestDispatcher("/ClassifyOneAdd.jsp");
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
			String classifyoneid = request.getParameter("classifyoneid");
			String classifyonename = request.getParameter("classifyonename");
			dd.modify("update tb_classifyone set classifyonename = ? where classifyoneid = ?"
					,classifyonename, classifyoneid);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		try 
		{
			rs = dd.query("select * from tb_classifyone");
			ArrayList<ClassifyOne> classifyones = new ArrayList<ClassifyOne>();
			
			while(rs.next())
			{
				ClassifyOne classifyone = new ClassifyOne();
				classifyone.setClassifyoneid(rs.getString("classifyoneid"));
				classifyone.setClassifyonename(rs.getString("classifyonename"));
				classifyones.add(classifyone);
			}
			
			//把结果集放入request中
			request.setAttribute("classifyones", classifyones);
			// 获取转发对象
			rd = request.getRequestDispatcher("/ClassifyOneDisplay.jsp");
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
		String classifyoneid = request.getParameter("classifyoneid");
		try 
		{
			rs = dd.query("select * from tb_classifyone where classifyoneid = ?", classifyoneid);
			while(rs.next())
			{
				ClassifyOne classifyone = new ClassifyOne();
				classifyone.setClassifyoneid(rs.getString("classifyoneid"));
				classifyone.setClassifyonename(rs.getString("classifyonename"));
				//把结果集放入request中
				request.setAttribute("classifyone", classifyone);
			}
			
			// 获取转发对象
			rd = request.getRequestDispatcher("/ClassifyOneEdit.jsp");
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
			rs = dd.query("select * from tb_classifyone");
			ArrayList<ClassifyOne> classifyones = new ArrayList<ClassifyOne>();
			
			while(rs.next())
			{
				ClassifyOne classifyone = new ClassifyOne();
				classifyone.setClassifyoneid(rs.getString("classifyoneid"));
				classifyone.setClassifyonename(rs.getString("classifyonename"));
				classifyones.add(classifyone);
			}
			
			//把结果集放入request中
			request.setAttribute("classifyones", classifyones);
			// 获取转发对象
			rd = request.getRequestDispatcher("/ClassifyOneDisplay.jsp");
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




















