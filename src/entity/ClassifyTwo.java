package entity;

public class ClassifyTwo {
	private String classifytwoid;
	private String classifyoneid;
	private String classifytwoname;
	@Override
	public String toString() {
		return "ClassifyTwo [classifytwoid=" + classifytwoid + ", classifyoneid=" + classifyoneid + ", classifytwoname="
				+ classifytwoname + "]";
	}
	public String getClassifytwoid() {
		return classifytwoid;
	}
	public void setClassifytwoid(String classifytwoid) {
		this.classifytwoid = classifytwoid;
	}
	public String getClassifyoneid() {
		return classifyoneid;
	}
	public void setClassifyoneid(String classifyoneid) {
		this.classifyoneid = classifyoneid;
	}
	public String getClassifytwoname() {
		return classifytwoname;
	}
	public void setClassifytwoname(String classifytwoname) {
		this.classifytwoname = classifytwoname;
	}
}
