package login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.login.LoginDataAccessInterface;
import use_case.login.LoginInputData;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;

import static org.mockito.Mockito.*;

class LoginInteractorTest {
    private LoginDataAccessInterface mockDataAccessObject;
    private LoginOutputBoundary mockLoginPresenter;
    private LoginInteractor loginInteractor;

    @BeforeEach
    void setUp() {
        mockDataAccessObject = mock(LoginDataAccessInterface.class);
        mockLoginPresenter = mock(LoginOutputBoundary.class);

        loginInteractor = new LoginInteractor(
                mockDataAccessObject,
                mockLoginPresenter
        );
    }

    @Test
    void testSuccessfulLogin() {

        LoginInputData inputData = new LoginInputData("hadas", 5);

        when(mockDataAccessObject.roomExists(5)).thenReturn(true);
        when(mockDataAccessObject.getName(5)).thenReturn("hadas");

        loginInteractor.execute(inputData);

        verify(mockDataAccessObject).setCurrentGuest("hadas");

        verify(mockLoginPresenter).prepareSuccessView(
                argThat(outputData ->
                        outputData.getName().equals("hadas") &&
                                !outputData.isUseCaseFailed()
                )
        );
    }

    @Test
    void testNonExistentRoom() {

        LoginInputData inputData = new LoginInputData("hadas", 5);

        when(mockDataAccessObject.roomExists(5)).thenReturn(false);

        loginInteractor.execute(inputData);

        verify(mockLoginPresenter).prepareFailView("Enter a valid room Number");

        verify(mockDataAccessObject, never()).setCurrentGuest(any());
        verify(mockLoginPresenter, never()).prepareSuccessView(any());
    }

    @Test
    void testNameAndRoomMismatch() {

        LoginInputData inputData = new LoginInputData("hadas", 5);

        when(mockDataAccessObject.roomExists(5)).thenReturn(true);
        when(mockDataAccessObject.getName(5)).thenReturn("different_name");

        loginInteractor.execute(inputData);

        verify(mockLoginPresenter).prepareFailView("Name and room number do not match");

        verify(mockDataAccessObject, never()).setCurrentGuest(any());
        verify(mockLoginPresenter, never()).prepareSuccessView(any());
    }

    @Test
    void testSwitchToMainView() {

        loginInteractor.switchToMainView();

        verify(mockLoginPresenter).switchToMainView();
    }
}