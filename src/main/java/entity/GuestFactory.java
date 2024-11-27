package Entity;

public interface GuestFactory
{
    Guest create(String username, String email, String phone, String arrival, String departure);
}
