class PasswordException extends Exception {
    public PasswordException(String message) {
        super(message);
    }
}

public class Seatwork7partB {

    static void checkPassword(String password) throws PasswordException {
        if (!password.equals("Neckhurt")) {
            throw new PasswordException("Password must be least 8 long");
        } else {
            System.out.println("Password accepted");
        }
    }

    public static void main(String[] args) {
        try {
            checkPassword("Neckhurt");
        } catch (PasswordException e) {
            System.out.println("User-Defined Exception: " + e.getMessage());
        }
    }
}
