package UseCase.signup;

/**
 * Output Data for the Signup Use Case.
 */
public class SignupOutputData {

    private final boolean useCaseFailed;

    public SignupOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
