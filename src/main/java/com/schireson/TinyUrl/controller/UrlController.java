package com.schireson.TinyUrl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.schireson.TinyUrl.entity.Url;
import com.schireson.TinyUrl.service.UrlService;

@RestController
public class UrlController {

	@Autowired
	private UrlService urlService;

	// private ObjectMapper mapper = new ObjectMapper();

	@GetMapping("/ksaini.com/{tinyUrl}")
	public RedirectView getUrl(@PathVariable String tinyUrl, HttpServletRequest request, HttpServletResponse response) {
		
		
		 RedirectView view = new RedirectView();
		 view.setUrl("http://" +urlService.getByTinyUrl(tinyUrl).getUrl());
		 System.out.println(urlService.getByTinyUrl(tinyUrl).getUrl());
		 return view;
		
		//return null;
	}

	@PostMapping("/getTinyUrl")
	public String getTinyUrl(HttpServletRequest request, HttpServletResponse response, @RequestBody Url url)
			throws JsonProcessingException, IOException {
		List<Url> urls = urlService.getAllUrls();
		if (urls.stream().anyMatch(t -> t.getUrl().equals(url.getUrl()))) {
			return "Url already exists";
		} else {

			urlService.addUrl(url);
			long s = urlService.getUrl(url.getUrl()).getId();
			url.setTinyUrl(convertTo62Base(s));
			urlService.addUrl(url);

			return "http://localhost:8080/ksaini.com/" + convertTo62Base(s);
		}
	}
	/*
	 * This method converts the long to base62
	 */
	public String convertTo62Base(long toBeConverted) {
		final int LENGTH_OF_URL_CODE = 7;
		String[] elements = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "A", "B", "C",
				"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z" };
		String convertedString = "";
		int numOfDiffChars = elements.length;
		if (toBeConverted < numOfDiffChars + 1 && toBeConverted > 0) {
			convertedString = elements[(int) (toBeConverted - 1)];
		} else if (toBeConverted > numOfDiffChars) {
			long mod = 0;
			long multiplier = 0;
			boolean determinedTheLength = false;
			for (int j = LENGTH_OF_URL_CODE; j >= 0; j--) {
				multiplier = (long) (toBeConverted / Math.pow(numOfDiffChars, j));
				if (multiplier > 0 && toBeConverted >= numOfDiffChars) {
					convertedString += elements[(int) multiplier];
					determinedTheLength = true;
				} else if (determinedTheLength && multiplier == 0) {
					convertedString += elements[0];
				} else if (toBeConverted < numOfDiffChars) {
					convertedString += elements[(int) mod];
				}

				mod = (long) (toBeConverted % Math.pow(numOfDiffChars, j));
				toBeConverted = mod;
			}

		}
		return convertedString;
	}

	// public Long getDictionaryKeyFromUniqueID(String uniqueID) {
	// List<Character> base62Number = new ArrayList<>();
	// for (int i = 0; i < uniqueID.length(); ++i) {
	// base62Number.add(uniqueID.charAt(i));
	// }
	// Long dictionaryKey = convertBase62ToBase10ID(base62IDs);
	// return dictionaryKey;
	// }
	//
	// private Long convertBase62ToBase10ID(List<Character> ids) {
	// long id = 0L;
	// int exp = ids.size() - 1
	// for (int i = 0; i < ids.size(); ++i, --exp) {
	// int base10 = charToIndexTable.get(ids.get(i));
	// id += (base10 * Math.pow(62.0, exp));
	// }
	// return id;
	// }
}
