package edu.ssafy.dto;

import java.time.LocalDateTime;

public class BoardDto {
	private int id;
	private String title;
	private String content;
	private String registId;
	private LocalDateTime registDate;

	public BoardDto() {
	}

	public BoardDto(int id, String title, String content, String registId, LocalDateTime registDate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.registId = registId;
		this.registDate = registDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegistId() {
		return registId;
	}

	public void setRegistId(String registId) {
		this.registId = registId;
	}

	public LocalDateTime getRegistDate() {
		return registDate;
	}

	public void setRegistDate(LocalDateTime registDate) {
		this.registDate = registDate;
	}

	@Override
	public String toString() {
		return "BoardDto [id=" + id + ", title=" + title + ", content=" + content + ", registId=" + registId
				+ ", registDate=" + registDate + "]";
	}

}
