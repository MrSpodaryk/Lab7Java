package ua.lviv.iot;

import java.io.IOException;

import junit.framework.TestCase;

public class StringProcessorTest extends TestCase {

    private StringProcessor sp = new StringProcessor();

    public void testFilter() throws IOException {

        assertEquals("[olena, green, noose]", sp.filterText("olena has green eyes or noose?", "5"));
    }
}
