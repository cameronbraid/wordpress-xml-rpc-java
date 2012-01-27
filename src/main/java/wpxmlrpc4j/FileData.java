package wpxmlrpc4j;

public class FileData {
	private String name;
	private String type;
	private byte[] bits;
	private boolean overwrite;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getBits() {
		return bits;
	}
	public void setBits(byte[] bits) {
		this.bits = bits;
	}
	public boolean isOverwrite() {
		return overwrite;
	}
	public void setOverwrite(boolean overwrite) {
		this.overwrite = overwrite;
	}
	
	
}
