package calculator;


public class LiftedRoof {
    
    public double A;
    
    //Calculates materials for carport with lifted roof.
   
        //Vindskede
        public int vindskeder(int width, int angle)
        {
            double angleToRadian = Math.toRadians(angle);
            int vindskeder = 0;
            double sideB = (double) width / 2;
            double sideA = Math.tan(angleToRadian) * sideB; 
            double hypotenuse = Math.sqrt((sideB * sideB) + (sideA * sideA));
        
            if (hypotenuse * 2 <= 360) {
                vindskeder = 420;
            }
        
            if (hypotenuse * 2 > 360 && hypotenuse * 2 <= 420) {
                vindskeder = 480;
            }
        
            if (hypotenuse * 2 > 420 && hypotenuse * 2 <= 480) {
                vindskeder = 540;
            }
        
            if (hypotenuse * 2 > 480 && hypotenuse * 2 <= 540) {
                vindskeder = 420;
            }
        
            if (hypotenuse * 2 > 540 && hypotenuse * 2 <= 600) {
                vindskeder = 480;
            }
        
            if (hypotenuse * 2 > 600 && hypotenuse * 2 <= 660) {
                vindskeder = 540;
            }
            return vindskeder;
        }
        
        //Hypotenuse til plantegning
        public static double hypotenuse(int width, int angle)
        {
            double angleToRadian = Math.toRadians(angle);
            int vindskeder = 0;
            double sideB = (double) width / 2;
            double sideA = Math.tan(angleToRadian) * sideB; 
            double hypotenuse = Math.sqrt((sideB * sideB) + (sideA * sideA));
            return sideA;
        }
        
        public int vindskedeAntal(int width, int angle){
            int vindskedeAntal = 2;
            double angleToRadian = Math.toRadians(angle);
            int vindskeder = 0;
            double sideB = (double) width / 2;
            double sideA = Math.tan(angleToRadian) * sideB; 
            double hypotenuse = Math.sqrt((sideB * sideB) + (sideA * sideA));
            if (hypotenuse > 480){
                vindskedeAntal += 2;
            }
        // Used for blueprint
        A = sideA;
        return vindskedeAntal;    
        }
        
        
       
        
        //Stern
        public int sternSide(int length){
            int sternSide = length + 90;
            return sternSide;
        }

        public int sternSideAntal(){
         int sternSideAntal = 2;
         return sternSideAntal;
        }
        
        //Byg Selv Spær - Færdigskåret
        public int færdigByggetAntal(){
        int færdigByggetAntal = 1;
        return færdigByggetAntal;
        }
        
        public int antalSpær(int length){
        int antalSpær = (length/89) + 1;
        return antalSpær;
        }
        
        
        public int skruerSpærV(int length){
        int skruerSpærV = (length/89) + 1;
        return skruerSpærV;
        }
        public int skruerSpærH(int length){
        int skruerSpærH = (length/89) + 1;
        return skruerSpærH;
        }
        
        //Stolper
        public int stolperLength(){
        int stolper = 300;
        return stolper;
        }
        
        public int stolperAntal(boolean skur){
        int stolperAntal = 4;
        if (skur = true)
        {
            stolperAntal += 5; 
        }
        return stolperAntal;
        }
        
        
        //Remme
        public int remme(int length){
        int remme = length - 30;
        return remme;
        }
        
        public int remmeAntal(){
        int remmeAntal = 2;
        return remmeAntal;
        }
        
        
        //Vandbræt
        public int vandbræt(int width, int angle){
        int vandbræt = vindskeder(width, angle);
        return vandbræt;
        }
        
        public int vandbrætAntal(int width, int angle){
        int vandbrætAntal = vindskedeAntal(width, angle);
        return vandbrætAntal;
        }
        
        //Beklædning af gavle
        public int gavlAntal(int width){
        int gavlAntal = ((width / 10) / 2) + 2;
        return gavlAntal;
        }
        
