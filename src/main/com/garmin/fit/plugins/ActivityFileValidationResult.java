/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2024 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.158.0Release
// Tag = production/release/21.158.0-0-gc9428aa
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit.plugins;

public class ActivityFileValidationResult {

    private final String name;
    private final Level level;
    private String description;
    private Status status;

    public ActivityFileValidationResult(String name, Level level) {
        this.name = name;
        this.level = level;
        this.status = Status.SKIPPED;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return getName() + " - Level: " + getLevel() + " Status: " + getStatus();
    }

    public enum Status {
        SKIPPED, WARNING, FAILED, PASSED
    }

    public enum Level {
        REQUIRED, OPTIONAL
    }
}
