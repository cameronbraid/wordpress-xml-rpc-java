package wpxmlrpc4j;

public class CommentCount {
	private int approved;
	private int awaiting_moderation;
	private int spam;
	private int total_comments;
	public int getApproved() {
		return approved;
	}
	public void setApproved(int approved) {
		this.approved = approved;
	}
	public int getAwaiting_moderation() {
		return awaiting_moderation;
	}
	public void setAwaiting_moderation(int awaiting_moderation) {
		this.awaiting_moderation = awaiting_moderation;
	}
	public int getSpam() {
		return spam;
	}
	public void setSpam(int spam) {
		this.spam = spam;
	}
	public int getTotal_comments() {
		return total_comments;
	}
	public void setTotal_comments(int total_comments) {
		this.total_comments = total_comments;
	}

	
}
