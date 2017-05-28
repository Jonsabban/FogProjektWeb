package calculator;

import static java.lang.Math.sqrt;

public class FlatRoof {
    LiftedRoof l = new LiftedRoof();
    //Calculates materials for carport with flat roof.
        //Stern
        public int understernFB(int width){
            int understernFB = (width/2)+60;
            return understernFB;
        }
        
        public int understernFBAntal(){
            int understernFBAntal = 4;
            return understernFBAntal;
        }
        
        public int understernSide(int length){
            int understernSide = length;
            return length;
        }
        
        public int understernSideAntal(){
            int understernSideAntal = 4;
            return understernSideAntal;
        }
        
        public int oversternF(int width){
            int oversternF = (width/2)+60;
            return oversternF;
        }
        
        public int oversternFAntal(){
            int oversternFAntal = 2;
            return oversternFAntal;
        }
        
        public int oversternSide(int length){
            int oversternSide = length;
            return oversternSide;
        }
        
        public int oversternSideAntal(){
            int oversternSideAntal = 4;
            return oversternSideAntal;
        }
        
        //Remme, bræddebolte og firkantskiver
        public int remmeSide(int length){
            int remmeSide = length + 60;
            return remmeSide;
        }
        
        public int remmeSideAntal(){
            int remmeSideAntal = 2;
            return remmeSideAntal;
        }
        
        public int bræddebolte(int length){
            int bræddebolte = (remmeSide(length)/100)*3;
            return bræddebolte;
        }
        
        public int firkantskiver(int length){
            int firkantskiver = (remmeSide(length)/100)*2;
            return firkantskiver;
        }
        
        //Spær og skruer
        public int spær(int width){
            int spær = 0;
            for (int i = 0; spær <= width; i++){
                spær += 30;
            }
            return spær;
        }
        public int spærAntal(int length){
            int spær = (length/55) + 1;
            return length;
        }
        
        public int spærSkruerV(int length){
            int spærSkruerV = spærAntal(length);
            return spærSkruerV;
        }
        
        public int spærSkruerH(int length){
            int spærSkruerH = spærAntal(length);
            return spærSkruerH;
        }
        
        //Vandbræt
        public int vandbrætF(int width){
            int vandbrætF = oversternF(width);
            return vandbrætF;
        }
        
        public int vandbrætFAntal(){
            int antal = oversternFAntal();
            return antal;
        }
        
        public int vandbrætSide(int length){
            int vandbrætSide = oversternSide(length);
            return vandbrætSide;
        }
        
        public int vandbrætSideAntal(){
            int antal = oversternSideAntal();
            return antal;
        }
        
        
        //Tagplader og skruer
        public int tagplader(int length, int width, int skurLength){
            int tagplader = width / 100;
            if (length + skurLength > 600){
                tagplader *=2;
            }
            return tagplader;
        }
        
        public int tagpladerLength(int length){
            int tagpladeLength = 0;
            if(length <= 240)
            {
                tagpladeLength = 240;
            }
            if(length > 240 && length <= 300)
            {
                tagpladeLength = 300;
            }
            if(length > 300 && length <= 360)
            {
                tagpladeLength = 360;
            }
            if(length > 360 && length <= 420)
            {
                tagpladeLength = 420;
            }
            if(length > 420 && length <= 480)
            {
                tagpladeLength = 480;
            }
            if(length > 480 && length <= 600)
            {
                tagpladeLength = 600;
            }
            if(length > 600 && length <= 660)
            {
                tagpladeLength = 360;
            }
            if(length > 660 && length <= 720)
            {
                tagpladeLength = 420;
            }
            if(length > 720 && length <= 780)
            {
                tagpladeLength = 420;
            }
            return tagpladeLength;
        }
        
        public int skruePakker(int length, int width){
            double tagSkruer = (((double)length / 100) * ((double)width / 100)) * 12;
            int skruePakker = 0;
            int loopCount = 0;
            for(int i = 0; loopCount <= tagSkruer; i++)
            {
                loopCount += 200;
                skruePakker++;
            }
        
            
            return skruePakker;
        }
        
        
        
        //Vindkryds
        public int vindkrydsAmount(int length, int width){
            int vindkrydsAmount = 2;
            double vindkrydsCheck = ((length/100)*(length/100))+(((width-35)/100)*((width-35)/100));
            if (sqrt(vindkrydsCheck) >= 10)
            {
            vindkrydsAmount += 2;
            }
            return vindkrydsAmount;
        }
        
        public int stalddørsGreb(){
           int stalddørsGreb = 1;
           return stalddørsGreb;
        }
        
        public int tHængsel(){
           int tHængsel = 2;
           return tHængsel;
        }
        
        public int indersteBeklædAmount(int skurLength, int skurWidth){
            int indersteBeklædning = 0;
            int beklædning = l.beklædningSkurAntal(skurLength, skurWidth);
            int loopCount = 0;
            for (int i = 0; loopCount <= beklædning; i++){
                loopCount += 100;
                indersteBeklædning += 1;
            }
            return indersteBeklædning;
        }
        
        public int ydersteBeklædAmount(int skurLength, int skurWidth){
            int indersteBeklædning = 0;
            int beklædning = l.beklædningSkurAntal(skurLength, skurWidth);
            int loopCount = 0;
            for (int i = 0; loopCount <= beklædning; i++){
                loopCount += 100;
                indersteBeklædning += 1;
            }
            return indersteBeklædning;
        }
        
        public int hulbånd(){
            int hulbånd = 2;
            return hulbånd;
        }
        
        public int sternSkruer(){
            int skruer = 1;
            return skruer;
        }
        
        public int beslagsSkruer(){
            int skruer = 3;
            return skruer;
        }
        
        
}