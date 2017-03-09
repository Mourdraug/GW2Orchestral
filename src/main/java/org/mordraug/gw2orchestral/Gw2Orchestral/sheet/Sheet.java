package org.mordraug.gw2orchestral.Gw2Orchestral.sheet;

import java.util.List;

import com.google.common.collect.Lists;

public class Sheet {
	private List<Part> parts = Lists.newArrayList();
	private String name = "New Sheet";
	
	public boolean addPart(Part mPart){
		if(!parts.contains(mPart)){
			parts.add(mPart);
			return true;
		}
		return false;
	}
	
	public boolean removePart(Part mPart){
		return parts.remove(mPart);
	}
	
	public Part getPart(int i){
		return parts.get(i);
	}
	
	public void setName(String mName){
		name=mName;
	}
	
	public String getName(){
		return name;
	}
}
