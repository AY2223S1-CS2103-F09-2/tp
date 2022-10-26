package seedu.address.storage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.date.Date;
import seedu.address.model.event.Event;
import seedu.address.model.event.StartTime;
import seedu.address.model.event.UidList;
import seedu.address.model.person.Uid;

/**
 * Jackson-friendly version of Event
 */
public class JsonAdaptedEvent {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Event's %s field is missing";

    private final String eventTitle;

    private final String startDate;

    private final String startTime;

    private final String purpose;
    private final List<JsonAdaptedUid> uids = new ArrayList<>();

    /**
     * Constructs a JsonAdaptedEvent with the given event details.
     * @param eventTitle
     * @param startDate
     * @param startTime
     * @param purpose
     */
    @JsonCreator
    public JsonAdaptedEvent(@JsonProperty("eventTitle") String eventTitle, @JsonProperty("startDate") String startDate,
                            @JsonProperty("startTime") String startTime, @JsonProperty("purpose") String purpose,
                            @JsonProperty("uids") List<JsonAdaptedUid> uids) {
        this.eventTitle = eventTitle;
        this.startDate = startDate;
        this.startTime = startTime;
        this.purpose = purpose;
        if (uids != null) {
            this.uids.addAll(uids);
        }
    }

    /**
     * Converts a given Event into this class for use by Jackson.
     */
    public JsonAdaptedEvent(Event event) {
        this.eventTitle = event.getEventTitle();
        this.startDate = event.getStartDate().toLogFormat();
        this.startTime = event.getStartTime().toLogFormat();
        this.purpose = event.getPurpose();
        Iterator<Uid> iter = event.getUids().iterator();
        while (iter.hasNext()) {
            uids.add(new JsonAdaptedUid(iter.next()));
        }
    }

    /**
     * Converts this Jackson-friendly adapted event object into the model's {@code Event} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted event.
     */
    public Event toModelType() throws IllegalValueException {
        if (this.eventTitle == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "Event Title"));
        }

        if (this.startDate == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "Start Date"));
        }
        if (!Date.isValidDate(startDate)) {
            throw new IllegalValueException(Date.MESSAGE_CONSTRAINTS);
        }
        final Date modelStartDate = new Date(startDate);

        if (this.startTime == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "Start Time"));
        }
        if (!StartTime.isValidStartTime(startTime)) {
            throw new IllegalValueException(StartTime.MESSAGE_CONSTRAINTS);
        }
        final StartTime modelStartTime = new StartTime(startTime);

        if (this.purpose == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "Purpose"));
        }
        final UidList eventUids = new UidList();
        for (JsonAdaptedUid uid : uids) {
            eventUids.add(uid.toModelType());
        }
        return new Event(this.eventTitle, modelStartDate, modelStartTime, this.purpose, eventUids);
    }
}
