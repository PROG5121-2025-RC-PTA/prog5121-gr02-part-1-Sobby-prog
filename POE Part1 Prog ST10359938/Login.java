
package main;
  import java.util.regex.*;

public class Login {
  private String username;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;

    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }

    // Referenced using ChatGPT — OpenAI (2025, April 14). https://chat.openai.com
    public boolean checkCellPhoneNumber(String phone) {
        return phone.matches("^\\+27\\d{9}$");
    }

    public String registerUser(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phone;

        boolean validUsername = checkUsername(username);
        boolean validPassword = checkPasswordComplexity(password);
        boolean validPhone = checkCellPhoneNumber(phone);

        if (!validUsername) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!validPassword) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!validPhone) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.\nUser registered successfully!";
    }

    public boolean loginUser(String inputUsername, String inputPassword) {
        return inputUsername.equals(this.username) && inputPassword.equals(this.password);
    }

    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

}
