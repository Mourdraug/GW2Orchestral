package org.mordraug.gw2orchestral.Gw2Orchestral.sheet;

import javax.enterprise.inject.Produces;

import org.jglue.cdiunit.ProducesAlternative;

public class TestSheetProvider implements ISheetProvider {
	
	@Produces
	@ProducesAlternative
	public Sheet provide() {
		Sheet sheet = new Sheet();
		Part p1 = new Part();
		p1.addNote(new Note(0, 1f, 1f));
		p1.addNote(new Note(0, 1f, 3f));
		p1.addNote(new Note(1, 1f, 5f));
		p1.addNote(new Note(-1, 1f, 6f));
		p1.addNote(new Note(-3, 1f, 6f));
		p1.addNote(new Note(2, 5f, 8f));
		p1.addNote(new Note(5, 1f, 14f));
		sheet.addPart(p1);
		return sheet;
	}

}
