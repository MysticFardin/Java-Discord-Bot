package discordbot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PingCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage("Pong!").queue();
    }
}
