
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created by Chuck on 6/29/2014.
 */
public class KanjintTest extends TestCase {
    public void testKanji(){
        Assert.assertEquals(5,          Kanjint.kanjiToInteger("五"));
        Assert.assertEquals(31,         Kanjint.kanjiToInteger("三十一"));
        Assert.assertEquals(5972,       Kanjint.kanjiToInteger("五千九百七十二"));
        Assert.assertEquals(10,         Kanjint.kanjiToInteger("十"));
        Assert.assertEquals(50,         Kanjint.kanjiToInteger("五十"));
        Assert.assertEquals(500000,     Kanjint.kanjiToInteger("五十万"));
        Assert.assertEquals(30000,      Kanjint.kanjiToInteger("三万"));
        Assert.assertEquals(40000,      Kanjint.kanjiToInteger("四万"));
        Assert.assertEquals(50000,      Kanjint.kanjiToInteger("五万"));
        Assert.assertEquals(60000,      Kanjint.kanjiToInteger("六万"));
        Assert.assertEquals(70000,      Kanjint.kanjiToInteger("七万"));
        Assert.assertEquals(80000,      Kanjint.kanjiToInteger("八万"));
        Assert.assertEquals(90000,      Kanjint.kanjiToInteger("九万"));
        Assert.assertEquals(100000,     Kanjint.kanjiToInteger("十万"));
        Assert.assertEquals(200000,     Kanjint.kanjiToInteger("二十万"));
        Assert.assertEquals(300000,     Kanjint.kanjiToInteger("三十万"));
        Assert.assertEquals(400000,     Kanjint.kanjiToInteger("四十万"));
        Assert.assertEquals(500000,     Kanjint.kanjiToInteger("五十万"));
        Assert.assertEquals(600000,     Kanjint.kanjiToInteger("六十万"));
        Assert.assertEquals(700000,     Kanjint.kanjiToInteger("七十万"));
        Assert.assertEquals(800000,     Kanjint.kanjiToInteger("八十万"));
        Assert.assertEquals(900000,     Kanjint.kanjiToInteger("九十万"));
        Assert.assertEquals(1000000,    Kanjint.kanjiToInteger("百万"));
        Assert.assertEquals(101,        Kanjint.kanjiToInteger("百一"));
        Assert.assertEquals(102,        Kanjint.kanjiToInteger("百二"));
        //Assert.assertEquals(111,        Kanjint.kanjiToInteger("客十一"));
        Assert.assertEquals(110,        Kanjint.kanjiToInteger("百十"));
        Assert.assertEquals(201,        Kanjint.kanjiToInteger("二百一"));
        Assert.assertEquals(836,        Kanjint.kanjiToInteger("八百三十六"));
        Assert.assertEquals(32,         Kanjint.kanjiToInteger("三十二"));
        Assert.assertEquals(86,         Kanjint.kanjiToInteger("八十六"));
        Assert.assertEquals(47,         Kanjint.kanjiToInteger("四十七"));
        Assert.assertEquals(367,        Kanjint.kanjiToInteger("三百六十七"));
        //Assert.assertEquals(469,        Kanjint.kanjiToInteger("四客六十九"));
        Assert.assertEquals(2035,       Kanjint.kanjiToInteger("二千三十五"));
        Assert.assertEquals(4015,       Kanjint.kanjiToInteger("四千一五"));
        Assert.assertEquals(6235,       Kanjint.kanjiToInteger("六千二百三十五"));
        Assert.assertEquals(3897,       Kanjint.kanjiToInteger("三千八百九十七"));
        Assert.assertEquals(51122,      Kanjint.kanjiToInteger("五万千一百二十二"));
        //Assert.assertEquals(1030759,    Kanjint.kanjiToInteger("客万三万七客五十九"));
        Assert.assertEquals(6011,       Kanjint.kanjiToInteger("六千十一"));
        Assert.assertEquals(70205,      Kanjint.kanjiToInteger("七万二百五"));


        assertCatchKanji("");
        assertCatchKanji("1");
        assertCatchKanji("10");
        assertCatchKanji("ichi");
        assertCatchKanji("八千三百二十十五");

        new Kanjint();
    }

    private void assertCatchKanji(String kanji){
        try{
            Kanjint.kanjiToInteger(kanji);
            Assert.fail();
        } catch (NumberFormatException e){
            Assert.assertTrue(true);
        }
    }

    public void testPseudoTruncate(){
        Assert.assertEquals(1, Kanjint.pseudoTruncate(1));
        Assert.assertEquals(1, Kanjint.pseudoTruncate(4));
        Assert.assertEquals(1, Kanjint.pseudoTruncate(5));
        Assert.assertEquals(0, Kanjint.pseudoTruncate(0));

        Assert.assertEquals(10, Kanjint.pseudoTruncate(10));
        Assert.assertEquals(10, Kanjint.pseudoTruncate(14));
        Assert.assertEquals(10, Kanjint.pseudoTruncate(45));
        Assert.assertEquals(10, Kanjint.pseudoTruncate(90));
        Assert.assertEquals(10, Kanjint.pseudoTruncate(99));

        Assert.assertEquals(100, Kanjint.pseudoTruncate(603));
        Assert.assertEquals(100, Kanjint.pseudoTruncate(101));
        Assert.assertEquals(100, Kanjint.pseudoTruncate(100));


        Assert.assertEquals(10000, Kanjint.pseudoTruncate(10000));
        Assert.assertEquals(10000, Kanjint.pseudoTruncate(90020));
        Assert.assertEquals(1000000, Kanjint.pseudoTruncate(4000000));
        Assert.assertEquals(100000000, Kanjint.pseudoTruncate(999999999));
    }
}
