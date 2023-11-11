package discordbot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.LoginException;

import discordbot.commands.Command;

public class BotMain extends ListenerAdapter {
	private final Map<String, Command> commands = new HashMap<>();
    private final CommandManager commandManager = new CommandManager();
private static String token="MTE3Mjc5NTg1NDE5NzkwMzQ0MA.GVJobr.Zq_kVBIIT0kw48ZwEh-bbfSpoVYFG_NXjbMGo4";

    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault(token);
        builder.addEventListeners(new BotMain());
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        builder.enableIntents(GatewayIntent.GUILD_PRESENCES);
        builder.build();
    }
/*
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if (message.equalsIgnoreCase("!ping")) {
            event.getChannel().sendMessage("Pong!").queue();
        }
        if (message.equalsIgnoreCase("!lfc")) {
        	String id= event.getChannel().getLatestMessageId();
        	event.getChannel().deleteMessageById(id);
        }
    }
}
*/
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].startsWith("!")) {
            String commandName = args[0].substring(1);
            Command command = commandManager.getCommand(commandName);

            if (command != null) {
                command.execute(event, args);
            }
        }
    }
}