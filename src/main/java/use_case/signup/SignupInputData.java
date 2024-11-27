package UseCase.signup;

/**
 * The Input Data for the Signup Use Case.
 */
public class SignupInputData {

    private final String username;
    private final String email;
    private final String phone;
    private final String arrival;
    private final String departure;

    public SignupInputData(String username, String email, String phone, String arrival, String departure) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.arrival = arrival;
        this.departure = departure;
    }

    String getUsername() {
        return username;
    }

    String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getArrival() {
        return arrival;
    }

    public String getDeparture() {
        return departure;
    }
}