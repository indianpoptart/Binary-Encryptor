import java.io.*;
import java.util.*;
/**
 * Turns any string into binary then saves it to a text file
 * @author Nikhil Paranjape 
 * @version April 2013 v1.3
 * DO NOT RERELEASE WITHOUT PERMISSION
 * you may use for guidance, education, and entertainment
 * feel free to add on, repost onto this repository
 */
public class BinaryEncrypter
{
    private static String saveName;
    public static void Binary() throws IOException
    {
        //x = scanner
        //y = sentence to convert
        Scanner x = new Scanner(System.in);
        System.out.println("Enter a sentence");
        String y = x.nextLine();
        System.out.println('\f');
        Random rand = new Random();

        byte [] a = y.getBytes();
        StringBuilder b = new StringBuilder();
        for (byte c :a)
        {
            int per = c;
            for (int i = 0; i < 8; i++)
            {
                b.append((per & 128) == 0 ? 0:1);
                per <<= 1;
            }
            b.append(' ');
        }
        System.out.println("'" + y + "' to binary: " + b);
        try{
            Thread.sleep(6000);
            System.out.println('\f');
        }
        catch (Exception e){

        }
        System.out.println("Tell me a filename you would like, or type random for a random number filename");
        System.out.println("You can also type no to continue without saving");
        String fileName = x.nextLine();
        if(fileName.equalsIgnoreCase("random")){
            int saveName = rand.nextInt(1000000000) + 1;
            FileWriter outFile = new FileWriter(saveName + ".txt", true);
            try {
                PrintWriter out1 = new PrintWriter(outFile);
                try {
                    out1.append(b);
                    out1.println();
                } finally {
                    out1.close();
                }
            }             finally {
                outFile.close();
            }
            System.out.println("Your filename is called " + saveName + ".txt");
        }
        else if(fileName.equalsIgnoreCase("no")){
            System.out.println("Continuing without saving!");
        }
        else{
            
            FileWriter outFile = new FileWriter(fileName + ".txt", true);
            try {
                PrintWriter out1 = new PrintWriter(outFile);
                try {
                    out1.append(b);
                    out1.println();
                } finally {
                    out1.close();
                }
            }             finally {
                outFile.close();
            }
            System.out.println("Your filename is called " + fileName + ".txt");
        }

        
    }    
}