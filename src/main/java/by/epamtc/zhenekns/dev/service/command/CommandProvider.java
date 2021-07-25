package by.epamtc.zhenekns.dev.service.command;

import by.epamtc.zhenekns.dev.service.command.event.get.*;
import by.epamtc.zhenekns.dev.service.command.event.post.AdditionalInfoCommand;
import by.epamtc.zhenekns.dev.service.command.event.post.AuthorizationCommand;
import by.epamtc.zhenekns.dev.service.command.event.post.RegistrationCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private static CommandProvider instance = new CommandProvider();
    private Map<CommandName, Command> commands = new HashMap<>();

    private CommandProvider() {
        //post
        commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
        commands.put(CommandName.REGISTRATION, new RegistrationCommand());
        commands.put(CommandName.ADDITIONAL_INFO, new AdditionalInfoCommand());

        //get
        commands.put(CommandName.NO_SUCH_COMMAND, new ErrorCommand());
        commands.put(CommandName.MAIN_PAGE, new MainCommandPage());
        commands.put(CommandName.AUTHORIZATION_PAGE, new AuthorizationCommandPage());
        commands.put(CommandName.REGISTRATION_PAGE, new RegistrationCommandPage());
        commands.put(CommandName.ADDITIONAL_INFO_PAGE, new AdditionalInfoCommandPage());
        commands.put(CommandName.AUTHORIZED_MAIN_PAGE, new AuthorizedMainPage());

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
