import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;

public class initialScript {
    public static void main(String[] args) {
        //Below section prints out the called function "fillAllExceptVarietyAndDate", which extracts all data except
        //the Variety and Date of a given input section of the catalog.
        //LIST OF ISSUES IN SCRIPT OUTPUT IF LEFT IN initialText3:
        //- if decimals in monetary value in variety section, just remove the periods in between, as they cause issues in splitting
        //- try to solve decimals issue automatically, possibly by only splitting at moments where there is an alphabetic character before a period
        //- as opposed to int + "." + int.
        //- encoding issues: try to use UTF-16 with next .csv and within this script. if issue persists, ctrl+f find&replace with
        //character key in top of .txt file.
        //THINGS TO CLEAN IN .txt FILE BEFORE RUNNING:
        //- NO DECIMALS IN PRICES
        //- MAKE SURE THE END OF colorLine is strictly "Paper.", not "Paper (pink). AN EXTRA SPACE AFTER "Paper." BREAKS THE CODE.
        //- NO SPACES BETWEEN MULTIPLE PICK NUMBERS
        //- 3 LINE SPACES BETWEEN EACH ISSUE, AT FRONT AND BACK
        //- MAKE SURE IF ISSUE HAS A DEMONETIZED DATE, THAT IT IS ON SAME LINE AS EVERYTHING
        //
        String multipleIssues = "";
        List<String> bigBlockArrayList = initialScriptTesting.multipleIssuesConversion(multipleIssues);
        System.out.println(bigBlockArrayList.size());
        for(int i = 0; i< bigBlockArrayList.size();i++)
        {
            writeOneIssue(bigBlockArrayList.get(i));
        }

    }

