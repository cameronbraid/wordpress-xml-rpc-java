package wpxmlrpc4j;

import java.util.Date;
import java.util.Map;

public class MediaItem {
	private Date date_created_gmt;
	private Integer parent;
	private String link;
	private String thumbnail;
	private String title;
	private String caption;
	private String description;
	private Map<String, Object> metadata;
	private String file;
	public Date getDate_created_gmt() {
		return date_created_gmt;
	}
	public void setDate_created_gmt(Date date_created_gmt) {
		this.date_created_gmt = date_created_gmt;
	}
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Map<String, Object> getMetadata() {
		return metadata;
	}
	public void setMetadata(Map<String, Object> metadata) {
		this.metadata = metadata;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	
	
}
