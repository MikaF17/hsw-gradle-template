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
        for (int i = 10; i<=35; i++){
            char current = (char) ('A' + (i-10));
            char currentSmall = (char) ('a' + (i-10));
            if(IBANnumber.contains(String.valueOf(current)) || IBANnumber.contains(String.valueOf(currentSmall))){
                IBANnumber = IBANnumber.replace(String.valueOf(current), String.valueOf(i));
                IBANnumber = IBANnumber.replace(String.valueOf(currentSmall), String.valueOf(i));
            }
        }
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
