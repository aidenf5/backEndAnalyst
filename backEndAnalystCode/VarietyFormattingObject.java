public class VarietyFormattingObject {
    public String Variety;
    public String BNBNumberType;

    public VarietyFormattingObject(String Variety, String BNBNumberType)
    {
        this.Variety = Variety;
        this.BNBNumberType = BNBNumberType;
    }
    @Override
    public String toString()
    {
        return "Variety: " + Variety + "| BNBNumberType: " + BNBNumberType + "|";
    }
    public String getBNBNumberType()
    {
        return BNBNumberType;
    }
    public String getVariety()
    {
        return Variety;
    }

}
