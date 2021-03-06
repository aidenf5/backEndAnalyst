import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class initialScriptTesting {
    public static void main(String[] args) {
        //STEP ONE(COMPLETED): TAKE THE ENTIRE BLOCK TEXT OF AN ISSUE, FORMAT IT JUST AS IF IT WERE MANUALLY COPY PASTED
        //PIECE BY PIECE, LIKE IN initialScript, WITH "initialText","initialText2","initialText3".
        //STEP TWO: MANUALLY REMOVE EXTRANEOUS TEXT FROM A .txt FILE, TRY AND BULK RUN THE SCRIPT ON THE ENTIRE BLOCK OF TEXT.
        String allText = "\"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"B101 (P1): 5 florin (withdrawn)\\tVG\\tVF\\tUNC\\n\" +\n" +
                "                \"Green and rust. Front: Papiamento text; flag; Palm Beach’s Aruba Sheraton Hotel and the Aruba Caribbean Hotel; windmill; sail boats. Back: Dutch text; coat of arms; prohibition against counterfeiting. No security thread. Watermark: None. Printer: JOH. ENSCHEDÉ EN ZONEN. 155 x 66 mm. Paper.\\n\" +\n" +
                "                \"\\ta.\\t1 JANUARI 1986. Sig. 1: Driessen/Mansur. 600,000 notes.\\t1\\t4\\t16\\n\" +\n" +
                "                \"\\tas.\\tDiagonal red SPECIMEN ovpt front/back;\\n\" +\n" +
                "                \"horizontal black SPECIMEN No. # ovpt lower right front; all-zero s/n.\\t—\\t—\\t—\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"B102 (P2): 10 florin (withdrawn)\\tVG\\tVF\\tUNC\\n\" +\n" +
                "                \"Green and rust. Front: Papiamento text; flag; Palm Beach’s Aruba Sheraton Hotel and the Aruba Caribbean Hotel; windmill; sail boats. Back: Dutch text; coat of arms; prohibition against counterfeiting. No security thread. Watermark: None. Printer: JOH. ENSCHEDÉ EN ZONEN. 155 x 66 mm. Paper.\\n\" +\n" +
                "                \"\\ta.\\t1 JANUARI 1986. Sig. 1: Driessen/Mansur. 600,000 notes.\\t3\\t11\\t45\\n\" +\n" +
                "                \"\\tas.\\tDiagonal red SPECIMEN ovpt front/back;\\n\" +\n" +
                "                \"horizontal black SPECIMEN No. # ovpt lower right front; all-zero s/n.\\t—\\t—\\t—\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"B103 (P3): 25 florin (withdrawn)\\tVG\\tVF\\tUNC\\n\" +\n" +
                "                \"Green and rust. Front: Papiamento text; flag; Palm Beach’s Aruba Sheraton Hotel and the Aruba Caribbean Hotel; windmill; sail boats. Back: Dutch text; coat of arms; prohibition against counterfeiting. No security thread. Watermark: None. Printer: JOH. ENSCHEDÉ EN ZONEN. 155 x 66 mm. Paper.\\n\" +\n" +
                "                \"\\ta.\\t1 JANUARI 1986. Sig. 1: Driessen/Mansur. 250,000 notes.\\t4\\t16\\t65\\n\" +\n" +
                "                \"\\tas.\\tDiagonal red SPECIMEN ovpt front/back;\\n\" +\n" +
                "                \"horizontal black SPECIMEN No. # ovpt lower right front; all-zero s/n.\\t—\\t—\\t—\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"B104 (P4): 50 florin (withdrawn)\\tVG\\tVF\\tUNC\\n\" +\n" +
                "                \"Green and rust. Front: Papiamento text; flag; Palm Beach’s Aruba Sheraton Hotel and the Aruba Caribbean Hotel; windmill; sail boats. Back: Dutch text; coat of arms; prohibition against counterfeiting. No security thread. Watermark: None. Printer: JOH. ENSCHEDÉ EN ZONEN. 155 x 66 mm. Paper.\\n\" +\n" +
                "                \"\\ta.\\t1 JANUARI 1986. Sig. 1: Driessen/Mansur. 250,000 notes.\\t5\\t20\\t85\\n\" +\n" +
                "                \"\\tas.\\tDiagonal red SPECIMEN ovpt front/back;\\n\" +\n" +
                "                \"horizontal black SPECIMEN No. # ovpt lower right front; all-zero s/n.\\t—\\t—\\t—\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"B105 (P5): 100 florin (withdrawn)\\tVG\\tVF\\tUNC\\n\" +\n" +
                "                \"Green and rust. Front: Papiamento text; flag; Palm Beach’s Aruba Sheraton Hotel and the Aruba Caribbean Hotel; windmill; sail boats. Back: Dutch text; coat of arms; prohibition against counterfeiting. No security thread. Watermark: None. Printer: JOH. ENSCHEDÉ EN ZONEN. 155 x 66 mm. Paper.\\n\" +\n" +
                "                \"\\ta.\\t1 JANUARI 1986. Sig. 1: Driessen/Mansur. 800,000 notes.\\t9\\t35\\t140\\n\" +\n" +
                "                \"\\tas.\\tDiagonal red SPECIMEN ovpt front/back;\\n\" +\n" +
                "                \"horizontal black SPECIMEN No. # ovpt lower right front; all-zero s/n.\\t—\\t—\\t—\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\n\";";
        //List<String> bigBlockArrayList = multipleIssuesConversion(allText);

    }

    public static List<String> multipleIssuesConversion(String allText)
    {
        String[] bigBlockSplit = allText.split("\n\n\n");
        List<String> bigBlockArrayList = new ArrayList<String>();
        for(String x: bigBlockSplit)
        {
            bigBlockArrayList.add(x);
        }
        bigBlockArrayList.remove(0);
        for(int i = 0; i< bigBlockArrayList.size();i++)
        {
            if(i>0)
            {
                bigBlockArrayList.set(i,bigBlockArrayList.get(i).replaceFirst("\n",""));
            }
            //System.out.println(bigBlockArrayList.get(i));
        }
        return bigBlockArrayList;
    }
    public static String[] issueInto3StringConversion(String allText)
    {
        //returns three strings in order: colorLine, BNBNumberLine, varietyContent
        String allTextForVariety = allText;
        String[] allTextSplit = allText.split("\n");
        String[] allTextSplitVariety = allTextForVariety.split("Paper.\n");
        String colorLine = allTextSplit[1];
        String BNBNumberLine = allTextSplit[0];
        BNBNumberLine = BNBNumberLine.replaceAll("\tVG\tVF\tUNC","");
        String tempC = BNBNumberLine;
        for(int i = 18; i<tempC.length();i++)
        {
            Character c = tempC.charAt(i);
            if(c.equals('('))
            {
                tempC = tempC.substring(0,i);
                break;
            }
        }
        //this next line is used to remove (withdrawn) or (US $1.00) in the BNBNumberLine. Comment or uncomment to toggle.
        BNBNumberLine = tempC;
        String varietyContent = allTextSplitVariety[1];
        varietyContent = varietyContent.replaceFirst("\t","");
        String[] threeStrings = {colorLine,BNBNumberLine,varietyContent};
        return threeStrings;
    }
}
