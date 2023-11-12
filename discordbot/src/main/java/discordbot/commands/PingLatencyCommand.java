package discordbot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PingLatencyCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {

        long ping = event.getJDA().getGatewayPing();
        
  
        event.getChannel().sendMessage("Ping: " + ping + "ms").queue();
    }
}
