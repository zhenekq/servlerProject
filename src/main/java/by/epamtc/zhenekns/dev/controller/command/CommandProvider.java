package by.epamtc.zhenekns.dev.controller.command;

import by.epamtc.zhenekns.dev.controller.command.event.get.*;
import by.epamtc.zhenekns.dev.controller.command.event.post.*;

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
        commands.put(CommandName.ADD_NEW_PROJECT, new AddNewProjectCommand());
        commands.put(CommandName.UPDATE_PROFILE, new UpdateProfileCommand());
        commands.put(CommandName.RESPONSE_FOR_PROJECT, new ResponseForProjectCommand());
        commands.put(CommandName.UPDATE_PROJECT, new UpdateProjectCommand());
        commands.put(CommandName.UPDATE_PROJECT_REQUEST, new UpdateProjectRequestCommand());
        commands.put(CommandName.ADD_NEW_TEAM, new AddNewTeamCommand());
        commands.put(CommandName.APPROVE_PROJECT_REQUEST, new ApproveProjectRequestCommand());
        commands.put(CommandName.REJECT_PROJECT_REQUEST, new RejectProjectRequestCommand());
        commands.put(CommandName.CLOSE_REQUESTS_FOR_PROJECT, new CloseRequestsForProjectCommand());
        commands.put(CommandName.OPEN_REQUESTS_FOR_PROJECT, new OpenRequestsForProjectCommand());

        //get
        commands.put(CommandName.NO_SUCH_COMMAND, new ErrorCommand());
        commands.put(CommandName.MAIN_PAGE, new MainCommandPage());
        commands.put(CommandName.AUTHORIZATION_PAGE, new AuthorizationCommandPage());
        commands.put(CommandName.REGISTRATION_PAGE, new RegistrationCommandPage());
        commands.put(CommandName.ADDITIONAL_INFO_PAGE, new AdditionalInfoCommandPage());
        commands.put(CommandName.AUTHORIZED_MAIN_PAGE, new AuthorizedMainPage());
        commands.put(CommandName.LOGOUT_PAGE, new LogoutCommandPage());
        commands.put(CommandName.ADD_NEW_PROJECT_PAGE, new AddNewProjectCommandPage());
        commands.put(CommandName.SHOW_PROJECT, new ShowProjectCommandPage());
        commands.put(CommandName.USER_PROFILE, new UserProfileCommandPage());
        commands.put(CommandName.PROFILE, new ProfileCommandPage());
        commands.put(CommandName.PROJECT_REQUESTS, new ProjectRequestsCommandPage());
        commands.put(CommandName.SHOW_MY_PROJECTS, new ShowMyProjectsCommandPage());
        commands.put(CommandName.EDIT_PROJECT, new EditProjectCommandPage());
        commands.put(CommandName.EDIT_PROJECT_REQUEST, new EditProjectRequestCommandPage());
        commands.put(CommandName.CUSTOMER_PROJECT_RESPONSES, new CustomerProjectResponsesCommandPage());
        commands.put(CommandName.MANAGER_TEAMS, new ShowManagerTeamsCommandPage());
        commands.put(CommandName.CREATE_NEW_TEAM, new CreateNewTeamCommandPage());
        commands.put(CommandName.PROJECT_INFO, new ProjectInfoCommandPage());
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