        public int gavlLength(int width){
        double gavlCalc = ((width / 2) * 2) + 80;
        int gavlLength = 0;
        if (gavlCalc <= 180){
            gavlLength = 180;
        }
        if (gavlCalc > 180 && gavlCalc <= 210){
            gavlLength = 210;
        }
        if (gavlCalc > 210 && gavlCalc <= 240){
            gavlLength = 240;
        }
        if (gavlCalc > 240 && gavlCalc <= 270){
            gavlLength = 270;
        }
        if (gavlCalc > 270 && gavlCalc <= 300){
            gavlLength = 300;
        }
        if (gavlCalc > 300 && gavlCalc <= 360){
            gavlLength = 360;
        }
        if (gavlCalc < 360){
            gavlLength = 420;
        }
        return gavlLength;
        }
        //Taglægter
        public int taglægterRækker(int width, int angle){
        double angleToRadian = Math.toRadians(angle);
        double sideB = (double) width / 2;
        double sideA = Math.tan(angleToRadian) * sideB; 
        double hypotenuse = Math.sqrt((sideB * sideB) + (sideA * sideA));
        double taglægterRækker = (hypotenuse / 31) + 1;
        int taglægterRækkerInt = (int) taglægterRækker;
        return taglægterRækkerInt;
        }
        
        public int taglægterSpær(int length){
        int taglægterSpær = 0;
        if (length <= 300){
            taglægterSpær = 300;
        }
        if (length > 300 && length <= 330){
            taglægterSpær = 330;
        }
        if (length > 330 && length <= 360){
            taglægterSpær = 360;
        }
        if (length > 360 && length <= 390){
            taglægterSpær = 390;
        }
        if (length > 390 && length <= 420){
            taglægterSpær = 420;
        }
        if (length > 420 && length <= 450){
            taglægterSpær = 450;
        }
        if (length > 450 && length <= 480){
            taglægterSpær = 480;
        }
        if (length > 480 && length <= 510){
            taglægterSpær = 510;
        }
        if (length > 510 && length <= 540){
            taglægterSpær = 540;
        }
        if (length > 540 && length <= 600){
            taglægterSpær = 420;
        }
        if (length > 600 && length <= 660){
            taglægterSpær = 450;
        }
        if (length > 660 && length <= 720){
            taglægterSpær = 510;
        }
        if (length > 720 && length <= 780){
            taglægterSpær = 540;
        }
        return taglægterSpær; 
        }
        
        public int taglægterSpærAntal(int length, int width, int angle){
            double taglægterSpærAntal = taglægterRækker(width, angle);
            int taglægteSpær = taglægterSpær(length);
            if (taglægteSpær > 540){
            taglægterSpærAntal = taglægterSpærAntal * 1.5;
            }
            int taglægterSpærAntalInt = (int) taglægterSpærAntal;
            return taglægterSpærAntalInt;
        }
        
        //Toplægter
        public int toplægte(int length){
        int toplægte = 0;
        if (length <= 300){
            toplægte = 300;
        }
        if (length > 300 && length <= 330){
            toplægte = 360;
        }
        if (length > 330 && length <= 360){
            toplægte = 390;
        }
        if (length > 360 && length <= 390){
            toplægte = 420;
        }
        if (length > 390 && length <= 420){
            toplægte = 450;
        }
        if (length > 420 && length <= 450){
            toplægte = 480;
        }
        if (length > 450 && length <= 480){
            toplægte = 510;
        }
        if (length > 480 && length <= 510){
            toplægte = 540;
        }
        if (length > 510 && length <= 600){
            toplægte = 300;
        }
        if (length > 600 && length <= 660){
            toplægte = 360;
        }
        if (length > 660 && length <= 720){
            toplægte = 390;
        }
        if (length > 720 && length <= 780){
            toplægte = 420;
        }
        return toplægte;
        }
        
        public int toplægteAntal(int length){
            int toplægteAntal = 1;
            if (length > 510){
                toplægteAntal = 2;
            }
            return toplægteAntal;
        }
        
        //Tag
        public int dobbelt(int length, int width, int angle){ 
        int dobbelt = 0;
        int vindskeder = vindskedeAntal(width, angle);
        int dobbeltSide = length / 30; 
        if (vindskeder <= 240)
            {
            dobbelt = 3 * dobbeltSide;
                    }
        if (vindskeder > 240 && vindskeder <= 320)
            {
            dobbelt = 4 * dobbeltSide;
                    }
        if (vindskeder > 320 && vindskeder <= 400)
            {
            dobbelt = 5 * dobbeltSide;
                    }
        if (vindskeder > 400 && vindskeder <= 480)
            {
            dobbelt = 6 * dobbeltSide;
                    }
        if (vindskeder > 480 && vindskeder <= 560)
            {
            dobbelt = 7 * dobbeltSide;
                    }
        if (vindskeder > 560 && vindskeder <= 640)
            {
            dobbelt = 8 * dobbeltSide;
                    }
        if (vindskeder > 640 && vindskeder <= 720)
            {
            dobbelt = 9 * dobbeltSide;
                    }
        if (vindskeder > 720 && vindskeder <= 800)
            {
            dobbelt = 10 * dobbeltSide;
                    }
        return dobbelt;
        }
        
