package use_case.accommodations;

import entity.Person;
import entity.PersonFactory;

/**
 * The Accommodations Interactor.
 */

public class AccommodationsInteractor implements AccommodationsInputBoundary {
    private final AccommodationsDataAccessInterface personDataAccessObject;
    private final AccommodationsOutputBoundary accommodationsPresenter;
    private final PersonFactory personFactory;

    public AccommodationsInteractor(AccommodationsDataAccessInterface personDataAccessObject,
                                    AccommodationsOutputBoundary accommodationsPresenter, PersonFactory personFactory) {
        this.personDataAccessObject = personDataAccessObject;
        this.accommodationsPresenter = accommodationsPresenter;
        this.personFactory = personFactory;
    }
    @Override
    public void execute(AccommodationsInputData accommodationsInputData) {
        final Person person = personFactory.create(accommodationsInputData.getName(),
                accommodationsInputData.getAccommodations());
        personDataAccessObject.accommodations(person);
        final AccommodationsOutputData accommodationsOutputData = new AccommodationsOutputData(person.getName());
        accommodationsPresenter.prepareSuccessView(accommodationsOutputData);
    }
}
