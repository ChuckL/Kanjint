/**
 * Created by Chuck on 6/29/2014.
 */
public class KanjiUtil {
    public static int kanjiToInteger(String kanji) throws NumberFormatException
    {
        if(kanji.equals("")){
            throw new NumberFormatException("Cannot parse an empty string.");
        }

        //1   2    3    4   5    6   7    8    9
        //一  二   三   四   五   六   七   八   九
        //十 - 10
        //百 - 100
        //千 - 1,000
        //万 - 10,000

        int kanjiVal = 0;

        int startIndex = 0;
        int currIndex = 0;
        int prevMag = 0;

        //Looping through each kanji and figure out the segments.
        while(currIndex < kanji.length()){
            int currKanjiInt = singleKanjiToInt(kanji.charAt(currIndex));
            int currMag = pseudoTruncate(currKanjiInt);

            //The previous kanji's magnitude is greater than or equal to the current kanji's magnitude.  Therefor we're at the end of a segment.
            if(prevMag >= currMag){
                //Analyze the segment and add it to the number.
                kanjiVal += analyzeCurrentSegment(kanji.substring(startIndex, currIndex));
                startIndex = currIndex;
                prevMag = 0;
            }
            else{
                prevMag = currMag;
                currIndex++;
            }
        }

        //Analyze the last segment.
        kanjiVal += analyzeCurrentSegment(kanji.substring(startIndex, currIndex));

        return kanjiVal;
    }

    public static int analyzeCurrentSegment(String kanji){
        int currInt = 1;

        for(char c : kanji.toCharArray()){
            currInt *= singleKanjiToInt(c);
        }
        return currInt;
    }

    public static int singleKanjiToInt(char kanji){
        return singleKanjiToInt("" + kanji);
    }

    public static int singleKanjiToInt(String kanji){

        if(kanji.equals("一")) return 1;
        if(kanji.equals("二")) return 2;
        if(kanji.equals("三")) return 3;
        if(kanji.equals("四")) return 4;
        if(kanji.equals("五")) return 5;
        if(kanji.equals("六")) return 6;
        if(kanji.equals("七")) return 7;
        if(kanji.equals("八")) return 8;
        if(kanji.equals("九")) return 9;

        if(kanji.equals("十")) return 10;
        if(kanji.equals("百")) return 100;
        if(kanji.equals("千")) return 1000;
        if(kanji.equals("万")) return 10000;

        throw new NumberFormatException("Unsupported Kanji " + kanji);
    }

    /**
     * Truncates to the current magnitude.
     * @param number Integer to truncate.
     * @return the truncated magnitude.
     */
    public static int pseudoTruncate(int number){
        int currInt = 1;
        int prevInt = 0;
        while(currInt <= number){
            prevInt = currInt;
            currInt *= 10;
        }

        return prevInt;
    }

}
