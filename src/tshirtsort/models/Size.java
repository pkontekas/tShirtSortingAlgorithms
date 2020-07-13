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

    public double getSizePrice(Size size) {
        double result = 0;
        switch (size) {
            case XS:
                result = 0.22;
                break;
            case S:
                result = 0.23;
                break;
            case M:
                result = 0.25;
                break;
            case L:
                result = 0.30;
                break;
            case XL:
                result = 0.35;
                break;
            case XXL:
                result = 0.40;
                break;
            case XXXL:
                result = 0.60;
                break;
        }
        return result;
    }
}
