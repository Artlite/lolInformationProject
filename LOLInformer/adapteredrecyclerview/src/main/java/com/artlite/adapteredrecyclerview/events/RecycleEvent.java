package com.artlite.adapteredrecyclerview.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Artli_000 on 24.07.2016.
 */
public class RecycleEvent implements Parcelable {

    /**
     * Event code value
     */
    private final int eventCode;

    /**
     * Event {@link String} value
     */
    private final String eventValue;

    /**
     * Constructor which provide to create of the {@link RecycleEvent} from
     *
     * @param eventCode event code value
     */
    public RecycleEvent(int eventCode) {
        this.eventCode = eventCode;
        this.eventValue = null;
    }

    /**
     * Method which provide the creating of the {@link RecycleEvent} from
     *
     * @param eventCode event code
     * @return instance of {@link RecycleEvent}
     */
    public static RecycleEvent create(int eventCode) {
        return new RecycleEvent(eventCode);
    }

    /**
     * Constructor which provide to create of the {@link RecycleEvent} from
     *
     * @param eventValue event value
     */
    public RecycleEvent(@NonNull final String eventValue) {
        this.eventCode = -1;
        this.eventValue = eventValue;
    }

    /**
     * Method which provide the creating of the {@link RecycleEvent} from
     *
     * @param eventValue event value
     * @return instance of {@link RecycleEvent}
     */
    public static RecycleEvent create(@NonNull final String eventValue) {
        return new RecycleEvent(eventValue);
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
     * Method which provide the getting of the event value for the {@link RecycleEvent}
     *
     * @return {@link String} instance of recycle event value
     */
    public String getEventValue() {
        return eventValue;
    }

    /**
     * Method which provide the describing content for {@link RecycleEvent}
     *
     * @return described content
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Method which provide the write {@link RecycleEvent} to {@link Parcel}
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
     * Constructor which provide the create {@link RecycleEvent} from {@link Parcel}
     *
     * @param parcel instance of {@link Parcel}
     */
    protected RecycleEvent(Parcel parcel) {
        this.eventCode = parcel.readInt();
        this.eventValue = parcel.readString();
    }

    /**
     * Creator field
     */
    public static final Parcelable.Creator<RecycleEvent> CREATOR = new Parcelable.Creator<RecycleEvent>() {
        @Override
        public RecycleEvent createFromParcel(Parcel source) {
            return new RecycleEvent(source);
        }

        @Override
        public RecycleEvent[] newArray(int size) {
            return new RecycleEvent[size];
        }
    };
}
