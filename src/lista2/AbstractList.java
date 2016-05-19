/*
package lista2;

import iterators.Iterator;

// zestaw metod ułatwiających implementację list
public abstract class AbstractList implements List {
    // wydruk wszystkich elementów listy
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append('[');
        if (!isEmpty()) {
            Iterator i = iterator();
            for (i.first(); !i.isDone(); i.next())
                buffer.append(i.current()).append(", ");
            buffer.setLength(buffer.length() - 2);
        }
        buffer.append(']');
        return buffer.toString();
    }

    // ^ - bitowa różnica symetryczna
    public int hashCode() {
        int hashCode = 0;
        Iterator i = iterator();
        for (i.first(); !i.isDone(); i.next())
            hashCode ^= i.current().hashCode();
        return hashCode;
    }

    public boolean equals(Object object) {
        return object instanceof lists.List && equals((lists.List) object);
    }

    public boolean equals(List other) {
        if (other == null || size() != other.size())
            return false;
        else {
            Iterator i = iterator();
            Iterator j = other.iterator();
            i.first();
            j.first();
            while (!i.isDone() && !j.isDone() && i.current().equals(j.current())) {
                i.next();
                j.next();
            }
            return i.isDone() && j.isDone();
        }
    }

    public void concatenate(List secondList) {
        Iterator it = secondList.iterator();
        it.first();
        while(!it.isDone()) {
            add(it.current());
            it.next();
        }
    }
}
*/
