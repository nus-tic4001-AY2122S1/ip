package duke.storage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * TempList is List of collection of type T items.
 * It provides PropertyChangeSupport so that Listeners could be added
 * and get notified when new item added
 */
public class TempList<T> implements Iterable<T> {
    protected ArrayList<T> list;
    protected PropertyChangeSupport support;

    /**
     * constructor
     */
    public TempList() {
        list = new ArrayList<T>();
        support = new PropertyChangeSupport(this);
    }

    /**
     * inform that element added
     * @param element
     */
    public void add(T element) {
        var oldlist = list.clone();
        list.add(element);
        support.firePropertyChange("list", oldlist, list);
    }

    public void addWithoutWrite(T element) {
        list.add(element);
    }

    /**
     * remove at index
     * @param index
     */
    public void removeAt(int index) {
        var oldlist = list.clone();
        list.remove(index);
        support.firePropertyChange("list", oldlist, list);
    }

    public Stream<T> stream() {
        return list.stream();
    }
    public T get(int index) {
        return list.get(index);
    }
    public Integer size() {
        return list.size();
    }

    /**
     * call this method on a TempList object instance to add
     * Listener who would subscribe to the change of TempList
     * Listeners must implements PropertyChangeListener
     * @param pcl
     */
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
