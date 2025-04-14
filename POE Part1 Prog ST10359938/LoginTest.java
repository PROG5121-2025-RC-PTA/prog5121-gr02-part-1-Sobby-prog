import main.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    
    // Sample Login object for testing
    Login login = new Login("John", "Doe");

    @Test
    public void testCheckUsernameTrue() {
        assertTrue(login.checkUsername("jd_1"));
    }

    @Test
    public void testCheckUsernameFalse() {
        assertFalse(login.checkUsername("johndoe")); // No underscore and too long
    }

    @Test
    public void testCheckPasswordComplexityTrue() {
        assertTrue(login.checkPasswordComplexity("Test@1234")); // Valid password
    }

    @Test
    public void testCheckPasswordComplexityFalse() {
        assertFalse(login.checkPasswordComplexity("password")); // No uppercase, number, or special char
    }

    @Test
    public void testCheckCellPhoneNumberTrue() {
        assertTrue(login.checkCellPhoneNumber("+27812345678")); // Valid SA number
    }

    @Test
    public void testCheckCellPhoneNumberFalse() {
        assertFalse(login.checkCellPhoneNumber("0812345678")); // Missing +27
    }

    @Test
    public void testLoginSuccess() {
        login.registerUser("jd_1", "Test@1234", "+27812345678");
        assertTrue(login.loginUser("jd_1", "Test@1234"));
    }

    @Test
    public void testLoginFailWrongPassword() {
        login.registerUser("jd_1", "Test@1234", "+27812345678");
        assertFalse(login.loginUser("jd_1", "wrongPass"));
    }

    @Test
    public void testLoginFailWrongUsername() {
        login.registerUser("jd_1", "Test@1234", "+27812345678");
        assertFalse(login.loginUser("wrongUser", "Test@1234"));
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        login.registerUser("jd_1", "Test@1234", "+27812345678");
        boolean result = login.loginUser("jd_1", "Test@1234");
        assertEquals("Welcome John Doe, it is great to see you again.", login.returnLoginStatus(result));
    }

    @Test
    public void testReturnLoginStatusFailure() {
        login.registerUser("jd_1", "Test@1234", "+27812345678");
        boolean result = login.loginUser("jd_1", "wrongpass");
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(result));
    }
}
