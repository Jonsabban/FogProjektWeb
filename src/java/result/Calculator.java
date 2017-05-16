package result;

import calculator.FlatRoof;
import calculator.LiftedRoof;
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
                // id 19 
                if (i == 2) {
                   list.get(i).setLength(l.sternSideSkur(length));
                   list.get(i).setAmount(l.sternSideSkurAntal());
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
                // id 28
                if (i == 11) {
                    list.get(i).setLength(l.beklædningSkur());
                    list.get(i).setAmount(l.beklædningSkurAntal(skurlength, skurwidth));
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
                   list.get(i).setLength(l.taglægterSpær(length));
                   list.get(i).setAmount(l.taglægterSpærAntal(length, width, angle));
                }
                // id 32
                if (i == 15){
                    list.get(i).setLength(l.toplægte(length));
                    list.get(i).setAmount(l.toplægteAntal(length));
                }
                // id 33
                if (i == 16){
                    list.get(i).setAmount(l.dobbelt(length, width, angle));
                }
                // id 34
                if (i == 17){
                    list.get(i).setAmount(l.rygsten(length));
                }
                // id 35
                if (i == 18){
                    list.get(i).setAmount(l.toplægteHolder(length));
                }
                // id 36
                if (i == 19){
                    list.get(i).setAmount(l.rygstensBeslag(length));
                }
                // id 37
                if (i == 20){
                    
                    list.get(i).setAmount(l.bindereOgNakkekroge());
                }
                // id 38
                if (i == 21){
                    list.get(i).setAmount(l.skruerSpærH(length));
                }
                // id 39
                if (i == 22){
                    list.get(i).setAmount(l.skruerSpærV(length));
                }
                // id 40
                if (i == 23){
                    list.get(i).setAmount(l.stalddørsGreb());
                }
                // id 41
                if (i == 24){
                    list.get(i).setAmount(l.tHængsel());
                }
                // id 42
                if (i == 25){
                    list.get(i).setAmount(l.vinkelbeslag());
                }
                // id 43
                if (i == 26){
                    list.get(i).setAmount(l.skruer());
                }
                // id 44
                if (i == 27){
                    list.get(i).setAmount(l.beslagsSkruer());
                }
                // id 45
                if (i == 28){
                    list.get(i).setAmount(l.taglægterSkruerPakker(length, width, angle));
                }
                // id 46
                if (i == 29){
                    list.get(i).setAmount(l.bræddebolte());
                }
                // id 47
                if (i == 30){
                    list.get(i).setAmount(l.firkantskiver());
                }
                // id 48 
                if (i == 31){
                    list.get(i).setAmount(l.yderBeklædPakker(length, width, angle));
                }
                // id 49
                if (i == 32){
                    list.get(i).setAmount(l.inderBeklædPakker(length, width, angle));
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
                // id 19
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
                // id 28
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
                   list.get(i).setLength(l.taglægterSpær(length));
                   list.get(i).setAmount(l.taglægterSpærAntal(length, width, angle));
                }
                // id 32
                if (i == 15){
                    list.get(i).setLength(l.toplægte(length));
                    list.get(i).setAmount(l.toplægteAntal(length));
                }
                // id 33
                if (i == 16){
                    list.get(i).setAmount(l.dobbelt(length, width, angle));
                }
                // id 34
                if (i == 17){
                    list.get(i).setAmount(l.rygsten(length));
                }
                // id 35
                if (i == 18){
                    list.get(i).setAmount(l.toplægteHolder(length));
                }
                // id 36
                if (i == 19){
                    list.get(i).setAmount(l.rygstensBeslag(length));
                }
                // id 37
                if (i == 20){
                    
                    list.get(i).setAmount(l.bindereOgNakkekroge());
                }
                // id 38
                if (i == 21){
                    list.get(i).setAmount(l.skruerSpærH(length));
                }
                // id 39
                if (i == 22){
                    list.get(i).setAmount(l.skruerSpærV(length));
                }
                // id 40
                if (i == 23){
                    list.remove(i);
                }
                // id 41
                if (i == 24){
                    list.remove(i);
                }
                // id 42
                if (i == 25){
                    list.remove(i);
                }
                // id 43
                if (i == 26){
                    list.get(i).setAmount(l.skruer());
                }
                // id 44
                if (i == 27){
                    list.get(i).setAmount(l.beslagsSkruer());
                }
                // id 45
                if (i == 28){
                    list.get(i).setAmount(l.taglægterSkruerPakker(length, width, angle));
                }
                // id 46
                if (i == 29){
                    list.get(i).setAmount(l.bræddebolte());
                }
                // id 47
                if (i == 30){
                    list.get(i).setAmount(l.firkantskiver());
                }
                // id 48 
                if (i == 31){
                    list.get(i).setAmount(l.yderBeklædPakker(length, width, angle));
                }
                // id 49
                if (i == 32){
                    list.get(i).setAmount(l.inderBeklædPakker(length, width, angle));
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
                
                // id 30
                if (i == 0){
                    list.get(i).setLength(l.brætBagdør());
                    list.get(i).setAmount(l.brætBagdørAntal());
                }
                // id 50
                if (i == 1) {
                   list.get(i).setLength(f.understernFB(width));
                   list.get(i).setAmount(f.understernFBAntal());
                }
                // id 51
                if (i == 2){
                    list.get(i).setLength(f.understernSide(length));
                    list.get(i).setAmount(f.understernSideAntal());
                }
                // id 52
                if (i == 3){
                    list.get(i).setLength(f.oversternF(width));
                    list.get(i).setAmount(f.oversternFAntal());
                }
                // id 53
                if (i == 3){
                    list.get(i).setLength(f.oversternSide(length));
                    list.get(i).setAmount(f.oversternSideAntal());
                }
                
            } else if (skur == false) {

            }
        }
    }
}
