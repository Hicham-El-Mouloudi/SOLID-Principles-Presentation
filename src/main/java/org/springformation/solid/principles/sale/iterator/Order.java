package org.springformation.solid.principles.sale.iterator;

import org.springformation.solid.principles.propre.iterator.Iterator;
import org.springformation.solid.principles.propre.iterator.impl.StandardOrderIterator;

import java.util.*;

public class Order {
    private List<String> items = new ArrayList<>();

    public void addItem(String item) { items.add(item); }

    //
    public Iterator getStandardIterator() {
        return new StandardOrderIterator(items);
    }

    public Iterator getVeganItems() {
        return new StandardOrderIterator(items);
    }

    public Iterator getDrinksItems() {
        return new StandardOrderIterator(items);
    }
}
