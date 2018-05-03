package entity;

public class ClassifyOne {
	private String classifyoneid;
	private String classifyonename;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classifyoneid == null) ? 0 : classifyoneid.hashCode());
		result = prime * result + ((classifyonename == null) ? 0 : classifyonename.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassifyOne other = (ClassifyOne) obj;
		if (classifyoneid == null) {
			if (other.classifyoneid != null)
				return false;
		} else if (!classifyoneid.equals(other.classifyoneid))
			return false;
		if (classifyonename == null) {
			if (other.classifyonename != null)
				return false;
		} else if (!classifyonename.equals(other.classifyonename))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ClassifyOne [classifyoneid=" + classifyoneid + ", classifyonename=" + classifyonename + "]";
	}
	public String getClassifyoneid() {
		return classifyoneid;
	}
	public void setClassifyoneid(String classifyoneid) {
		this.classifyoneid = classifyoneid;
	}
	public String getClassifyonename() {
		return classifyonename;
	}
	public void setClassifyonename(String classifyonename) {
		this.classifyonename = classifyonename;
	}
}
