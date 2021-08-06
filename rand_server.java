import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class rand_server {
    
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: java Server <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            BufferedReader input = new BufferedReader (
                    new InputStreamReader(clientSocket.getInputStream()));

            String inputLine = null;
            while ( ( inputLine = input.readLine() ) != null ) {
                System.out.println( "Lowerbound, Upperbound, Numbers Generated" );
                System.out.println ( inputLine );
                String[] Arrayinput = inputLine.split(" ");
                String FirstNumber = Arrayinput[0];
                String SecondNumber = Arrayinput[1];
                String ThirdNumber = Arrayinput[2];
                System.out.println(FirstNumber);
                System.out.println( "Generated Numbers" );
                int lowerbound = Integer.parseInt(FirstNumber);
                int upperbound = Integer.parseInt(SecondNumber);
                int numberAmount = Integer.parseInt(ThirdNumber);
                String Results = RandomNumberGenerater.Randomizer(upperbound, lowerbound, numberAmount);

                System.out.println(Results);
                PrintWriter out = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(clientSocket.getOutputStream())),
                        true);
                out.println(Results);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
class RandomNumberGenerater {
    static String Randomizer(int UpperBound, int LowerBound, int numberAmount) {
        String RandomNumbers = "";
        for(int i = 0; i < numberAmount; i++)
        {
            Random rand = new Random();
            int RandomNumber;
            RandomNumber = rand.nextInt((UpperBound + 1)-LowerBound) + LowerBound;
            String str1 = Integer.toString(RandomNumber);
            RandomNumbers = RandomNumbers + " " + str1;
        }
        return RandomNumbers;
    }
} 