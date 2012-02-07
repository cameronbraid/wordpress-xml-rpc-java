package wpxmlrpc4j;

import java.util.Arrays;
import java.util.Date;

/**
 */
public class Page implements Cloneable {
	private Date dateCreated;
	private Integer userid;
	private Integer page_id;
	private String page_status;
	private String description;
	private String title;
	private String link;
	private String permaLink;
	private String[] categories;
	private String excerpt;
	private String text_more;
	private Integer mt_allow_comments;
	private Integer mt_allow_pings;
	private String wp_slug;
	private String wp_password;
	private String wp_author;
	private Integer wp_page_parent_id;
	private String wp_page_parent_title;
	private Integer wp_page_order;
	private String wp_author_id;
	private String wp_author_display_name;
	private Date date_created_gmt;
	private CustomField[] custom_fields;
	private String wp_page_template;
	
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getPage_id() {
		return page_id;
	}

	public void setPage_id(Integer page_id) {
		this.page_id = page_id;
	}

	public String getPage_status() {
		return page_status;
	}

	public void setPage_status(String page_status) {
		this.page_status = page_status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPermaLink() {
		return permaLink;
	}

	public void setPermaLink(String permaLink) {
		this.permaLink = permaLink;
	}

	public String[] getCategories() {
		return categories;
	}

	public void setCategories(String[] categories) {
		this.categories = categories;
	}

	public String getExcerpt() {
		return excerpt;
	}

	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}

	public String getText_more() {
		return text_more;
	}

	public void setText_more(String text_more) {
		this.text_more = text_more;
	}

	public Integer getMt_allow_comments() {
		return mt_allow_comments;
	}

	public void setMt_allow_comments(Integer mt_allow_comments) {
		this.mt_allow_comments = mt_allow_comments;
	}

	public Integer getMt_allow_pings() {
		return mt_allow_pings;
	}

	public void setMt_allow_pings(Integer mt_allow_pings) {
		this.mt_allow_pings = mt_allow_pings;
	}

	public String getWp_slug() {
		return wp_slug;
	}

	public void setWp_slug(String wp_slug) {
		this.wp_slug = wp_slug;
	}

	public String getWp_password() {
		return wp_password;
	}

	public void setWp_password(String wp_password) {
		this.wp_password = wp_password;
	}

	public String getWp_author() {
		return wp_author;
	}

	public void setWp_author(String wp_author) {
		this.wp_author = wp_author;
	}

	public Integer getWp_page_parent_id() {
		return wp_page_parent_id;
	}

	public void setWp_page_parent_id(Integer wp_page_parent_id) {
		this.wp_page_parent_id = wp_page_parent_id;
	}

	public String getWp_page_parent_title() {
		return wp_page_parent_title;
	}

	public void setWp_page_parent_title(String wp_page_parent_title) {
		this.wp_page_parent_title = wp_page_parent_title;
	}

	public Integer getWp_page_order() {
		return wp_page_order;
	}

	public void setWp_page_order(Integer wp_page_order) {
		this.wp_page_order = wp_page_order;
	}

	public String getWp_author_id() {
		return wp_author_id;
	}

	public void setWp_author_id(String wp_author_id) {
		this.wp_author_id = wp_author_id;
	}

	public String getWp_author_display_name() {
		return wp_author_display_name;
	}

	public void setWp_author_display_name(String wp_author_display_name) {
		this.wp_author_display_name = wp_author_display_name;
	}

	public Date getDate_created_gmt() {
		return date_created_gmt;
	}

	public void setDate_created_gmt(Date date_created_gmt) {
		this.date_created_gmt = date_created_gmt;
	}

	public CustomField[] getCustom_fields() {
		return custom_fields;
	}

	public void setCustom_fields(CustomField[] custom_fields) {
		this.custom_fields = custom_fields;
	}

	public String getWp_page_template() {
		return wp_page_template;
	}

	public void setWp_page_template(String wp_page_template) {
		this.wp_page_template = wp_page_template;
	}

	public Page copy() {
		try {
			return (Page)this.clone();
		}
		catch (Exception e) {
			throw new RuntimeException("Page not clonable", e);
		}
	}

}
