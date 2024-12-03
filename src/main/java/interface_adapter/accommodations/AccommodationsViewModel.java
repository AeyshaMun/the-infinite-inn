package interface_adapter.accommodations;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AccommodationsViewModel {
    /**
     * The Accommodations View Model.
     */
    private PropertyChangeSupport support;
    private String accommodations;

    public AccommodationsViewModel() {
        support = new PropertyChangeSupport(this);
    }

    /**
     * Fire a property change.
     * @param accommodations the accommodations.
     */
    public void firePropertyChanged(String accommodations) {
        support.firePropertyChange(accommodations, null, accommodations);
    }
    /**
     * Add a property change listener.
     * @param pcl the property change listener.
     */
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public String getAccommodations() {
        return accommodations;
    }

    /**
     * Set the accommodations.
     * @param accommodations the accommodations.
     */
    public void setAccommodations(String accommodations) {
        String oldAccommodations = this.accommodations;
        this.accommodations = accommodations;
        support.firePropertyChange("accommodationsUpdate", oldAccommodations, accommodations);
    }
}
