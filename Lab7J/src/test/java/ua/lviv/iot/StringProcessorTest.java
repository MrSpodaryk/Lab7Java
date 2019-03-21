package ua.lviv.iot;

import java.io.IOException;

import junit.framework.TestCase;

public class StringProcessorTest extends TestCase {

    private StringProcessor sp = new StringProcessor();

    public void testFilter() throws IOException {

        sp.filterConstantText();

        assertEquals(3, sp.getListOfWords().size());

        sp.printConstantFilterText();
    }
}
