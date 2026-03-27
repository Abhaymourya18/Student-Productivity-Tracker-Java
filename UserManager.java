import java.io.*;

public class UserManager {

    private static final String FILE_NAME = "users.txt";

    public boolean registerUser(String username, String password) {

    if (username.isEmpty() || password.isEmpty()) {
        System.out.println("Fields cannot be empty.");
        return false;
    }

    // Check if user already exists
    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data[0].equals(username)) {
                System.out.println("Username already exists!");
                return false;
            }
        }
    } catch (IOException e) {
        // file may not exist first time
    }

    // Save new user
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
        bw.write(username + "," + password);
        bw.newLine();
        return true;
    } catch (IOException e) {
        System.out.println("Error saving user.");
    }

    return false;
}
    public boolean loginUser(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(username) && data[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user data.");
        }

        return false;
    }
}