package org.mordraug.gw2orchestral.Gw2Orchestral.sheet;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class Part {
	private List<Note> notes = Lists.newArrayList();
	
	/**
	 * Adds note to list, checks for duplicate in process
	 * @param mNote Note object to be added
	 * @return true if note was added, false otherwise
	 */
	public boolean addNote(Note mNote){
		if(!notes.contains(mNote)){
			notes.add(mNote);
			Collections.sort(notes, new Note());
			return true;
		}
		return false;
	}
	
	public Note getNote(int i){
		return notes.get(i);
	}
	
	public int getLength(){
		return notes.size();
	}

	public boolean removeNote(Note mNote) {
		return notes.remove(mNote);
	}
}