package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.event.Event;

import static seedu.address.logic.parser.CliSyntax.PREFIX_EVENT_TITLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PURPOSE;

/**
 * Adds an Event to the application.
 */
public class AddEventCommand extends Command {

    public static final String COMMAND_WORD = "addEvent";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds an Event to the application. \n"
            + "Parameters: "
            + PREFIX_EVENT_TITLE + "TITLE OF EVENT "
            + PREFIX_DATE + "DATE "
            + PREFIX_TIME + "TIME "
            + PREFIX_PURPOSE + "PURPOSE \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_EVENT_TITLE + "Shoe Sale "
            + PREFIX_DATE + "20-09-2022 "
            + PREFIX_TIME + "11:00 "
            + PREFIX_PURPOSE + "50% discount on all shoes store-wide! ";

    public static final String MESSAGE_SUCCESS = "New Event added: %1$s";

    public static final String MESSAGE_DUPLICATE_PERSON = "This Event already exists in the application";

    private final Event toAdd;

    public AddEventCommand(Event event) {
        requireNonNull(event);
        toAdd = event;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        model.addEvent(toAdd);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
