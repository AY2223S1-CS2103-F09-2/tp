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
public class DateOfBirth implements Comparable<DateOfBirth> {

    public static final String EMPTY_DOB = "NA";
    public static final String MESSAGE_CONSTRAINTS = "Date of birth must be in format: dd/mm/yyyy";

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
     * @param date A valid date of birth.
     */
    public DateOfBirth(String date) {
        requireNonNull(date);
        checkArgument(isValidDateOfBirth(date), MESSAGE_CONSTRAINTS);
        this.date = LocalDate.parse(date, logFormatter);
        this.isEmpty = false;
    }

    /**
     * Returns true if DateOfBirth is empty, false otherwise.
     * @return boolean
     */
    public boolean isEmpty() {
        return this.isEmpty;
    }

    /**
     * Takes in the {@code DateOfBirth} argument as well as a boolean to signify if "NA" can be taken as an argument
     * to return an empty {@code DateOfBirth}, returns a newly constructed {@code DateOfBirth} with the arguments given.
     * @param dob
     * @param isNaAllowed
     * @return DateOfBirth
     */
    public static DateOfBirth getDateOfBirth(String dob, boolean isNaAllowed) {
        if (isNaAllowed & dob.equals("NA")) {
            return DateOfBirth.getEmptyDateOfBirth();
        } else {
            return new DateOfBirth(dob);
        }
    }

    /**
     * Returns an empty {@code DateOfBirth}.
     */
    public static DateOfBirth getEmptyDateOfBirth() {
        return new DateOfBirth();
    }

    /**
     * Returns true if a given string is a valid DOB input.
     * {@code null} is used to represent an empty DateOfBirth value.
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
     * Overloaded method to default "NA" value as not an allowed date of birth format
     * @return boolean
     */
    public static boolean isValidDateOfBirth(String test) {
        return isValidDateOfBirth(test, Boolean.FALSE);
    }


    @Override
    public int compareTo(DateOfBirth d) {
        return this.date.compareTo(d.date);
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
    public String toString() {
        if (this.isEmpty()) {
            return "";
        }
        return this.date.format(outputFormatter);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DateOfBirth)) {
            return false;
        }

        // state check
        DateOfBirth d = (DateOfBirth) other;

        return this.date.equals(d.date)
            && this.isEmpty() == d.isEmpty();
    }

    @Override
    public int hashCode() {
        return this.date.hashCode();
    }
}
