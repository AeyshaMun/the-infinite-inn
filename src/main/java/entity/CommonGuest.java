package Entity;

public class CommonGuest implements Guest {

    private final String username;
    private final String email;
    private final String phone;
    private final String arrival;
    private final String departure;

    public CommonGuest(String username, String email, String phone, String arrival, String departure) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.arrival = arrival;
        this.departure = departure;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getArrival() {
        return arrival;
    }

    @Override
    public String getDeparture() {
        return departure;
    }
}
