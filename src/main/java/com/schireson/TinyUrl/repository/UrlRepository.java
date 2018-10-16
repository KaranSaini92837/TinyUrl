package com.schireson.TinyUrl.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.schireson.TinyUrl.entity.Url;

@Repository
public interface UrlRepository extends CrudRepository<Url, Long>{
	
	@Query("select u from Url u where u.url = ?1")
	public Url findByUrl(String url);
	
	@Query("select u from Url u where u.tinyUrl = ?1")
	public Url findByTinyUrl(String tinyUrl);
	
}
