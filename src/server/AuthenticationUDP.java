import java.io.*;
import java.net.*;
import java.util.*;

public class AuthenticationUDP {
    private static final int PORT = 5000;
    private static final Map<String, String> credentials = new HashMap<>();
    private static final int MAX_RETRIES = 3;
    private static final int TIMEOUT = 5000;

    public static void main(String[] args) throws Exception {
        // Predefined user credentials for validation
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");

        DatagramSocket socket = new DatagramSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        byte[] receiveBuffer = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);

            String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
            String[] parts = receivedData.split(",");
            String username = parts[0];
            String password = parts[1];

            String response;
            if (validateCredentials(username, password)) {
                String token = generateToken(username);
                response = "Authentication success. Token: " + token;
            } else {
                response = "Authentication failed. Invalid credentials.";
            }

            byte[] sendBuffer = response.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
            socket.send(sendPacket);
        }
    }

    private static boolean validateCredentials(String username, String password) {
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }

    private static String generateToken(String username) {
        // Simple token generation logic (for demonstration purposes)
        return UUID.randomUUID().toString();
    }
}