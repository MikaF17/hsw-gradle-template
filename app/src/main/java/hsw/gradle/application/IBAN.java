package hsw.gradle.application;
import java.math.BigInteger;

public class IBAN {
    private final String IBANnumber;

    IBAN(String IBANnumber) {
        this.IBANnumber = IBANnumber;
    }

    public boolean check(String IBANnumber) {
        // explanation source: https://de.wikipedia.org/wiki/Internationale_Bankkontonummer#Prüfsumme
        // step 1: IBAN needs to be 18 digits long
        //System.out.println(IBANnumber.length());

        IBANnumber = this.IBANnumber;

        if(IBANnumber.length() != 22) {
            return false;
        }

        if(!IBANnumber.substring(0,2).equalsIgnoreCase("DE")){
            return false;
        }
        //System.out.println(IBANnumber);

        // step 2: move first 4 digits to the end
        String substring1 = IBANnumber.substring(0, 4);
        String substring2 = IBANnumber.substring(4);

        IBANnumber = substring2 + substring1;
        //System.out.println(IBANnumber);

        // step 3: replace characters by digits
        IBANnumber = IBANnumber.replace("A", "10");
        IBANnumber = IBANnumber.replace("B", "11");
        IBANnumber = IBANnumber.replace("C", "12");
        IBANnumber = IBANnumber.replace("D", "13");
        IBANnumber = IBANnumber.replace("E", "14");
        IBANnumber = IBANnumber.replace("F", "15");
        IBANnumber = IBANnumber.replace("G", "16");
        IBANnumber = IBANnumber.replace("H", "17");
        IBANnumber = IBANnumber.replace("I", "18");
        IBANnumber = IBANnumber.replace("J", "19");
        IBANnumber = IBANnumber.replace("K", "20");
        IBANnumber = IBANnumber.replace("L", "21");
        IBANnumber = IBANnumber.replace("M", "22");
        IBANnumber = IBANnumber.replace("N", "23");
        IBANnumber = IBANnumber.replace("O", "24");
        IBANnumber = IBANnumber.replace("P", "25");
        IBANnumber = IBANnumber.replace("Q", "26");
        IBANnumber = IBANnumber.replace("R", "27");
        IBANnumber = IBANnumber.replace("S", "28");
        IBANnumber = IBANnumber.replace("T", "29");
        IBANnumber = IBANnumber.replace("U", "30");
        IBANnumber = IBANnumber.replace("V", "31");
        IBANnumber = IBANnumber.replace("W", "32");
        IBANnumber = IBANnumber.replace("X", "33");
        IBANnumber = IBANnumber.replace("Y", "34");
        IBANnumber = IBANnumber.replace("Z", "35");
        //System.out.println(IBANnumber);

        BigInteger IBANnumberBigInt = new BigInteger(IBANnumber);
        BigInteger modulo = new BigInteger("97");

        // Long IBANnumberLong = Long.parseLong(IBANnumber);
        IBANnumberBigInt = IBANnumberBigInt.mod(modulo);
        //System.out.println(IBANnumberBigInt);

        if(IBANnumberBigInt.intValue() == 1) {
            return true;
        } else {
            return false;
        }
    }
}
