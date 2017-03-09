package org.mordraug.gw2orchestral.Gw2Orchestral.sheet;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CdiRunner.class)
@AdditionalClasses(TestSheetProvider.class)

public class SheetTest {

	@Inject
	Sheet testSheet;
	
	@Test
	public void testPartAndNoteGetting(){
		Note n = testSheet.getPart(0).getNote(0);
		assertTrue(n.equals(new Note(0, 1f, 1f)));
	}
}
