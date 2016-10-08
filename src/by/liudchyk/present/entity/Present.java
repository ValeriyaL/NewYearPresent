package by.liudchyk.present.entity;


import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Admin on 04.10.2016.
 */
public class Present implements Iterable{
    private Set<Confection> present = new HashSet<>();
    private String owner = "";

    public Present(HashSet<Confection> present, String owner) {
        this.present = present;
        this.owner = owner;
    }

    public Set<Confection> getPresent() {
        return Collections.unmodifiableSet(present);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Confection temp: present){
            sb.append(temp);
        }
        return new String(sb);
    }

    public String getOwner() {
        return owner;
    }

    public Iterator<Confection> iterator() {
        return present.iterator();
    }

    public Object[] toArray() {
        return present.toArray();
    }

    public boolean add(Confection confection) {
        return present.add(confection);
    }

    @Override
    public void forEach(Consumer action) {
        present.forEach(action);
    }

    public boolean removeAll(Collection<?> c) {
        return present.removeAll(c);
    }

    public void clear() {
        present.clear();
    }

    public <T> T[] toArray(T[] a) {
        return present.toArray(a);
    }

    public boolean isEmpty() {
        return present.isEmpty();
    }

    public boolean contains(Object o) {
        return present.contains(o);
    }

    public boolean remove(Object o) {
        return present.remove(o);
    }

    public int size() {
        return present.size();
    }
}
