package room_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.place_order.PlaceOrderDataAccessInterface;
import use_case.place_order.PlaceOrderInputData;
import use_case.place_order.PlaceOrderInteractor;
import use_case.place_order.PlaceOrderOutputBoundary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class PlaceOrderInteractorTest {
    private PlaceOrderDataAccessInterface mockGuestData;
    private PlaceOrderOutputBoundary mockPresenter;
    private PlaceOrderInteractor placeOrderInteractor;

    @BeforeEach
    void setUp() {
        mockGuestData = mock(PlaceOrderDataAccessInterface.class);
        mockPresenter = mock(PlaceOrderOutputBoundary.class);

        placeOrderInteractor = new PlaceOrderInteractor(
                mockGuestData,
                mockPresenter
        );
    }

    @Test
    void testSuccessfulOrderPlacement() {
        ArrayList<Integer> items = (ArrayList<Integer>) Arrays.asList(2, 3, 4);
        int roomNumber = 5;
        PlaceOrderInputData inputData = new PlaceOrderInputData(Collections.singletonList(items), roomNumber);

        when(mockGuestData.getOrder(roomNumber)).thenReturn(items);

        placeOrderInteractor.execute(inputData);

        verify(mockGuestData).saveOrder(items, roomNumber);
        verify(mockPresenter).prepareSuccessView(
                argThat(outputData ->
                        outputData.getOrder().equals(items) &&
                                !outputData.isUseCaseFailed()
                )
        );
    }

    @Test
    void testOrderWithNoItems() {

        List<Object> emptyItems = Arrays.asList();
        int roomNumber = 5;
        PlaceOrderInputData inputData = new PlaceOrderInputData(emptyItems, roomNumber);

        placeOrderInteractor.execute(inputData);

        verify(mockPresenter).prepareFailView("Add items to order");
        verify(mockGuestData, never()).saveOrder(any(), anyInt());
        verify(mockPresenter, never()).prepareSuccessView(any());
    }

    @Test
    void testOrderWithMixedZeroAndNonZeroItems() {

        ArrayList<Integer> items = (ArrayList<Integer>) Arrays.asList(0, 0, 2, 3);
        int roomNumber = 5;
        PlaceOrderInputData inputData = new PlaceOrderInputData(Collections.singletonList(items), roomNumber);

        when(mockGuestData.getOrder(roomNumber)).thenReturn(items);

        placeOrderInteractor.execute(inputData);

        verify(mockGuestData).saveOrder(items, roomNumber);
        verify(mockPresenter).prepareSuccessView(any());
    }

    @Test
    void testOrderWithInvalidRoomNumber() {

        List<Integer> items = Arrays.asList(2, 3, 4);
        int invalidRoomNumber = 0;
        PlaceOrderInputData inputData = new PlaceOrderInputData(Collections.singletonList(items), invalidRoomNumber);

        placeOrderInteractor.execute(inputData);

        verify(mockPresenter).prepareFailView("Add valid room number");
        verify(mockGuestData, never()).saveOrder(any(), anyInt());
        verify(mockPresenter, never()).prepareSuccessView(any());
    }

    @Test
    void testSwitchToLoggedInView() {

        placeOrderInteractor.switchToLoggedInView();

        verify(mockPresenter).switchToLoggedInView();
    }
}