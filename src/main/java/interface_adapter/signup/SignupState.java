package interface_adapter.signup;

/**
 * The state for the Signup View Model.
 */
public class SignupState {
    private String username = "";
    private String usernameError;
    private String email = "";
    private String emailError;
    private String phone = "";
    private String phoneError;
    private String arrival = "";
    private String arrivalError;
    private String departure = "";
    private String departureError;

    // getter methods
    public String getUsername() {
        return username;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailError() {
        return emailError;
    }

    public String getPhone() {
        return phone;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public String getArrival() {
        return arrival;
    }

    public String getArrivalError() {
        return arrivalError;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDepartureError() {
        return departureError;
    }

    // setter methods
    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public void setArrivalError(String arrivalError) {
        this.arrivalError = arrivalError;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDepartureError(String departureError) {
        this.departureError = departureError;
    }

    @Override
    public String toString() {
        return "SignupState{"
                + "username='" + username + '\''
                + ", e-mail='" + email + '\''
                + ", phone number='" + phone + '\''
                + ", arrival date='" + arrival + '\''
                + ", departure date='" + departure + '\''
                + '}';
    }
}