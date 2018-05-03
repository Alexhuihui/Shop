package entity;

public class Goods {
	private String goodsid;
	private String goodsname;
	private String goodsimage;
	private String goodsprice;
	private String classifyoneid;
	private String classifytwoid;
	
	
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getGoodsimage() {
		return goodsimage;
	}
	public void setGoodsimage(String goodsimage) {
		this.goodsimage = goodsimage;
	}
	public String getGoodsprice() {
		return goodsprice;
	}
	public void setGoodsprice(String goodsprice) {
		this.goodsprice = goodsprice;
	}
	public String getClassifyoneid() {
		return classifyoneid;
	}
	public void setClassifyoneid(String classifyoneid) {
		this.classifyoneid = classifyoneid;
	}
	public String getClassifytwoid() {
		return classifytwoid;
	}
	public void setClassifytwoid(String classifytwoid) {
		this.classifytwoid = classifytwoid;
	}
	@Override
	public String toString() {
		return "Goods [goodsid=" + goodsid + ", goodsname=" + goodsname + ", goodsimage=" + goodsimage + ", goodsprice="
				+ goodsprice + ", classifyoneid=" + classifyoneid + ", classifytwoid=" + classifytwoid + "]";
	}
	
	
	
}
