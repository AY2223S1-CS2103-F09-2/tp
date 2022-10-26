package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.EventSortField;
import seedu.address.model.event.EventTitle;
import seedu.address.model.event.Purpose;
import seedu.address.model.event.StartDate;
import seedu.address.model.event.StartTime;
import seedu.address.model.person.Address;
import seedu.address.model.person.DateOfBirth;
import seedu.address.model.person.Email;
import seedu.address.model.person.Gender;
import seedu.address.model.person.Name;
import seedu.address.model.person.PersonSortField;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;


/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses {@code sortFieldLetter} into a {@code PersonSortField}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @param sortFieldLetter A valid sort field letter.
     * @return {@code PersonSortField} representing the sort field letter.
     * @throws ParseException if the given {@code sortFieldLetter} is invalid.
     */
    public static PersonSortField parsePersonSortField(String sortFieldLetter) throws ParseException {
        requireNonNull(sortFieldLetter);
        String trimmedSortFieldLetter = sortFieldLetter.trim();

        if (!PersonSortField.isValidSortField(trimmedSortFieldLetter)) {
            throw new ParseException(PersonSortField.MESSAGE_CONSTRAINTS);
        }

        return PersonSortField.createSortField(trimmedSortFieldLetter);
    }

    /**
     * Parses {@code sortFieldLetter} into a {@code EventSortField}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @param sortFieldLetter A valid sort field letter.
     * @return {@code EventSortField} representing the sort field letter.
     * @throws ParseException if the given {@code sortFieldLetter} is invalid.
     */
    public static EventSortField parseEventSortField(String sortFieldLetter) throws ParseException {
        requireNonNull(sortFieldLetter);
        String trimmedSortFieldLetter = sortFieldLetter.trim();

        if (!EventSortField.isValidSortField(trimmedSortFieldLetter)) {
            throw new ParseException(EventSortField.MESSAGE_CONSTRAINTS);
        }

        return EventSortField.createSortField(trimmedSortFieldLetter);
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String dob} into a {@code DateOfBirth}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code dob} is invalid.
     */
    public static DateOfBirth parseDob(String dob) throws ParseException {
        requireNonNull(dob);
        String trimmedDob = dob.trim();
        if (!DateOfBirth.isValidDateOfBirth(dob)) {
            throw new ParseException(DateOfBirth.MESSAGE_CONSTRAINTS);
        }
        return new DateOfBirth(trimmedDob);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String gender} into an {@code Gender}.
     * Leading and trailing whitespaces will be trimmed.
     * @param gender string containing gender.
     * @throws ParseException if the given {@code gender} is invalid.
     */
    public static Gender parseGender(String gender) throws ParseException {
        requireNonNull(gender);
        String trimmedGender = gender.trim();
        if (!Gender.isValidGender(trimmedGender)) {
            throw new ParseException(Gender.MESSAGE_CONSTRAINTS);
        }
        return new Gender(trimmedGender);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

    /**
     * Parses {@code eventTitle} into a {@code EventTitle}.
     */
    public static EventTitle parseEventTitle(String eventTitle) throws ParseException {
        requireNonNull(eventTitle);
        String trimmedEventTitle = eventTitle.trim();
        if (!EventTitle.isValidEventTitle(trimmedEventTitle)) {
            throw new ParseException(EventTitle.MESSAGE_CONSTRAINTS);
        }
        return new EventTitle(trimmedEventTitle);
    }

    /**
     * Parses a {@code String startDate} into a {@code StartDate}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static StartDate parseStartDate(String startDate) throws ParseException {
        requireNonNull(startDate);
        String trimmedStartDate = startDate.trim();
        if (!StartDate.isValidStartDate(startDate)) {
            throw new ParseException(StartDate.MESSAGE_CONSTRAINTS);
        }
        return new StartDate(trimmedStartDate);
    }

    /**
     * Parses a {@code String startTime} into a {@code StartTime}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static StartTime parseStartTime(String startTime) throws ParseException {
        requireNonNull(startTime);
        String trimmedStartTime = startTime.trim();
        if (!StartTime.isValidStartTime(startTime)) {
            throw new ParseException(StartTime.MESSAGE_CONSTRAINTS);
        }
        return new StartTime(trimmedStartTime);
    }

    /**
     * Parses {@code purpose} into a {@code Purpose}.
     */
    public static Purpose parsePurpose(String purpose) throws ParseException {
        requireNonNull(purpose);
        String trimmedPurpose = purpose.trim();
        if (!Purpose.isValidPurpose(trimmedPurpose)) {
            throw new ParseException(Purpose.MESSAGE_CONSTRAINTS);
        }
        return new Purpose(trimmedPurpose);
    }

    /**
     * Returns the uid list passed to it.
     */
    public static List<Index> parseIndexes(String indexes) throws ParseException {
        requireNonNull(indexes);
        String trimmedIndexes = indexes.trim();
        List<String> strIndexes = Arrays.asList(trimmedIndexes.split("\\s+"));
        List<Index> indexList = new ArrayList<>();
        for (String index : strIndexes) {
            if (!StringUtil.isNonZeroUnsignedInteger(index)) {
                throw new ParseException(MESSAGE_INVALID_INDEX);
            }
            indexList.add(Index.fromOneBased(Integer.parseInt(index)));
        }
        return indexList;
    }
}
