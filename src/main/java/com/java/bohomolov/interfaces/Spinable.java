package com.java.bohomolov.interfaces;

import com.java.bohomolov.exceptions.MissingAccessoryException;
@FunctionalInterface
public interface Spinable {

    public void spin() throws MissingAccessoryException;
}
