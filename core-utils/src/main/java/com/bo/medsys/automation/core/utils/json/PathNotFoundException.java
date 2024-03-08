package com.bo.medsys.automation.core.utils.json;

import java.nio.file.InvalidPathException;
public class PathNotFoundException extends InvalidPathException {
    public PathNotFoundException(String input, String reason) {
        super(input, reason);
    }
}
