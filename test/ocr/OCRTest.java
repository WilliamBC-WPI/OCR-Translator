/* This is just a placeholder. */
package ocr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class OCRTest {


    private String top = " _     _  _       _   _  _   _   _ ";
    private String middle = "| | |  _| _| |_| |_  |_   | |_| |_|";
    private String bottom = "|_| | |_  _|   |  _| |_|  | |_|   |";


    /**
     *       _     _  _       _   _  _   _   _
     *      | | |  _| _| |_| |_  |_   | |_| |_|
     *      |_| | |_  _|   |  _| |_|  | |_|   |
     *
     * You will translate the three lines that represent the three lines of
     *
      */

    OCRTranslator ocr = new OCRTranslator();

    @Test
    void testTrue() { assertTrue(true); }

    @Test
    void checkSameLength() {
        assertTrue(ocr.sameLength(top, middle, bottom));
    }

    @Test
    void checkDifferentLength() { assertFalse(ocr.sameLength(" ", " |", "|"));}


    @Test
    void testThrowException() {
        Throwable exception = assertThrows(OCRException.class,
                ()->{ocr.translate(" ", " |", "|");} );
    }

    @Test
    void testFourTwo() { assertEquals(ocr.translate("     _ ", "|_|  _|", "  | |_ "), "42");
    }


    @Test
    void checkEmpty() {
        assertEquals(ocr.translate("","",""), "");
    }

    @Test
    void checkZero() {
        assertEquals(ocr.translate(" _ ","| |","|_|"), "0");
    }
    @Test
    void checkOne() {
        assertEquals(ocr.translate(" ","|","|"), "1");
    }

    @Test
    void checkTwo() {
        assertEquals(ocr.translate(" _ "," _|","|_ "), "2");
    }

    @Test
    void checkThree() {
        assertEquals(ocr.translate("_ ","_|","_|"), "3");
    }

    @Test
    void checkFour() {
        assertEquals(ocr.translate("   ","|_|","  |"), "4");
    }

    @Test
    void checkFive() {
        assertEquals(ocr.translate(" _ ","|_ "," _|"), "5");
    }

    @Test
    void checkSix() {
        assertEquals(ocr.translate(" _ ","|_ ","|_|"), "6");
    }

    @Test
    void checkSeven() { assertEquals(ocr.translate("_ "," |"," |"), "7");}

    @Test
    void checkEight() { assertEquals(ocr.translate(" _ ","|_|","|_|"), "8");}

    @Test
    void checkNine() { assertEquals(ocr.translate(" _ ", "|_|", "  |"), "9");}

}
