package servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import entity.Goods;
import dao.DbDao;

import javax.servlet.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;



@SuppressWarnings("unused")
public class GoodsOperatorServlet extends HttpServlet
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
			String id = request.getParameter("goodsId");
			long goodsid = Long.valueOf(id);
			dd.modify("delete from tb_goods where goodsid = ?", goodsid);
			ArrayList<Goods> goodss = new ArrayList<Goods>();
			rs = dd.query("select * from tb_goods");
			
			while(rs.next())
			{
				Goods goods = new Goods();
				goods.setClassifyoneid(rs.getString("classifyoneid"));
				goods.setClassifytwoid(rs.getString("classifytwoid"));
				goods.setGoodsid(rs.getString("goodsid"));
				goods.setGoodsimage(rs.getString("goodsimage"));
				goods.setGoodsname(rs.getString("goodsname"));
				goods.setGoodsprice(rs.getString("goodsprice"));
				goodss.add(goods);
			}
			
			//把结果集放入request中
			request.setAttribute("goodss", goodss);
			// 获取转发对象
			rd = request.getRequestDispatcher("/GoodsDisplay.jsp");
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
			String goodsid = request.getParameter("goodsid");
			String goodsname = request.getParameter("goodsname");
			String goodsprice = request.getParameter("goodsprice");
			String goodsimage = request.getParameter("goodsimage");
			String classifyoneid = request.getParameter("classifyoneid");
			String classifytwoid = request.getParameter("classifytwoid");
			dd.insert("insert into tb_goods (goodsname, goodsimage, goodsprice, classifyoneid, classifytwoid)"
					+ "values(?, ?, ?, ?, ?)", goodsname, goodsimage, goodsprice, classifyoneid, classifytwoid);

			ArrayList<Goods> goodss = new ArrayList<Goods>();
			rs = dd.query("select * from tb_goods");
			while(rs.next())
			{
				Goods goods = new Goods();
				goods.setClassifyoneid(rs.getString("classifyoneid"));
				goods.setClassifytwoid(rs.getString("classifytwoid"));
				goods.setGoodsid(rs.getString("goodsid"));
				goods.setGoodsimage(rs.getString("goodsimage"));
				goods.setGoodsname(rs.getString("goodsname"));
				goods.setGoodsprice(rs.getString("goodsprice"));
				goodss.add(goods);
			}
			
			//把结果集放入request中
			request.setAttribute("goodss", goodss);
			// 获取转发对象
			rd = request.getRequestDispatcher("/GoodsDisplay.jsp");
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
			rd = request.getRequestDispatcher("/GoodsAdd.jsp");
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
			String goodsid = request.getParameter("goodsid");
			String goodsname = request.getParameter("goodsname");
			String goodsprice = request.getParameter("goodsprice");
			String classifyoneid = request.getParameter("classifyoneid");
			String classifytwoid = request.getParameter("classifytwoid");
			dd.modify("update tb_goods set goodsname = ?, goodsprice = ?, classifyoneid = ? , classifytwoid = ? where goodsid = ?"
					,goodsname, goodsprice, classifyoneid, classifytwoid, goodsid);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		try 
		{
			rs = dd.query("select * from tb_goods");
			ArrayList<Goods> goodss = new ArrayList<Goods>();
			
			while(rs.next())
			{
				Goods goods = new Goods();
				goods.setClassifyoneid(rs.getString("classifyoneid"));
				goods.setClassifytwoid(rs.getString("classifytwoid"));
				goods.setGoodsid(rs.getString("goodsid"));
				goods.setGoodsimage(rs.getString("goodsimage"));
				goods.setGoodsname(rs.getString("goodsname"));
				goods.setGoodsprice(rs.getString("goodsprice"));
				goodss.add(goods);
			}
			
			//把结果集放入request中
			request.setAttribute("goodss", goodss);
			// 获取转发对象
			rd = request.getRequestDispatcher("/GoodsDisplay.jsp");
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
		String goodsid = request.getParameter("goodsId");
		try 
		{
			rs = dd.query("select * from tb_goods where goodsid = ?", goodsid);
			while(rs.next())
			{
				Goods goods = new Goods();
				goods.setClassifyoneid(rs.getString("classifyoneid"));
				goods.setClassifytwoid(rs.getString("classifytwoid"));
				goods.setGoodsid(rs.getString("goodsid"));
				goods.setGoodsimage(rs.getString("goodsimage"));
				goods.setGoodsname(rs.getString("goodsname"));
				goods.setGoodsprice(rs.getString("goodsprice"));
				//把结果集放入request中
				request.setAttribute("goods", goods);
			}
			
			// 获取转发对象
			rd = request.getRequestDispatcher("/GoodsEdit.jsp");
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
			rs = dd.query("select * from tb_goods");
			ArrayList<Goods> goodss = new ArrayList<Goods>();
			
			while(rs.next())
			{
				Goods goods = new Goods();
				goods.setClassifyoneid(rs.getString("classifyoneid"));
				goods.setClassifytwoid(rs.getString("classifytwoid"));
				goods.setGoodsid(rs.getString("goodsid"));
				goods.setGoodsimage(rs.getString("goodsimage"));
				goods.setGoodsname(rs.getString("goodsname"));
				goods.setGoodsprice(rs.getString("goodsprice"));
				goodss.add(goods);
			}
			
			//把结果集放入request中
			request.setAttribute("goodss", goodss);
			// 获取转发对象
			rd = request.getRequestDispatcher("/GoodsDisplay.jsp");
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




















