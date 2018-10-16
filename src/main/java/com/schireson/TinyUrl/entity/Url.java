package com.schireson.TinyUrl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Url")
public class Url {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String url;

	private String tinyUrl;

	public Url(String url, String tinyUrl) {
		super();
		this.url = url;
		this.tinyUrl = tinyUrl;
	}

	public Url() {
		super();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTinyUrl() {
		return tinyUrl;
	}

	public void setTinyUrl(String tinyUrl) {
		this.tinyUrl = tinyUrl;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Url [id=" + id + ", url=" + url + ", tinyUrl=" + tinyUrl + "]";
	}

}
