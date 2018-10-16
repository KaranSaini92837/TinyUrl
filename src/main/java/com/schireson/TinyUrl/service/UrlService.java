package com.schireson.TinyUrl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schireson.TinyUrl.entity.Url;
import com.schireson.TinyUrl.repository.UrlRepository;

@Service
public class UrlService {
	
	@Autowired
	private UrlRepository urlRepo;
	
	public void addUrl(Url url) {
		
		urlRepo.save(url);
		
	}
	
	public List<Url> getAllUrls(){
		return (List<Url>)urlRepo.findAll();
	}
	
	public Url getUrl(String url) {
		return urlRepo.findByUrl(url);
	}
	
	public Url getByTinyUrl(String tinyUrl) {
		return urlRepo.findByTinyUrl(tinyUrl);
	}
	
//	public boolean hasUrl(Url url) {
//		return urlRepo.existsById(url.getId());
//	}

}