    public static void writeOneIssue(String oneIssueText)
    {
        String BNBNumberLine = ""; //BNBNumberLine, etc.
        String colorLine = ""; //colorLine
        //Workspace for trying to automate variety/date section
        String varietyContent = ""; //Variety Contents
        String allText = oneIssueText;
        //make sure when doing multiple issues at a time that there are 3 line spacers, or "\n\n\n", in between each issue, and
        //before and after the first and last issue.
        String[] threeStrings = initialScriptTesting.issueInto3StringConversion(allText);
        BNBNumberLine = threeStrings[1];
        colorLine = threeStrings[0];
        varietyContent = threeStrings[2];
        FormattingObject readout = fillAllExceptVarietyAndDate(BNBNumberLine,colorLine);
        ArrayList<VarietyFormattingObject> readout2 = varietyAndDate(varietyContent);


        List<String[]> csvData = createCsvDataSpecial(readout,readout2);

        String[] filler = {""};
        try (CSVWriter writer = new CSVWriter(new FileWriter("/Users/aidenf/IdeaProjects/CDNSummerProject2021/src/filename.csv",true))) //append version is "file.csv".concat(""),true
        {
            writer.writeNext(filler);
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FormattingObject fillAllExceptVarietyAndDate(String BNBNumberLine, String colorLine)
    {
        String[] words = colorLine.split("\\.");
        String[] words2 = BNBNumberLine.split(":"); //splitting the BNBNumber and PickNumber together, with the Denomination
        String[] words2a = words2[0].split(" "); //splitting the BNBNumber and PickNumber
        String truePrinter = "", trueWatermark = "", trueNoteDimension = "";
        for(int i = 0; i<words.length;i++)
        {
            if(words[i].contains("Printer"))
            {
                truePrinter = words[i];
            }
            else if(words[i].contains("Watermark"))
            {
                trueWatermark = words[i];
            }
            else if(truePrinter!="" && i!=words.length-2 && i!=words.length-1)
            {
                truePrinter = truePrinter + " " + words[i];
            }
            trueNoteDimension = words[words.length-2];

        }
        FormattingObject temp =  new FormattingObject(words2a[0],"FILL IN",words2[1],"FILL IN",words[0],words[1],words[2],trueWatermark,truePrinter,trueNoteDimension,words2a[1]);
        //System.out.println(temp.getNoteDimension());
        return temp;
    }
    public static ArrayList<VarietyFormattingObject> varietyAndDate(String varietyContent)
    {
        String words[] = varietyContent.split("\t");
        for(int i = 0; i< words.length;i++)
        {
            //System.out.println(words[i]);
        }
        ArrayList<String> varietyContents = new ArrayList<String>();
        for(int i = 0; i<words.length; i++)
        {
            String currentLine = words[i];
            if(currentLine.contains("."))
            {
                varietyContents.add(currentLine);
            }
        }
        for(int i = 0; i<varietyContents.size();i++)
        {
            //System.out.println(varietyContents.get(i));
        }
        ArrayList<String> finalizedVarietyItems = new ArrayList<String>();
        String currentLineToAdd = "";
        //System.out.println(varietyContents.get(32).length());
        for(int i = 0; i<varietyContents.size(); i++)
        {
            if(i==varietyContents.size()-2)
            {
                //System.out.println(varietyContents.get(i));
            }
            else if(varietyContents.get(i).length()<5)
            {
                finalizedVarietyItems.add(currentLineToAdd);
                currentLineToAdd = "";
                currentLineToAdd = varietyContents.get(i);
            }
            else
            {
                currentLineToAdd = currentLineToAdd + " " + varietyContents.get(i);
            }

            //make VarietyFormattingObject with variety and BNBNumberType (ex: B101a, where the "a" is the BNBNumberType, and variety being the variety)
        }
        for(int i = 0; i< finalizedVarietyItems.size();i++)
        {
            //System.out.println(finalizedVarietyItems.get(i));
        }
        finalizedVarietyItems.remove(0);
        ArrayList<String> actualFinalList = new ArrayList<String>();
        for(int i = 0; i< varietyContents.size();i++)
        {
            String newStringWithoutLineSpacers = varietyContents.get(i).replaceAll("[\\n\\t ]", " ");
            varietyContents.set(i,newStringWithoutLineSpacers);
            //System.out.println(varietyContents.get(i) + "| i index: " + i);

            //fixed t not showing up. still need to fix formatting with split, so that the BNBNumberType and Variety
            //get correctly split and can be filtered into the varietyFormattingObjectArray.
        }
        for(int i = 0; i< varietyContents.size();i++)
        {
            //System.out.println(varietyContents.get(i)); //looks good here
        }
        String tempo = "";
        for(int k = 0; k<varietyContents.size();k++)
        {
            if(k%2==0 || k==0)
            {
                tempo = varietyContents.get(k);
            }
            else
            {
                tempo += varietyContents.get(k);
                actualFinalList.add(tempo);
            }
        }
        for(int l = 0; l<actualFinalList.size();l++)
        {
            //System.out.println(actualFinalList.get(l));
        }
        //System.out.println(actualFinalList.size());
        ArrayList<VarietyFormattingObject> currentVarietyItems = new ArrayList<VarietyFormattingObject>();
        for(int i = 0; i< actualFinalList.size();i++)
        {
            String varietyTemp = "";
            String[] varietyFormattingObjectArray = actualFinalList.get(i).split("\\.");
            for(int j = 1; j<varietyFormattingObjectArray.length;j++)
            {
                varietyTemp += varietyFormattingObjectArray[j] + " ";
            }
            VarietyFormattingObject temp = new VarietyFormattingObject(varietyTemp,varietyFormattingObjectArray[0]);
            currentVarietyItems.add(temp);
        }
        for(int i = 0; i<currentVarietyItems.size();i++)
        {
            String temp3 = currentVarietyItems.get(i).toString();
            //System.out.println(temp3);
        }
        return currentVarietyItems;
    }

    public static List<String[]> createCsvDataSpecial(FormattingObject readout, ArrayList<VarietyFormattingObject> readout2)
    {
        ArrayList<FormattingObject> finalObjectsWithAllData = new ArrayList<FormattingObject>();
        for(int i = 0; i< readout2.size();i++)
        {
            FormattingObject objectToAdd = new FormattingObject(readout.getBNBNumber()+readout2.get(i).getBNBNumberType(),
                    "FILL IN",readout.getDenomination(),readout2.get(i).getVariety(),readout.getNoteColor(),readout.getFrontDesc(),
                    readout.getBackDesc(),readout.getWatermark(),readout.getPrinter(),readout.getNoteDimension(),readout.getPickNumber());
            finalObjectsWithAllData.add(objectToAdd);
        }
        //BNBNumber	Date	Denomination	Variety	NoteColor	FrontDesc	BackDesc	Watermark	Printer	NoteDimension	PickNumber
        String[] header = {"BNBNumber", "Date", "Denomination", "Variety","NoteColor","FrontDesc","BackDesc","Watermark","Printer","NoteDimension","PickNumber"};
        List<String[]> list = new ArrayList<String[]>();
        //list.add(header);
        for(int i = 0; i< finalObjectsWithAllData.size();i++)
        {
            String fixedFront, fixedBack, fixedWatermark, fixedPrinter, fixedPickNumber = "";
            fixedFront = readout.getFrontDesc().replaceAll("Front: ","");
            fixedBack = readout.getBackDesc().replaceAll("Back: ","");
            fixedWatermark = readout.getWatermark().replaceAll("Watermark: ","");
            fixedPrinter = readout.getPrinter().replaceAll("Printer: ","");
            fixedPickNumber = readout.getPickNumber().replaceAll("[()]","");
            FormattingObject objectToWrite = finalObjectsWithAllData.get(i);
            String[] listStringToAdd = {readout.getBNBNumber()+readout2.get(i).getBNBNumberType(),
                    "FILL IN",readout.getDenomination(),readout2.get(i).getVariety(),readout.getNoteColor(),fixedFront,
                    fixedBack,fixedWatermark,fixedPrinter,readout.getNoteDimension(),fixedPickNumber};
            list.add(listStringToAdd);
        }
        return list;

    }
}
