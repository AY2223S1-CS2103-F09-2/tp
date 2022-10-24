package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.event.Event;
import seedu.address.model.event.StartDate;
import seedu.address.model.event.StartTime;
import seedu.address.model.person.Address;
import seedu.address.model.person.DateOfBirth;
import seedu.address.model.person.Email;
import seedu.address.model.person.Gender;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Uid;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new DateOfBirth("13/2/1988"), new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends"), new Gender("male"), new Uid()),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new DateOfBirth("11/5/1968"), new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends"), new Gender("female"), new Uid()),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new DateOfBirth("4/12/2002"), new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                getTagSet("neighbours"), new Gender("female"), new Uid()),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new DateOfBirth("29/7/1996"), new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                getTagSet("family"), new Gender("male"), new Uid()),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new DateOfBirth("2/6/1984"), new Address("Blk 47 Tampines Street 20, #17-35"),
                getTagSet("classmates"), new Gender("male"), new Uid()),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new DateOfBirth("2/11/1954"), new Address("Blk 45 Aljunied Street 85, #11-31"),
                getTagSet("colleagues"), new Gender("male"), new Uid())
        };
    }

    public static Event[] getSampleEvents() {
        return new Event[] {
            new Event("2-2 Sale", new StartDate("2/2/2022"), new StartTime("02/00/AM"), "For football fans"),
            new Event("4-4 Sale", new StartDate("4/4/2022"), new StartTime("04/00/PM"), "For computer scientists"),
            new Event("6-6 Sale", new StartDate("6/6/2022"), new StartTime("06/00/AM"), "For car enthusiasts"),
            new Event("8-8 Sale", new StartDate("8/8/2022"), new StartTime("08/00/PM"), "For bread lovers"),
            new Event("10-10 Sale", new StartDate("10/10/2022"), new StartTime("10/00/AM"), "For watch hobbyists"),
            new Event("12-12 Sale", new StartDate("12/12/2022"), new StartTime("12/00/PM"), "For stationery buyers")
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        for (Event sampleEvent : getSampleEvents()) {
            sampleAb.addEvent(sampleEvent);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
