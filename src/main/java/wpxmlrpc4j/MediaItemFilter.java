package wpxmlrpc4j;

public class MediaItemFilter {
	private Integer number;
	private Integer offset;
	private Integer parent_id;
	/**  (e.g., 'image/jpeg', 'application/pdf') **/
	private String mime_type;
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public String getMime_type() {
		return mime_type;
	}
	public void setMime_type(String mime_type) {
		this.mime_type = mime_type;
	}

	
}
