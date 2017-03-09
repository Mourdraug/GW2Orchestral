package org.mordraug.gw2orchestral.Gw2Orchestral.sheet;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Random;

/*
 * Tests assume that created Part is empty on creation
 */
public class PartTest {
	@Test
	public void addAndGetSingleNoteTest(){
		Part part = new Part();
		Note note = new Note();
		part.addNote(note);
		assertEquals(note, part.getNote(0));
	}
	
	@Test
	public void addAndRemoveSingleNoteTest(){
		Part part = new Part();
		Note note = new Note();
		part.addNote(note);
		part.removeNote(note);
		assertTrue(part.getLength()<=0);
	}
	
	@Test
	public void removeNotAddedNoteTest(){
		Part part = new Part();
		Note note = new Note();
		assertFalse(part.removeNote(note));
	}
	
	@Test
	public void addDuplicateNoteTestBool(){
		Part part = new Part();
		Note note = new Note();
		part.addNote(note);
		assertFalse(part.addNote(note));
	}
	
	@Test
	public void addDuplicateNoteTestNumber(){
		Part part = new Part();
		Note note = new Note();
		part.addNote(note);
		part.addNote(note);
		assertEquals(part.getLength(), 1);
	}
	
	//Monkey testing 
	@Test
	public void addNotesMonkeySortingTest(){
		int noteCount = 100;
		Part part = new Part();
		for(int i = 0; i < noteCount; i++){
			Random rand = new Random();
			int pitch = rand.nextInt(20)-10;
			float length = 5*rand.nextFloat();
			float position = (float)Math.ceil(1000*rand.nextFloat());
			Note note = new Note(pitch, length, position);
			part.addNote(note);
		}
		Note lastNote = part.getNote(0);
		int errorIndex = -1;
		for(int i = 1; i < part.getLength(); i++){
			Note currentNote = part.getNote(i);
			if(!(lastNote.getPosition()<currentNote.getPosition()||(lastNote.getPosition()==currentNote.getPosition()&&lastNote.getPitch()<currentNote.getPitch()))){
				errorIndex=i;
				break;
			}
			lastNote=currentNote;
		}
		assertEquals(-1, errorIndex);
	}
}
