package wpxmlrpc4j;

import java.util.Date;

public class Comment {
	/**always GMT*/
	private Date datecreated;
	private String user_id;
	private String comment_id;
	private String parent;
	private String status;
	private String content;
	private String link;
	private String post_id;
	private String post_title;
	private String author;
	private String author_url;
	private String author_email;
	private String author_ip;
	
	public EditComment asEditComment() {
		EditComment e = new EditComment();
		e.setAuthor(getAuthor());
		e.setAuthor_email(getAuthor_email());
		e.setAuthor_url(getAuthor_url());
		e.setContent(getContent());
		e.setDate_created_gmt(getDatecreated());
		e.setStatus(getStatus());
		return e;
	}

	public Date getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor_url() {
		return author_url;
	}

	public void setAuthor_url(String author_url) {
		this.author_url = author_url;
	}

	public String getAuthor_email() {
		return author_email;
	}

	public void setAuthor_email(String author_email) {
		this.author_email = author_email;
	}

	public String getAuthor_ip() {
		return author_ip;
	}

	public void setAuthor_ip(String author_ip) {
		this.author_ip = author_ip;
	}
	
	
}
