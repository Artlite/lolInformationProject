package com.artlite.adapteredrecyclerview.events;

/**
 * Created by Artli_000 on 24.07.2016.
 */
public class RecycleEvent {

    private final int eventCode;

    public RecycleEvent(int eventCode) {
        this.eventCode = eventCode;
    }

    /**
     * Method which provide th equaling of the events
     *
     * @param o current event
     * @return equal results
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o instanceof RecycleEvent) {
            RecycleEvent event = (RecycleEvent) o;
            if (event.getEventCode() == eventCode) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method which provide the event code
     *
     * @return event code
     */
    public int getEventCode() {
        return eventCode;
    }
}
