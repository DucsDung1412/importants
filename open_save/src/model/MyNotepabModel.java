package model;

public class MyNotepabModel {
	private String fileName, content;

	public MyNotepabModel() {
		super();
		this.fileName = "";
		this.content = "";
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
