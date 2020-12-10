package com.java.bohomolov.interfaces;

import com.java.bohomolov.exceptions.MissingAccessoryException;

public interface Riseable {

    public void riseChair() throws MissingAccessoryException;
    public void lowerChair() throws MissingAccessoryException;

}
