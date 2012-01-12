package wpxmlrpc4j;

import java.util.Date;

public class Comment {
	/**always GMT*/
	public Date datecreated;
	public String user_id;
	public String comment_id;
	public String parent;
	public String status;
	public String content;
	public String link;
	public String post_id;
	public String post_title;
	public String author;
	public String author_url;
	public String author_email;
	public String author_ip;
	
	public EditComment asEditComment() {
		EditComment e = new EditComment();
		e.author = author;
		e.author_email = author_email;
		e.author_url = author_url;
		e.content = content;
		e.date_created_gmt = datecreated;
		e.status = status;
		return e;
	}
}
