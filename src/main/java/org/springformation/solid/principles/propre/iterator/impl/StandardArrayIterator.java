package org.springformation.solid.principles.propre.iterator.impl;

import org.springformation.solid.principles.propre.iterator.Iterator;

import java.util.List;

public class StandardArrayIterator implements Iterator {
    String[] l;
    int i = 0;

    public StandardArrayIterator(String[] items) {
        this.l = l;
    }

    @Override
    public boolean hasNext() {
        return i >= l.length;
    }

    @Override
    public String next() {
        if (hasNext()){
            i++;
        }
        return l[i];
    }
}
