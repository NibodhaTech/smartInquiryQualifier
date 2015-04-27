/**
 * 
 */
package com.nibodha.smart.inquiry.qualifier.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nibodha.smart.inquiry.qualifier.model.Entity;
import com.nibodha.smart.inquiry.qualifier.service.ServiceInter;
import com.nibodha.smart.inquiry.qualifier.web.model.EntityContext;
import com.nibodha.smart.inquiry.qualifier.web.model.Score;
import com.nibodha.smart.inquiry.qualifier.wrapper.EntityContextWrapper;
import com.nibodha.smart.inquiry.qualifier.wrapper.EntityWrapper;

/**
 * @author Suresh Kumar S
 *
 */

@RestController
public class Controller {
	@Autowired
	ServiceInter serviceInter;
	
	@RequestMapping(value="/smartinquiry", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	@ResponseBody
	public EntityContextWrapper getScore(@RequestBody EntityWrapper entityWrapper) {
		EntityContextWrapper entityContextWrapper = null;
		List<Entity> entities = entityWrapper.getEntities();
		if(entities != null && !entities.isEmpty()){
			entityContextWrapper = new EntityContextWrapper();
			List<EntityContext> entityContexts = new ArrayList<EntityContext>();
			EntityContext entityContext = new EntityContext();
			for(Entity entity : entities){
				entityContext.setProductURL(entity.getProductURL());
				List<Score> scores = new ArrayList<Score>();
				for(String email : entity.getEmailIds()){
					scores.add(new Score(email, serviceInter.getGuessworkScore(entity.getProductURL(), email)));
				}
				Collections.sort(scores);
				entityContext.setScores(scores);
				entityContexts.add(entityContext);
			}
			entityContextWrapper.setEntityContexts(entityContexts);
		}
		return entityContextWrapper;
	}
}
