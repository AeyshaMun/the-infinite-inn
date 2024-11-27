package Entity;

public class CommonGuestFactory implements GuestFactory{

    @Override
    public Guest create(String username, String email, String phone, String arrival, String departure) {
        return new CommonGuest(username, email, phone, arrival, departure);
    }
}
