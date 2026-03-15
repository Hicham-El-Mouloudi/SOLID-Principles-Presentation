package org.springformation.solid.principles.propre.iterator.impl;

import org.springformation.solid.principles.propre.iterator.Iterator;

import java.util.List;

public class StandardOrderIterator implements Iterator {
    List<String> l;
    int i = 0;

    public StandardOrderIterator(List<String> l) {
        this.l = l;
    }

    @Override
    public boolean hasNext() {
        return i >= l.size();
    }

    @Override
    public String next() {
        if (hasNext()){
            i++;
        }
        return l.get(i);
    }
}
