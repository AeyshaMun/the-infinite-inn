package use_case.accommodations;

import entity.Guest;


public interface AccommodationsInputBoundary {
    /**
     * Excecute the Accommodations Use Case
     * @param accommodationsInputData the input data (string) for this use case
     */
    void execute(AccommodationsInputData accommodationsInputData);
}
