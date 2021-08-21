package by.epamtc.zhenekns.dev.command;

import by.epamtc.zhenekns.dev.controller.command.Command;
import by.epamtc.zhenekns.dev.controller.command.CommandName;
import by.epamtc.zhenekns.dev.controller.command.CommandProvider;
import by.epamtc.zhenekns.dev.controller.command.event.get.*;
import by.epamtc.zhenekns.dev.controller.command.event.post.AdditionalInfoCommand;
import by.epamtc.zhenekns.dev.controller.command.event.post.CloseRequestsForProjectCommand;
import by.epamtc.zhenekns.dev.controller.command.event.post.RegistrationCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandTest {

    @Test
    void testAuthorizedCommand(){
        String commandName = CommandName.AUTHORIZED_MAIN_PAGE.toString();
        Command command = CommandProvider.getInstance().getCommand(commandName);
        assertEquals(command.getClass(), AuthorizedMainPage.class);
    }

    @Test
    void testMainCommand(){
        String commandName = CommandName.MAIN_PAGE.toString();
        Command command = CommandProvider.getInstance().getCommand(commandName);
        assertEquals(command.getClass(), MainCommandPage.class);
    }

    @Test
    void testAdditionalInfoCommand(){
        String commandName = CommandName.ADDITIONAL_INFO.toString();
        Command command = CommandProvider.getInstance().getCommand(commandName);
        assertEquals(command.getClass(), AdditionalInfoCommand.class);
    }

    @Test
    void testProfileCommand(){
        String commandName = CommandName.PROFILE.toString();
        Command command = CommandProvider.getInstance().getCommand(commandName);
        assertEquals(command.getClass(), ProfileCommandPage.class);
    }

    @Test
    void testUserProfileCommand(){
        String commandName = CommandName.USER_PROFILE.toString();
        Command command = CommandProvider.getInstance().getCommand(commandName);
        assertEquals(command.getClass(), UserProfileCommandPage.class);
    }

    @Test
    void testManagerTeamsCommand(){
        String commandName = CommandName.MANAGER_TEAMS.toString();
        Command command = CommandProvider.getInstance().getCommand(commandName);
        assertEquals(command.getClass(), ShowManagerTeamsCommandPage.class);
    }

    @Test
    void testRegistrationCommand(){
        String commandName = CommandName.REGISTRATION.toString();
        Command command = CommandProvider.getInstance().getCommand(commandName);
        assertEquals(command.getClass(), RegistrationCommand.class);
    }

    @Test
    void testCloseRequestForProjectCommand(){
        String commandName = CommandName.CLOSE_REQUESTS_FOR_PROJECT.toString();
        Command command = CommandProvider.getInstance().getCommand(commandName);
        assertEquals(command.getClass(), CloseRequestsForProjectCommand.class);
    }

}
