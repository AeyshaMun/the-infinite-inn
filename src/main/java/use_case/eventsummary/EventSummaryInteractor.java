package main.java.use_case.eventsummary;

/**
 * The Event Summary Interactor.
 */
public class EventSummaryInteractor implements EventSummaryInputBoundary {
    private final EventSummaryOutputBoundary eventSummaryPresenter;

    public EventSummaryInteractor(EventSummaryOutputBoundary eventSummaryPresenter) {
        this.eventSummaryPresenter = eventSummaryPresenter;
    }

    @Override
    public void execute(EventSummaryInputData eventSummaryInputData) {
        final EventSummaryOutputData eventSummaryOutputData = new EventSummaryOutputData(
                eventSummaryInputData.getName(), eventSummaryInputData.getEventDate(),
                eventSummaryInputData.getPartySize(), eventSummaryInputData.isIndoor(),
                eventSummaryInputData.getRoomNumber(), eventSummaryInputData.getAmountDue());
        eventSummaryPresenter.prepareSuccessView(eventSummaryOutputData);
    }

    @Override
    public void switchToHomeView() {
        eventSummaryPresenter.switchToHomeView();
    }


}







