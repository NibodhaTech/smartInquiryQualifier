/**
 * 
 */
package com.nibodha.ear.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nibodha.ear.model.Entity;
import com.nibodha.ear.service.EARServiceInter;
import com.nibodha.ear.web.model.EntityContext;
import com.nibodha.ear.web.model.Score;
import com.nibodha.ear.wrapper.EntityContextWrapper;
import com.nibodha.ear.wrapper.EntityWrapper;

/**
 * @author Suresh Kumar S
 *
 */

@RestController
public class EmailAutoResponderController {
	@Autowired
	EARServiceInter earServiceInter;
	
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
					scores.add(new Score(email, earServiceInter.getGuessworkScore(entity.getProductURL(), email)));
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
