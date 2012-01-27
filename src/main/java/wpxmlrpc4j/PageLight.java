package wpxmlrpc4j;

import java.util.Date;

public class PageLight {
	private Integer page_id;
	private String page_title;
	private Integer page_parent_id;
	private Date date_created_gmt;
	private Date datecreated;
	public Integer getPage_id() {
		return page_id;
	}
	public void setPage_id(Integer page_id) {
		this.page_id = page_id;
	}
	public String getPage_title() {
		return page_title;
	}
	public void setPage_title(String page_title) {
		this.page_title = page_title;
	}
	public Integer getPage_parent_id() {
		return page_parent_id;
	}
	public void setPage_parent_id(Integer page_parent_id) {
		this.page_parent_id = page_parent_id;
	}
	public Date getDate_created_gmt() {
		return date_created_gmt;
	}
	public void setDate_created_gmt(Date date_created_gmt) {
		this.date_created_gmt = date_created_gmt;
	}
	public Date getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}
	
	
}
