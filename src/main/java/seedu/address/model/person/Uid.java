package seedu.address.model.person;

import java.util.UUID;
/**
 * Uid that uniquely defines a person.
 * Uid is an unmodifiable field that is created every time with the creation of a new Person.
 */
public class Uid {
    public static final String MESSAGE_CONSTRAINTS = "Uid should be a string parsed from java UUID object";
    public final String value;

    /**
     * constructor that creates an Uid Object.
     */
    public Uid() {
        this.value = String.valueOf(UUID.randomUUID());
    }
    /**
     * Overloaded constructor that creates an Uid Object.
     */
    public Uid(String value) {
        this.value = value;
    }
    public String getUid() {
        return value;
    }
    /**
     * Returns true if both uids have the same name. This method should always return false value.
     */
    public boolean isSameUid(Uid otherUid) {
        if (otherUid == this) {
            return true;
        }
        return otherUid != null && otherUid.getUid().equals(getUid());
    }

    /**
     * Returns true if a given string is a valid Uid.
     */
    public static boolean isValidUid(String test) {
        try {
            UUID uuid = UUID.fromString(test);
        } catch (IllegalArgumentException exception) {
            return false;
        }
        return true;
    }
}
