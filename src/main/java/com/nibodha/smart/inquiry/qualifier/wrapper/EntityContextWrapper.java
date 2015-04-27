/**
 * 
 */
package com.nibodha.smart.inquiry.qualifier.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.nibodha.smart.inquiry.qualifier.web.model.EntityContext;

/**
 * @author Suresh Kumar S
 *
 */
public class EntityContextWrapper {
	private List<EntityContext> entityContexts;

	/**
	 * @return the entityContexts
	 */
	public List<EntityContext> getEntityContexts() {
		if(entityContexts == null) return new ArrayList<EntityContext>();
		return entityContexts;
	}

	/**
	 * @param entityContexts the entityContexts to set
	 */
	public void setEntityContexts(List<EntityContext> entityContexts) {
		this.entityContexts = entityContexts;
	}
	
	
}
