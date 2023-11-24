package kr.co.himedia.fileupload;

/*
	id 		NUMBER		PRIMARY KEY
	,title	varchar2(200)	NOT NULL
	,category	varchar2(30)	
	,ofile	varchar2(100) NOT NULL
	,sfile	varchar2(30) NOT NULL
	,postdate	DATE	DEFAULT sysdate NOT NULL  * 
 */
public class HiFileDTO {
	
	private String id;
	private String title;
	private String category;
	private String ofile;
	private String sfile;
	private String postdate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOfile() {
		return ofile;
	}
	public void setOfile(String ofile) {
		this.ofile = ofile;
	}
	public String getSfile() {
		return sfile;
	}
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	public String getPostdate() {
		return postdate;
	}
	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}
	
	

}
