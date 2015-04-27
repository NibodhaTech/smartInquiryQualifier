/**
 * 
 */
package com.nibodha.smart.inquiry.qualifier.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.nibodha.smart.inquiry.qualifier.model.Entity;

/**
 * @author Suresh Kumar S
 *
 */
public class EntityWrapper {
	
	private List<Entity> entities;

	/**
	 * @return the entities
	 */
	public List<Entity> getEntities() {
		if(entities == null) return new ArrayList<Entity>();
		return entities;
	}

	/**
	 * @param entities the entities to set
	 */
	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}
	
}