        public int rygsten(int length){
            int rygsten = length / 34;
            return rygsten;
        }
        
        public int toplægteHolder(int length){
            int toplægteHolder = (length/100) + 1;
            return toplægteHolder;
        }
        public int rygstensBeslag(int length){
            int rygstensBeslag = (length/100) + 1;
            return rygstensBeslag;
        }
        public int bindereOgNakkekroge(){
            int bindereOgNakkekroge = 2;
            return bindereOgNakkekroge;
        }
        
        //Skruer
        public int skruer(){
            int skruer = 1;
            return skruer;
        }
        public int beslagsSkruer(){
            int beslagsSkruer = 1;
            return beslagsSkruer;
        }
        
        public int taglægterSkruerPakker(int length, int width, int angle){
            int taglægterSpær = taglægterSpær(length);
            int taglægterSpærAntal = taglægterSpærAntal(length, width, angle);
            double taglægteTotal = taglægterSpær * taglægterSpærAntal;
            int taglægteSkruePakker = 0;
            int loopCount = 0;
            for(int i = 0; loopCount <= taglægteTotal; i++)
            {
                loopCount += 6000;
                taglægteSkruePakker++;
            }
        return taglægteSkruePakker;
        }
        public int inderBeklædPakker(int length, int width, int angle){
            int loopCount = 0;
            int inderBeklædPakker = 0;
            int taglægterSpær = taglægterSpær(length);
            int taglægterSpærAntal = taglægterSpærAntal(length, width, angle);
            double taglægteTotal = taglægterSpær * taglægterSpærAntal;
            int beklædningTotal = gavlLength(width) * gavlAntal(width);
            for(int i = 0; loopCount <= taglægteTotal; i++)
            {
                loopCount += 20100;
                inderBeklædPakker++;
            }
            return inderBeklædPakker;
        }
        
        public int yderBeklædPakker(int length, int width, int angle){
            int loopCount = 0;
            int taglægterSpær = taglægterSpær(length);
            int taglægterSpærAntal = taglægterSpærAntal(length, width, angle);
            double taglægteTotal = taglægterSpær * taglægterSpærAntal;
            int yderBeklædPakker = 0;
            for(int i = 0; loopCount <= taglægteTotal; i++)
            {
                loopCount += 13400;
                yderBeklædPakker++;
            } 
            return yderBeklædPakker;
        }
       
        public int remmeSkur(int skurLength){
           int remmeSkur = (skurLength + 10) * 2;
           return remmeSkur;
        }
        
        public int remmeSkurAntal(){
           int remmeSkurAntal = 1;
           return remmeSkurAntal;
        }
        
        public int løsholterSide(int skurLength){
           int løsholterSide = skurLength + 30;
           return løsholterSide;
        }
        
        public int løsholterSideAntal(){
           int løsholterSideAntal = 4;
           return løsholterSideAntal;
        }
        
        public int løsholterGavle(int skurWidth){
           int løsholterGavle = skurWidth;
           return løsholterGavle;
        }
        
        public int løsholterGavleAntal(){
           int løsholterGavleAntal = 6;
           return løsholterGavleAntal;
        }
        
        public int beklædningSkur(int skurLength, int skurWidth){
           int beklædningSkur = ((skurLength + skurWidth) / 4) + 6;
           return beklædningSkur;
        }
        
        public int brætOverTagfodslægte(){
           int brætOverTagfodslægte = 540;
           return brætOverTagfodslægte;
        }
        
        public int brætOverAntal(){
           int brætOverAntal = 3;
           return brætOverAntal;
        }
        
        public int brætBagdør(){
           int brætBagdør = 540;
           return brætBagdør;
        }
        
        public int brætBagdørAntal(){
           int brætBagdørAntal = 1;
           return brætBagdørAntal;
        }
        
        public int stalddørsGreb(){
           int stalddørsGreb = 1;
           return stalddørsGreb;
        }
        
        public int tHængsel(){
           int tHængsel = 2;
           return tHængsel;
        }
        
        public int vinkelbeslag(){
           int vinkelbeslag = 10;
           return vinkelbeslag;
        }
           
}