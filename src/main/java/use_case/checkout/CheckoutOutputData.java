package java.use_case.checkout;

public class CheckoutOutputData {
    private String username;
    private boolean useCaseFailed;

    public CheckoutOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}


