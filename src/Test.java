import java.io.*;
import java.security.MessageDigest;
import java.util.*;

public class Test
{
    public static void main (String args [])
    {
        ArrayList<String> jokeList = new ArrayList();   // An array list that will hold lines from Jokes.txt text file

        int temp = 0;   // Variable that will hold the temporary score between 2 hash codes
        int result = -1; // Variable for final score. Initial value is -1, so it can be replaced with any positive int.

        String sentence1 = ""; // String that holds the first sentence that will be checked
        String sentence2 = ""; // String that holds the second sentence that will be checked
        String finalSentence = "";  // Final string that will print out 2 sentences with the highest score

        try
        {
            BufferedReader jokes = new BufferedReader(new FileReader("Jokes.txt")); // A class that reads a text file from computer

            jokeList.add(jokes.readLine()); // Adds the next line from the text file into an array list of strings
            while (jokes.readLine() != null)    // A loop that adds the next line from the text file into an array list of strings
            {
                jokeList.add(jokes.readLine()); // Adds the next line from the text file into an array list of strings
            }
        }
        catch (IOException e)   // Catches an exception if there was an error reading the file
        {
            e.printStackTrace();    // Prints the error
        }

        for (int pos1 = 0; pos1 < jokeList.size(); pos1++)  // Outer loop for sentence 1
        {
            for (int pos2 = pos1 + 1; pos2 < jokeList.size() -1; pos2++)    // Inner loop for sentence 2
            {
                sentence1 = jokeList.get(pos1); // Variable for sentence 1 from outer loop
                sentence2 = jokeList.get(pos2); // Variable for sentence 2 from inner loop

                temp = shaScore(sha256(sentence1), sha256(sentence2));  // Variable that holds the score between 2 hash codes

                if (temp > result)  // If statement to keep track of the highest number of matches
                {
                    result = temp;  // Result is now the score between 2 hash codes
                    finalSentence = sentence1 + "\n" + sentence2;   // A string that will hold 2 jokes separated by a linebreak
                }
            }
        }

        System.out.println(finalSentence + "\n" + result);  // Print the 2 sentences followed by their score for hash code
    }

    public static int shaScore(String a, String b)  // A method that takes in 2 sha256 codes and returns the int score
    {
        int result = 0; // Initial variable to keep track of the score

        for (int pos1 = 0; pos1 < a.length(); pos1++)   // A for loop that will loop 64 times, to go through the whole sha256 code.
        {
            if (a.charAt(pos1) == b.charAt(pos1))   // If 2 characters are the same from code a and code b
            {
                result++;   // Increment the score by 1
            }
        }
        return result;  // Return the final score
    }

    public static String sha256(String input)   // Method that takes in a string and outputs a sha-256 code in a form of a string
    {
        try
        {
            MessageDigest mDigest = MessageDigest.getInstance("SHA-256");

            byte [] salt = "CS210+".getBytes("UTF-8");
            mDigest.update(salt);

            byte [] data = mDigest.digest(input.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();

            for (int pos1 = 0; pos1 < data.length; pos1++)
            {
                sb.append(Integer.toString((data[pos1] & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        }
        catch (Exception e)
        {
            return(e.toString());
        }
    }
}
