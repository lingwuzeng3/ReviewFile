package midterm;

public class Stock {
    String symbol;
    String name;
    double previousCloingPrice;
    double currentPrice;

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public void setPreviousCloingPrice(double previousCloingPrice) {
        this.previousCloingPrice = previousCloingPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getChangePercent() {
        double rate = (currentPrice - previousCloingPrice) / previousCloingPrice;
        return String.format("%.2f%%",rate*100);
    }

    public static void main(String... args) {
        Stock s = new Stock("ORCL", "Oracle Corporation");
        s.setPreviousCloingPrice(34.5);
        s.setCurrentPrice(34.35);
        System.out.print("市值变化的百分比为: ");
        System.out.println(s.getChangePercent());
    }

}
