// A simple TCP server for Demo


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class Server {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: java Server <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        float result = 0;

        try {
            ServerSocket serverSocket =  new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            BufferedReader input = new BufferedReader (
                    new InputStreamReader(clientSocket.getInputStream()));

            String inputLine = null;
            while ( ( inputLine = input.readLine() )  != null ) {
                StringTokenizer st = new StringTokenizer(inputLine);
                float num1 = Float.parseFloat(st.nextToken());
                String operation = st.nextToken();
                float num2 = Float.parseFloat(st.nextToken());
                System.out.println (num1 + operation + num2);

                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    default:
                        break;
                }

                System.out.println (result);

                PrintWriter out = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(clientSocket.getOutputStream())), true);
                out.println(result);
            }
        }  catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
