package java.interface_adapter.accommodations;

import use_case.accommodations.AccommodationsOutputBoundary;
import use_case.accommodations.AccommodationsOutputData;

public class AccommodationsPresenter implements AccommodationsOutputBoundary {
    /**
     * The Accommodations Presenter.
     */

    private final AccommodationsViewModel accommodationsViewModel;

    public AccommodationsPresenter(AccommodationsViewModel accommodationsViewModel) {
        this.accommodationsViewModel = accommodationsViewModel;
    }

    @Override
    public void prepareSuccessView(AccommodationsOutputData outputData) {
        accommodationsViewModel.firePropertyChanged("accommodations");
    }

    @Override
    public void prepareFailView(String errorMessage) {
        accommodationsViewModel.firePropertyChanged("accommodationsFail");
    }
}
