package com.garmin.fit;

import java.util.ArrayList;

public abstract class MesgFilterBase implements MesgSource, MesgListener {
    private final ArrayList<MesgListener> mesgListeners = new ArrayList<>();

    @Override
    public void onMesg(Mesg mesg) {
        for (MesgListener mesgListener : mesgListeners) {
            mesgListener.onMesg(mesg);
        }
    }

    @Override
    public void addListener(MesgListener mesgListener) {
        if ((mesgListener != null) && !mesgListeners.contains(mesgListener)) {
            mesgListeners.add(mesgListener);
        }
    }

    public void removeListener(MesgListener mesgListener) {
        if ((mesgListener != null)) {
            mesgListeners.remove(mesgListener);
        }
    }
}
