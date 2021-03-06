//BNBNumber	Date	Denomination	Variety	NoteColor	FrontDesc	BackDesc	Watermark	Printer	NoteDimension	PickNumber
public class FormattingObject {
    public String BNBNumber;
    public String Date;
    public String Denomination;
    public String Variety;
    public String NoteColor;
    public String FrontDesc;
    public String BackDesc;
    public String Watermark;
    public String Printer;
    public String NoteDimension;
    public String PickNumber;

    public FormattingObject(String BNBNumber, String Date, String Denomination, String Variety, String NoteColor, String FrontDesc, String BackDesc, String Watermark, String Printer, String NoteDimension, String PickNumber) {
        this.BNBNumber = BNBNumber;
        this.Date = Date;
        this.Denomination = Denomination;
        this.Variety = Variety;
        this.NoteColor = NoteColor;
        this.FrontDesc = FrontDesc;
        this.BackDesc = BackDesc;
        this.Watermark = Watermark;
        this.Printer = Printer;
        this.NoteDimension = NoteDimension;
        this.PickNumber = PickNumber;
    }
    @Override
    public String toString()
    {
        return "BNBNumber: " + BNBNumber + "| Date: " + Date + "| Denomination: " + Denomination + "| Variety: " + Variety + "| NoteColor: " + NoteColor + "| FrontDesc: " + FrontDesc + "| BackDesc: " + BackDesc + "| Watermark: " + Watermark + "| " +
                "Printer: " + Printer + "| NoteDimension: " + NoteDimension + "| PickNumber: " + PickNumber + "|";
    }

    public String getBNBNumber() {
        return BNBNumber;
    }
    public String getDenomination()
    {
        return Denomination;
    }
    public String getVariety()
    {
        return Variety;
    }
    public String getNoteColor()
    {
        return NoteColor;
    }
    public String getFrontDesc()
    {
        return FrontDesc;
    }
    public String getBackDesc()
    {
        return BackDesc;
    }
    public String getWatermark()
    {
        return Watermark;
    }
    public String getPrinter()
    {
        return Printer;
    }
    public String getNoteDimension()
    {
        return NoteDimension;
    }
    public String getPickNumber()
    {
        return PickNumber;
    }

}
