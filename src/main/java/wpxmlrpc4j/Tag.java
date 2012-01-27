package wpxmlrpc4j;

public class Tag {
	private Integer tag_id;
	private String name;
	private Integer count;
	private String slug;
	private String html_url;
	private String rss_url;
	public Integer getTag_id() {
		return tag_id;
	}
	public void setTag_id(Integer tag_id) {
		this.tag_id = tag_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getHtml_url() {
		return html_url;
	}
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	public String getRss_url() {
		return rss_url;
	}
	public void setRss_url(String rss_url) {
		this.rss_url = rss_url;
	}

}
