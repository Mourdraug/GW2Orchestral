package org.mordraug.gw2orchestral.Gw2Orchestral;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mordraug.gw2orchestral.Gw2Orchestral.sheet.NoteTest;
import org.mordraug.gw2orchestral.Gw2Orchestral.sheet.PartTest;
import org.mordraug.gw2orchestral.Gw2Orchestral.sheet.SheetTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	NoteTest.class,
	PartTest.class,
	BootstrapCDI.class, //Throw CDI-Runner classes under this
	SheetTest.class
})

public class AppTest 
{
}
