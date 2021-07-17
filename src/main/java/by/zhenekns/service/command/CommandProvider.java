package by.zhenekns.service.command;

import by.zhenekns.service.command.event.get.AuthorizationCommandPage;
import by.zhenekns.service.command.event.get.RegistrationCommandPage;
import by.zhenekns.service.command.event.post.AuthorizationCommand;
import by.zhenekns.service.command.event.get.ErrorCommand;
import by.zhenekns.service.command.event.get.MainCommandPage;
import by.zhenekns.service.command.event.post.RegistrationCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private static CommandProvider instance = new CommandProvider();
    private Map<CommandName, Command> commands = new HashMap<>();

    private CommandProvider() {
        //post
        commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
        commands.put(CommandName.REGISTRATION, new RegistrationCommand());

        //get
        commands.put(CommandName.NO_SUCH_COMMAND, new ErrorCommand());
        commands.put(CommandName.MAIN_PAGE, new MainCommandPage());
        commands.put(CommandName.AUTHORIZATION_PAGE, new AuthorizationCommandPage());
        commands.put(CommandName.REGISTRATION_PAGE, new RegistrationCommandPage());
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
