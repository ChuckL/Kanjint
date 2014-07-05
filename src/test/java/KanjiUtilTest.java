
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created by Chuck on 6/29/2014.
 */
public class KanjiUtilTest extends TestCase {
    public void testKanji(){
        Assert.assertEquals(5, KanjiUtil.kanjiToInteger("五"));
        Assert.assertEquals(31, KanjiUtil.kanjiToInteger("三十一"));
        Assert.assertEquals(5972, KanjiUtil.kanjiToInteger("五千九百七十二"));
        Assert.assertEquals(10, KanjiUtil.kanjiToInteger("十"));
        Assert.assertEquals(50, KanjiUtil.kanjiToInteger("五十"));
        Assert.assertEquals(500000, KanjiUtil.kanjiToInteger("五十万"));


        assertCatchKanji("");
        assertCatchKanji("1");
        assertCatchKanji("10");
        assertCatchKanji("ichi");

        new KanjiUtil();
    }

    private void assertCatchKanji(String kanji){
        try{
            KanjiUtil.kanjiToInteger(kanji);
        } catch (NumberFormatException e){
            Assert.assertTrue(true);
        }
    }

    public void testPseudoTruncate(){
        Assert.assertEquals(1, KanjiUtil.pseudoTruncate(1));
        Assert.assertEquals(1, KanjiUtil.pseudoTruncate(4));
        Assert.assertEquals(1, KanjiUtil.pseudoTruncate(5));
        Assert.assertEquals(0, KanjiUtil.pseudoTruncate(0));

        Assert.assertEquals(10, KanjiUtil.pseudoTruncate(10));
        Assert.assertEquals(10, KanjiUtil.pseudoTruncate(14));
        Assert.assertEquals(10, KanjiUtil.pseudoTruncate(45));
        Assert.assertEquals(10, KanjiUtil.pseudoTruncate(90));
        Assert.assertEquals(10, KanjiUtil.pseudoTruncate(99));

        Assert.assertEquals(100, KanjiUtil.pseudoTruncate(603));
        Assert.assertEquals(100, KanjiUtil.pseudoTruncate(101));
        Assert.assertEquals(100, KanjiUtil.pseudoTruncate(100));


        Assert.assertEquals(10000, KanjiUtil.pseudoTruncate(10000));
        Assert.assertEquals(10000, KanjiUtil.pseudoTruncate(90020));
        Assert.assertEquals(1000000, KanjiUtil.pseudoTruncate(4000000));
        Assert.assertEquals(100000000, KanjiUtil.pseudoTruncate(999999999));
    }
}
