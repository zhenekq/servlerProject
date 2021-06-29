package by.zhenekns.service.command.post;

import by.zhenekns.service.command.post.event.AuthorizationCommand;
import by.zhenekns.service.command.post.event.ErrorCommand;
import by.zhenekns.service.command.post.event.RegistrationCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private static CommandProvider instance = new CommandProvider();
    private Map<CommandName, Command> commands = new HashMap<>();

    private CommandProvider() {
        commands.put(CommandName.AUTHORIZATION,
                new AuthorizationCommand());

        commands.put(CommandName.REGISTRATION,
                new RegistrationCommand());

        commands.put(CommandName.NO_SUCH_COMMAND,
                new ErrorCommand());
    }

    public static CommandProvider getInstance() {
        return instance;
    }

    public Command getCommand(String commandName) {
        CommandName name = CommandName.valueOf(commandName.toUpperCase());
        Command command;
        if (name != null) {
            command = commands.get(name);
        } else {
            command = commands.get(CommandName.NO_SUCH_COMMAND);
        }
        return command;
    }

}
