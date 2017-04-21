package main;

import static java.lang.Math.sqrt;


public class Calculator {
    
    public String flatRoof(int length, int width){
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
    public String liftedRoof(int length, int width, int angle){
        //Vindskede
        double angleToRadian = Math.toRadians(angle);
        int vindskeder = 0;
        int vindskedeAntal = 2;
        double sideA = (double) width / 2;
        double sideB = Math.tan(angleToRadian) * sideA; 
        double hypotenuse = Math.sqrt((sideA * sideA) + (sideB * sideB));
        
        
        
        //Stern
        int sternSide = length + 90;
        int sternSideAntal = 2;
        
        //Byg Selv Spær - Færdigskåret 
        int færdigByggetAntal = 1;
        int antalSpær = (length/89) + 1;
        int skruerSpærV = antalSpær;
        int skruerSpærH = antalSpær;
        
        //Stolper
        int stolper = 300;
        int stolpeAntal = 4;
        
        //Remme
        int remme = length - 30;
        int remmeAntal = 2;
        
        //Vandbræt
        int vandbræt = vindskeder;
        int vandbrætAntal = 2;
        
        //Beklædning af gavle
        int gavlantal;
        
        //Taglægter
        int taglægterSpær;
        int taglægterSpærAntal; 
        
        //Tag
        int dobbelt;
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
        
        
        
        int rygsten;
        int toplægteHolder;
        int rygstensBeslag;
        int bindereOgNakkekroge;
        
        //Skruer
        int skruer;
        
        
                
        
        
        String result = antalSpær + "   " + sideA + " " + sideB + " " + hypotenuse + " " + angleToRadian;
        return result;
    }
}
