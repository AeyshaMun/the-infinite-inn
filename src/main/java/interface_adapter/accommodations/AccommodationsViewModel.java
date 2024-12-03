package interface_adapter.accommodations;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AccommodationsViewModel {
    /**
     * The Accommodations View Model
     */
    private PropertyChangeSupport support;
    private String name;
    private String accommodations;

    public AccommodationsViewModel() {
        support = new PropertyChangeSupport(this);
    }

    public void firePropertyChanged(String accommodations) {
        support.firePropertyChange(accommodations, null, accommodations);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        support.firePropertyChange("name", oldName, name);
    }

    public String getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(String accommodations) {
        String oldAccommodations = this.accommodations;
        this.accommodations = accommodations;
        support.firePropertyChange("accommodationsUpdate", oldAccommodations, accommodations);
    }
}
