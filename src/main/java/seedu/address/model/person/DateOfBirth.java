package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a Person's date of birth in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDate(String)}
 */
public class DateOfBirth {

    public static final String MESSAGE_CONSTRAINTS = "Date of birth must be in format: dd/mm/yyyy";
    private static final String MESSAGE_ARGUMENT_CONSTRAINTS =
        "compareTo() of DateOfBirth must take in argument of type LocalDate";

    //for checking if valid input date format
    private static final DateTimeFormatter checkFormatter = DateTimeFormatter
            .ofPattern("[d/M/yyyy][dd/M/yyyy][d/MM/yyyy][dd/MM/yyyy]");

    //for changing to storage friendly format
    private static final DateTimeFormatter logFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");

    //for changing to user-readable format
    private static final DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy");

    public final LocalDate date;

    private boolean isEmpty;

    /**
     * Constructs an empty {@code DateOfBirth}.
     */
    private DateOfBirth() {
        this.date = null;
        this.isEmpty = true;
    }

    /**
     * Constructs an {@code DateOfBirth}.
     *
     * @param date A valid date.
     */
    public DateOfBirth(String date) {
        requireNonNull(date);
        checkArgument(isValidDateOfBirth(date), MESSAGE_CONSTRAINTS);
        this.date = LocalDate.parse(date, logFormatter);
        this.isEmpty = false;
    }

    /**
     * Constructs an empty {@code DateOfBirth}.
     */
    public static DateOfBirth getEmptyDateOfBirth() {
        return new DateOfBirth();
    }

    /**
     * Returns true if a given string is a valid DOB input, null is used to represent an empty DateOfBirth.
     * @return boolean
     */

    //found from https://mkyong.com/java/how-to-check-if-date-is-valid-in-java/
    public static boolean isValidDateOfBirth(String test, boolean isNaAllowed) {
        if (test == null) {
            return true;
        }
        if (test.equals("NA") & isNaAllowed) {
            return true;
        }
        try {
            LocalDate.parse(test, checkFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }


    /**
     * Overloaded method to default "NA" value as not a allowed date of birth format
     * @return boolean
     */

    //found from https://mkyong.com/java/how-to-check-if-date-is-valid-in-java/
    public static boolean isValidDateOfBirth(String test) {
        return isValidDateOfBirth(test, Boolean.FALSE);
    }


    /**
     * Returns 1 if the other object is a DateOfBirth that is later,
     * -1 if the other object is a DateOfBirth that is earlier,
     * and 0 if the other object is a DateOfBirth that is of the same date .
     * @param other The object to compare with
     * @return int
     */
    public int compareTo(Object other) {
        if (other == null) {
            return -1;
        }
        if (!(other instanceof DateOfBirth)) {
            throw new IllegalArgumentException(MESSAGE_ARGUMENT_CONSTRAINTS);
        }
        if (this.isEmpty() & ((DateOfBirth) other).isEmpty()) {
            return 0;
        }
        return this.date.compareTo(((DateOfBirth) other).date);
    }

    /**
     * Returns true if DateOfBirth is empty, false otherwise
     * @return boolean
     */
    public boolean isEmpty() {
        return this.isEmpty;
    }

    /**
     * Returns the the String representation of the DateOfBirth in format suitable for storage logging
     * @return String
     */
    public String toLogFormat() {
        if (this.isEmpty()) {
            return null;
        }
        return this.date.format(logFormatter);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DateOfBirth)) {
            throw new IllegalArgumentException(MESSAGE_ARGUMENT_CONSTRAINTS);
        }
        if (this.isEmpty() & ((DateOfBirth) other).isEmpty()) {
            return true;
        }
        return this.date.equals(((DateOfBirth) other).date);
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "";
        }
        return this.date.format(outputFormatter);
    }

    @Override
    public int hashCode() {
        return this.date.hashCode();
    }
}
