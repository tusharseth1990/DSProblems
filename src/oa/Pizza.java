package oa;

public class Pizza {
    private String name;
    private Integer priceSmall;
    private Integer priceMedium;
    private Integer priceLarge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriceSmall() {
        return priceSmall;
    }

    public void setPriceSmall(Integer priceSmall) {
        this.priceSmall = priceSmall;
    }

    public Integer getPriceMedium() {
        return priceMedium;
    }

    public void setPriceMedium(Integer priceMedium) {
        this.priceMedium = priceMedium;
    }

    public Integer getPriceLarge() {
        return priceLarge;
    }

    public void setPriceLarge(Integer priceLarge) {
        this.priceLarge = priceLarge;
    }
}
