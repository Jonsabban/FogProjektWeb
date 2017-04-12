package main;

import static java.lang.Math.sqrt;


public class Calculator {
    public String calculate(int length, int width){
        //Stern
        int understernFB = (width/2)+60;
        int understernSide = length;
        int oversternF = (width/2)+60;
        int oversternSide = length;
        
        //Remme, bræddebolte og firkantskiver
        int remmeSide = length + 60;
        int bræddebolte = (remmeSide/100)*3;
        int firkantskiver = (remmeSide/100)*2;
        
        //Spær og skruer
        int spær = (length/55) + 1;
        int spærSkruerV = spær;
        int spærSkruerH = spær;
        
        //Vandbræt
        int vandbrætF = oversternF;
        int vandbrætSide = oversternSide;
        
        //Tagplader og skruer
        int tagplader = width / 100;
        double tagSkruer = (((double)length / 100) * ((double)width / 100)) * 12;
        int skruePakker = 0;
        int loopCount = 0;
        for(int i = 0; loopCount <= tagSkruer; i++)
        {
            loopCount += 200;
            skruePakker++;
        }
        
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
            tagplader *= 2;
        }
        if(length > 660 && length <= 720)
        {
            tagpladeLength = 420;
            tagplader *= 2;
        }
        if(length > 720 && length <= 780)
        {
            tagpladeLength = 420;
            tagplader *= 2;
        }
        
        
        
        
        
        //Vindkryds
        int vindkrydsAmount = 2;
        double vindkrydsCheck = ((length/100)*(length/100))+(((width-35)/100)*((width-35)/100));
        if (sqrt(vindkrydsCheck) >= 10){
            vindkrydsAmount += 2;
        }
        
        //Output String
        String result = "Understern For/bagside: " +understernFB + "\n" + "Understern Sider: " + understernSide + "\n" + "Overstern Forside: " + oversternF + "\n" + "Overstern sider: " +oversternSide + "\n" + "Remme: " + remmeSide + "\n" + "Spær: " + spær + "\n" + "Vandbræt forside: " + vandbrætF + "\n" + "Vandbræt sider: " + vandbrætSide + "\n" + "Antal tagplader: " + tagplader + "\n" + "Tagplade længde: " + tagpladeLength + "\n" + "Skruepakker: " + skruePakker + "\n" + "Tagskruer i alt: " + tagSkruer + "\n" + "Antal vindkryds: " + vindkrydsAmount + "\n" + "Bræddebolte: " + bræddebolte;
        
        
        return result;
     
    
    }
}
