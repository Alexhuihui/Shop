package servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import entity.User;
import dao.DbDao;

import javax.servlet.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;



@SuppressWarnings("unused")
public class UserOperatorServlet extends HttpServlet
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
			String id = request.getParameter("userId");
			long userid = Long.valueOf(id);
			dd.modify("delete from tb_user where userid = ?", userid);
			ArrayList<User> Users = new ArrayList<User>();
			rs = dd.query("select * from tb_user where roleid != 2");
			
			while(rs.next())
			{
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setCreatetime(rs.getString("createtime"));
				user.setTelnum(rs.getString("telnum"));
				user.setPasswd(rs.getString("passwd"));
				user.setUsername(rs.getString("username"));
				user.setGenderid(rs.getInt("genderid"));
				user.setAddress(rs.getString("address"));
				user.setRoleid(rs.getInt("roleid"));
				user.setRemark(rs.getString("remark"));
				Users.add(user);
			}
			
			//把结果集放入request中
			request.setAttribute("users", Users);
			// 获取转发对象
			rd = request.getRequestDispatcher("/UserDisplay.jsp");
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
			String userid = request.getParameter("userid");
			String username = request.getParameter("username");
			String telnum = request.getParameter("telnum");
			String passwd = request.getParameter("passwd");
			String address = request.getParameter("address");
			Integer roleid = 1;
			String genderid  = request.getParameter("genderid");
			long time = System.currentTimeMillis();
			String createtime = String.valueOf(time);
			dd.insert("insert into tb_user (createtime, telnum, passwd, username, genderid, address, roleid)"
					+ "values(?, ?, ?, ?, ?, ?, ?)", createtime, telnum, passwd, username, genderid, address, roleid);

			ArrayList<User> Users = new ArrayList<User>();
			rs = dd.query("select * from tb_user where roleid != 2");
			while(rs.next())
			{
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setCreatetime(rs.getString("createtime"));
				user.setTelnum(rs.getString("telnum"));
				user.setPasswd(rs.getString("passwd"));
				user.setUsername(rs.getString("username"));
				user.setGenderid(rs.getInt("genderid"));
				user.setAddress(rs.getString("address"));
				user.setRoleid(rs.getInt("roleid"));
				user.setRemark(rs.getString("remark"));
				Users.add(user);
			}
			
			//把结果集放入request中
			request.setAttribute("users", Users);
			// 获取转发对象
			rd = request.getRequestDispatcher("/UserDisplay.jsp");
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
			rd = request.getRequestDispatcher("/UserAdd.jsp");
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
			String userid = request.getParameter("userid");
			String username = request.getParameter("username");
			String telnum = request.getParameter("telnum");
			String passwd = request.getParameter("passwd");
			String address = request.getParameter("address");
			dd.modify("update tb_user set username = ?, telnum = ?, passwd = ?, address = ? where userid = ?"
					,username, telnum, passwd, address, userid);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		try 
		{
			rs = dd.query("select * from tb_user where roleid != 2");
			ArrayList<User> Users = new ArrayList<User>();
			
			while(rs.next())
			{
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setCreatetime(rs.getString("createtime"));
				user.setTelnum(rs.getString("telnum"));
				user.setPasswd(rs.getString("passwd"));
				user.setUsername(rs.getString("username"));
				user.setGenderid(rs.getInt("genderid"));
				user.setAddress(rs.getString("address"));
				user.setRoleid(rs.getInt("roleid"));
				user.setRemark(rs.getString("remark"));
				Users.add(user);
			}
			
			//把结果集放入request中
			request.setAttribute("users", Users);
			// 获取转发对象
			rd = request.getRequestDispatcher("/UserDisplay.jsp");
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
		String userid = request.getParameter("userId");
		try 
		{
			rs = dd.query("select * from tb_user where userid = ?", userid);
			while(rs.next())
			{
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setCreatetime(rs.getString("createtime"));
				user.setTelnum(rs.getString("telnum"));
				user.setPasswd(rs.getString("passwd"));
				user.setUsername(rs.getString("username"));
				user.setGenderid(rs.getInt("genderid"));
				user.setAddress(rs.getString("address"));
				user.setRoleid(rs.getInt("roleid"));
				user.setRemark(rs.getString("remark"));
				//把结果集放入request中
				request.setAttribute("users", user);
			}
			
			// 获取转发对象
			rd = request.getRequestDispatcher("/UserEdit.jsp");
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
			rs = dd.query("select * from tb_user where roleid != 2");
			ArrayList<User> Users = new ArrayList<User>();
			
			while(rs.next())
			{
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setCreatetime(rs.getString("createtime"));
				user.setTelnum(rs.getString("telnum"));
				user.setPasswd(rs.getString("passwd"));
				user.setUsername(rs.getString("username"));
				user.setGenderid(rs.getInt("genderid"));
				user.setAddress(rs.getString("address"));
				user.setRoleid(rs.getInt("roleid"));
				user.setRemark(rs.getString("remark"));
				Users.add(user);
			}
			
			//把结果集放入request中
			request.setAttribute("users", Users);
			// 获取转发对象
			rd = request.getRequestDispatcher("/UserDisplay.jsp");
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




















