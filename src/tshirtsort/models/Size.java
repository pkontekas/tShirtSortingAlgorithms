package tshirtsort.models;

/**
 * @author pkontekas
 */

/*
       .22 .23 .25 .30 .35 .45   .60  
Size, {XS, S,   M, L,  XL, XXL, XXXL}
 */
public enum Size {
    XS, S, M, L, XL, XXL, XXXL;

    static {
        XS.price = 0.22;
        S.price = 0.23;
        M.price = 0.25;
        L.price = 0.30;
        XL.price = 0.35;
        XXL.price = 0.45;
        XXL.price = 0.60;
    }

    private double price;

    public double getPrice() {
        return price;
    }
}
