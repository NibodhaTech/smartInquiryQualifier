/**
 * 
 */
package com.nibodha.smart.inquiry.qualifier.service;

import java.io.StringReader;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.nibodha.smart.inquiry.qualifier.common.Utils;

/**
 * @author Suresh Kumar S
 *
 */

@Service
public class ServiceImpl implements ServiceInter {

	@Override
	public double getGuessworkScore(String productURL, String email) {
		double score = 0.0;
		String url = Utils.formUrl(productURL, email);
		StringReader jsonReader = Utils.getResponse(url);
		if(jsonReader == null) return 0.0; 
		JsonElement result = new JsonParser().parse(jsonReader);
		if(result.getAsJsonObject().get("status").getAsString().equalsIgnoreCase("yes")){
			score = result.getAsJsonObject().get("products").getAsJsonObject().get(productURL).getAsJsonObject().get("score").getAsDouble();
		}
		return score;
	}
	
	/*public static void main(String[] args) {
		System.out.println(new ServiceImpl().getGuessworkScore("http://cloud.google.com", "shasureshkumar@gmail.com"));
	}*/

}
