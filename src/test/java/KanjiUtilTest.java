
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

        try{
            KanjiUtil.kanjiToInteger("10");
        } catch (NumberFormatException e){
            Assert.assertTrue(true);
        }
    }
}
