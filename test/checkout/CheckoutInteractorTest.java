package use_case.checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CheckoutInteractorTest {

    private CheckoutInteractor interactor;
    private CheckoutUserDataAccessInterface userDataAccessMock;
    private CheckoutOutputBoundary presenterMock;

    @BeforeEach
    void setUp() {
        userDataAccessMock = mock(CheckoutUserDataAccessInterface.class);
        presenterMock = mock(CheckoutOutputBoundary.class);
        interactor = new CheckoutInteractor(userDataAccessMock, presenterMock);
    }

    @Test
    void testExecute_UserNotFound() {
        // Arrange
        CheckoutInputData inputData = new CheckoutInputData("John Doe", 101, false);
        when(userDataAccessMock.existsByName("John Doe")).thenReturn(false);

        // Act
        interactor.execute(inputData);

        // Assert
        verify(presenterMock).prepareFailView("User not found.");
        verify(userDataAccessMock, never()).removeUser(anyString(), anyInt());
    }

    @Test
    void testExecute_CheckoutSuccessful() {
        // Arrange
        CheckoutInputData inputData = new CheckoutInputData("John Doe", 101, false);
        when(userDataAccessMock.existsByName("John Doe")).thenReturn(true);
        when(userDataAccessMock.removeUser("John Doe", 101)).thenReturn(true);

        // Act
        interactor.execute(inputData);

        // Assert
        verify(userDataAccessMock).removeUser("John Doe", 101);
        verify(presenterMock).prepareSuccessView(
                new CheckoutOutputData("John Doe", 101, false, true, "Checkout successful.")
        );
    }

    @Test
    void testExecute_CheckoutFailed() {
        // Arrange
        CheckoutInputData inputData = new CheckoutInputData("John Doe", 101, false);
        when(userDataAccessMock.existsByName("John Doe")).thenReturn(true);
        when(userDataAccessMock.removeUser("John Doe", 101)).thenReturn(false);

        // Act
        interactor.execute(inputData);

        // Assert
        verify(userDataAccessMock).removeUser("John Doe", 101);
        verify(presenterMock).prepareFailView("Failed to complete checkout.");
    }

    @Test
    void testExecute_UnexpectedException() {
        // Arrange
        CheckoutInputData inputData = new CheckoutInputData("John Doe", 101, false);
        when(userDataAccessMock.existsByName("John Doe")).thenReturn(true);
        when(userDataAccessMock.removeUser(anyString(), anyInt())).thenThrow(new RuntimeException("Database error"));

        // Act
        interactor.execute(inputData);

        // Assert
        verify(presenterMock).prepareFailView("An error occurred during checkout: Database error");
    }

    @Test
    void testSwitchToLoggedInView() {
        // Act
        interactor.switchtoLoggedInView();

        // Assert
        verify(presenterMock).switchtoLoggedInView();
    }
}

