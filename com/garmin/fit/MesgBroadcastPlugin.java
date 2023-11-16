/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2023 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.126.0Release
// Tag = production/release/21.126.0-0-g0576dfe
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;

import java.util.List;

/**
 * Defines the interface that must be implemented
 * to create an application specific plugin for
 * the BufferedMesgBroadcaster
 *
 */
public interface MesgBroadcastPlugin {
    public void onBroadcast(final List<Mesg> mesgs);
    public void onIncomingMesg(final Mesg mesg);
}
