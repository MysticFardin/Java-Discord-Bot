package discordbot;

import discordbot.commands.Command;
import discordbot.commands.PingCommand;
import discordbot.commands.PingLatencyCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandManager() {
        commands.put("ping", new PingCommand());
        commands.put("pinglatency",new PingLatencyCommand());
    }

    public Command getCommand(String name) {
        return commands.get(name.toLowerCase());
    }
}
