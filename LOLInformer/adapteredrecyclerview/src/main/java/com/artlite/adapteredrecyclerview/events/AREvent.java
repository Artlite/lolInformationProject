package com.artlite.adapteredrecyclerview.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Artli_000 on 24.07.2016.
 */
public class AREvent implements Parcelable {

    /**
     * Event code value
     */
    private final int eventCode;

    /**
     * Event {@link String} value
     */
    private final String eventValue;

    /**
     * Constructor which provide to create of the {@link AREvent} from
     *
     * @param eventCode event code value
     */
    public AREvent(int eventCode) {
        this.eventCode = eventCode;
        this.eventValue = null;
    }

    /**
     * Method which provide the creating of the {@link AREvent} from
     *
     * @param eventCode event code
     * @return instance of {@link AREvent}
     */
    public static AREvent create(int eventCode) {
        return new AREvent(eventCode);
    }

    /**
     * Constructor which provide to create of the {@link AREvent} from
     *
     * @param eventValue event value
     */
    public AREvent(@NonNull final String eventValue) {
        this.eventCode = -1;
        this.eventValue = eventValue;
    }

    /**
     * Method which provide the creating of the {@link AREvent} from
     *
     * @param eventValue event value
     * @return instance of {@link AREvent}
     */
    public static AREvent create(@NonNull final String eventValue) {
        return new AREvent(eventValue);
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
        if (o instanceof AREvent) {
            AREvent event = (AREvent) o;
            if ((this.eventValue != null) && (event.eventValue != null)) {
                return this.eventValue.trim().equals(event.eventValue.trim());
            } else if (event.getEventCode() == eventCode) {
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

    /**
     * Method which provide the getting of the event value for the {@link AREvent}
     *
     * @return {@link String} instance of recycle event value
     */
    public String getEventValue() {
        return eventValue;
    }

    /**
     * Method which provide the describing content for {@link AREvent}
     *
     * @return described content
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Method which provide the write {@link AREvent} to {@link Parcel}
     *
     * @param parcel instance of {@link Parcel}
     * @param flags  flags value
     */
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(this.eventCode);
        parcel.writeString(this.eventValue);
    }

    /**
     * Constructor which provide the create {@link AREvent} from {@link Parcel}
     *
     * @param parcel instance of {@link Parcel}
     */
    protected AREvent(Parcel parcel) {
        this.eventCode = parcel.readInt();
        this.eventValue = parcel.readString();
    }

    /**
     * Creator field
     */
    public static final Parcelable.Creator<AREvent> CREATOR = new Parcelable.Creator<AREvent>() {
        @Override
        public AREvent createFromParcel(Parcel source) {
            return new AREvent(source);
        }

        @Override
        public AREvent[] newArray(int size) {
            return new AREvent[size];
        }
    };
}
