package com.task;

import java.io.IOException;

public abstract interface Model {
    public abstract Data getData()
            throws IOException;
}