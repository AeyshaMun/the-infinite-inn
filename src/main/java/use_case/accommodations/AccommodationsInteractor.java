package use_case.accommodations;

import entity.ClientFactoryInterface;
import entity.GuestFactoryInterface;

/**
 * The Accommodations Interactor.
 */

public class AccommodationsInteractor implements AccommodationsInputBoundary {
    private final AccommodationsDataAccessInterface personDataAccessObject;
    private final AccommodationsOutputBoundary accommodationsPresenter;


    public AccommodationsInteractor(AccommodationsDataAccessInterface personDataAccessObject,
                                    AccommodationsOutputBoundary accommodationsPresenter, ClientFactoryInterface clientFactory, GuestFactoryInterface guestFactory) {
        this.personDataAccessObject = personDataAccessObject;
        this.accommodationsPresenter = accommodationsPresenter;
    }
    @Override
    public void execute(AccommodationsInputData accommodationsInputData) {
        String personType;

        if (personDataAccessObject.existsByName(accommodationsInputData.getName())) {
            personDataAccessObject.accommodationsByName(accommodationsInputData.getName(), accommodationsInputData.getAccommodations());
        }

        final AccommodationsOutputData accommodationsOutputData = new AccommodationsOutputData(accommodationsInputData.getName());
        accommodationsPresenter.prepareSuccessView(accommodationsOutputData);
    }
}
