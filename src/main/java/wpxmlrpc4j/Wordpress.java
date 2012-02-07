package wpxmlrpc4j;

import java.util.Map;

public interface Wordpress {
	UserBlog[] getUsersBlogs(String username, String password);
	Tag[] getTags(int blogid, String username, String password);
	Author[] getAuthors(int blogid, String username, String password);
//	Option[] getOptions(int blogid, String username, String password, OptionsFilter filter);
	Map<String, String> getPostStatusList(int blogid, String username, String password);
	Map<String, String> getPostFormats(int blogid, String username, String password, Map<String, String> filter);
	Comment[] getComments(int blogid, String username, String password, CommentFilter filter);
	Comment getComment(int blogid, String username, String password, int comment_id);
	CommentCount getCommentCount(int blogid, String username, String password, int post_id);
	boolean deleteComment(int blogid, String username, String password, int comment_id);
	boolean editComment(int blogid, String username, String password, EditComment comment);
	boolean newComment(int blogid, String username, String password, NewComment comment);
	
	/** TODO use a struct or a Map .. the determiner will be if the keys are static */
	Map<String, String> getCommentStatusList(int blogid, String username, String password);
	
	/** TODO use a struct or a Map .. the determiner will be if the keys are static */
	Map<String, String> getPageStatusList(int blogid, String username, String password);

	Map<String, String> getPageTemplates(int blogid, String username, String password);
	
	Page getPage(int blogid, int pageid, String username, String password);
	Page[] getPages(int blogid, String username, String password, int max_pages);

	PageLight[] getPageList(int blogid, String username, String password);
	
	String newPage(int blogid, String username, String password, Page page, boolean publish);
	boolean deletePage(int blogid, String username, String password, int page_id, boolean publish);
	boolean editPage(int blogid, int page_id, String username, String password, Page page, boolean publish);
	
	Category[] getCategories(int blogid, String username, String password);
	
	Integer newCategory(int blogid, String username, String password, NewCategory category);
	boolean deleteCategory(int blogid, String username, String password, int category_id);
	
	CategorySuggest[] suggestCategories(int blogid, String username, String password, String category, int max_results);
	
	File uploadFile(int blogid, String username, String password, FileData file);
	
	MediaItem[] getMediaLibrary(int blogid, String username, String password, MediaItemFilter filter);
	MediaItem getMediaItem(int blogid, String username, String password, int attachmend_id);
	
}