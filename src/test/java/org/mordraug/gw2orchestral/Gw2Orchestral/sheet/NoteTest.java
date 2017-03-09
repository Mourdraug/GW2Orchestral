package org.mordraug.gw2orchestral.Gw2Orchestral.sheet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class NoteTest {
	@Test(expected = RuntimeException.class)
	public void setNegativeLengthTest(){
		Note note = new Note();
		note.setLength(-1f);
	}
	
	@Test(expected = RuntimeException.class)
	public void setNegativePositionTest(){
		Note note = new Note();
		note.setPosition(-1);
	}
	
	@Test
	public void comparatorTestDiffPositionsNegative(){
		Note n1 = new Note(1,2f,1f);
		Note n2 = new Note(1,2f,1.2f);
		int result = new Note().compare(n1,n2);
		assertTrue("expected negative result, got: "+result, result<0);
	}
	
	@Test
	public void comparatorTestDiffPositionsPositive(){
		Note n1 = new Note(1,2f,1f);
		Note n2 = new Note(1,2f,1.5f);
		int result = new Note().compare(n2,n1);
		assertTrue("expected positive result", result>0);
	}
	
	@Test
	public void comparatorTestSamePositionDiffPitchNegative(){
		Note n1 = new Note(1,2f,1f);
		Note n2 = new Note(2,2f,1f);
		int result = new Note().compare(n1,n2);
		assertTrue("expected negative result", result<0);
	}
	
	@Test
	public void comparatorTestSamePositionDiffPitchPositive(){
		Note n1 = new Note(1,2f,1f);
		Note n2 = new Note(2,2f,1f);
		int result = new Note().compare(n2,n1);
		assertTrue("expected positive result", result>0);
	}
	
	@Test
	public void comparatorTestSamePositionAndPitch(){
		Note n1 = new Note(1,2f,1f);
		Note n2 = new Note(1,2f,1f);
		int result = new Note().compare(n1,n2);
		assertTrue("expected zero result", result==0);
	}
	
	@Test
	public void equalsQuickTestEqual(){
		Note n1 = new Note(1,2f,1f);
		Note n2 = new Note(1,2f,1f);
		assertTrue(n1.equals(n2));
	}
	
	@Test
	public void equalsQuickTestNotEqual(){
		Note n1 = new Note(1,2f,2f);
		Note n2 = new Note(1,2f,1f);
		assertFalse(n1.equals(n2));
	}
	
	@Test
	public void hashEqualsContractTest(){
		EqualsVerifier.forClass(Note.class).suppress(Warning.NONFINAL_FIELDS).verify();
	}
}
