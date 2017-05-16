package result;

import calculator.FlatRoof;
import calculator.LiftedRoof;
import classes.Material;
import java.util.ArrayList;

import classes.Material;
import java.util.ArrayList;

/**
 *
 * @author vfgya_000
 */


public class Calculator {
    
    calculator.FlatRoof f = new FlatRoof();
    calculator.LiftedRoof l = new LiftedRoof();
    

    public void calculateResultLifted(ArrayList<Material> list, int length, int width, int angle, boolean skur, int skurlength, int skurwidth) {
        for (int i = 0; i < list.size(); i++) {
            if (skur == true) {
                // id 17
                if (i == 0) {
                    list.get(i).setLength(l.vindskeder(width, angle));
                    list.get(i).setAmount(l.vindskedeAntal(width, angle));
                }
                // id 18
                if (i == 1) {
                    list.get(i).setLength(l.sternSide(length));
                    list.get(i).setAmount(l.sternSideAntal());
                }
                // id 19 - ???
                if (i == 2) {
                   // list.get(i).setLength();
                   // list.get(i).setAmount();
                }
                // id 20
                if (i == 3) {
                    list.get(i).setAmount(l.færdigByggetAntal());
                }
                // id 21
                if (i == 4) {
                    list.get(i).setLength(l.stolperLength());
                    list.get(i).setAmount(l.stolperAntal(skur));
                }
                // id 22
                if (i == 5) {
                    list.get(i).setLength(l.remme(length));
                    list.get(i).setAmount(l.remmeAntal());
                }
                // id 23
                if (i == 6) {
                    list.get(i).setLength(l.remmeSkur(skurlength));
                    list.get(i).setAmount(l.remmeSkurAntal());
                }
                // id 24
                if (i == 7) {
                    list.get(i).setLength(l.løsholterSide(skurlength));
                    list.get(i).setAmount(l.løsholterSideAntal());
                }
                // id 25
                if (i == 8) {
                    list.get(i).setLength(l.løsholterGavle(skurwidth));
                    list.get(i).setAmount(l.løsholterGavleAntal());
                }
                // id 26
                if (i == 9) {
                    list.get(i).setLength(l.vandbræt(width, angle));
                    list.get(i).setAmount(l.vandbrætAntal(width, angle));
                }
                // id 27
                if (i == 10) {
                    list.get(i).setLength(l.gavlLength(width));
                    list.get(i).setAmount(l.gavlAntal(width));
                }
                // id 28 - antal?
                if (i == 11) {
                    list.get(i).setLength(l.beklædningSkur(skurlength, skurwidth));
                }
                // id 29
                if (i == 12) {
                    list.get(i).setLength(l.brætOverTagfodslægte());
                    list.get(i).setAmount(l.brætOverAntal());
                }
                // id 30
                if (i == 13) {
                    list.get(i).setLength(l.brætBagdør());
                    list.get(i).setAmount(l.brætBagdørAntal());
                }
                // id 31
                if (i == 14) {
                   // list.get(i).setLength(l.);
                }
                // deletes all flat roof materials
                if (list.get(i).getId() >= 50 && list.get(i).getId() <= 63) {
                    for (int j = 0; j <= 13; j++)
                        list.remove(i);
                }
                
               
            } else {
                // id 17
                if (i == 0) {
                    list.get(i).setLength(l.vindskeder(width, angle));
                    list.get(i).setAmount(l.vindskedeAntal(width, angle));
                }
                // id 18
                if (i == 1) {
                    list.get(i).setLength(l.sternSide(length));
                    list.get(i).setAmount(l.sternSideAntal());
                }
                // id 19 - ???
                if (i == 2) {
                    list.remove(i);
                }
                // id 20
                if (i == 3) {
                    list.get(i).setAmount(l.færdigByggetAntal());
                }
                // id 21
                if (i == 4) {
                    list.get(i).setLength(l.stolperLength());
                    list.get(i).setAmount(l.stolperAntal(skur));
                }
                // id 22
                if (i == 5) {
                    list.get(i).setLength(l.remme(length));
                    list.get(i).setAmount(l.remmeAntal());
                }
                // id 23
                if (i == 6) {
                    list.remove(i);
                }
                // id 24
                if (i == 7) {
                    list.remove(i);
                }
                // id 25
                if (i == 8) {
                    list.remove(i);
                }
                // id 26
                if (i == 9) {
                    list.get(i).setLength(l.vandbræt(width, angle));
                    list.get(i).setAmount(l.vandbrætAntal(width, angle));
                }
                // id 27
                if (i == 10) {
                    list.get(i).setLength(l.gavlLength(width));
                    list.get(i).setAmount(l.gavlAntal(width));
                }
                // id 28 - antal?
                if (i == 11) {
                    list.remove(i);
                }
                // id 29
                if (i == 12) {
                    list.get(i).setLength(l.brætOverTagfodslægte());
                    list.get(i).setAmount(l.brætOverAntal());
                }
                // id 30
                if (i == 13) {
                    list.get(i).setLength(l.brætBagdør());
                    list.get(i).setAmount(l.brætBagdørAntal());
                }
                // id 31
                if (i == 14) {
                    list.get(i).setLength(2);
                }
                if (list.get(i).getId() >= 50 && list.get(i).getId() <= 63) {
                    for (int j = 0; j <= 13; j++)
                        list.remove(i);
                }
            }
        }
    }

    public void calculateResultFlat(ArrayList<Material> list, int length, int width, boolean skur, int skurlength, int skurwidth) {
        for (int i = 0; i < list.size(); i++) {
            if (skur == true) {
                if (i == 1) {
                   // list.get(i).setLength();
                    //list.get(i).setAmount();
                }
            } else if (skur == false) {

            }
        }
    }
}
