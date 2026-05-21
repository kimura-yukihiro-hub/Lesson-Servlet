package chapter14;

import java.io.Serializable;
import java.sql.Timestamp;

public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String content;
	private Timestamp postDate;

	public Post() {
	}

	public Post(int id, String name, String content, Timestamp postDate) {
		this.id = id;
		this.name = name;
		this.content = content;
		this.postDate = postDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getPostDate() {
		return postDate;
	}

	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}
}
