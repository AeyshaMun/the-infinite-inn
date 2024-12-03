package interface_adapter.accommodations;

import use_case.accommodations.AccommodationsInputBoundary;
import use_case.accommodations.AccommodationsInputData;

public class AccommodationsController {
    private final AccommodationsInputBoundary personAccommodationsUseCaseInteractor;

    public AccommodationsController(AccommodationsInputBoundary personAccommodationsUseCaseInteractor) {
        this.personAccommodationsUseCaseInteractor = personAccommodationsUseCaseInteractor;

    }

    public void execute(String name, String accommodations) {
        final AccommodationsInputData accommodationsInputData = new AccommodationsInputData(name, accommodations);

        personAccommodationsUseCaseInteractor.execute(accommodationsInputData);
    }
}
