package discordbot;

import discordbot.commands.Command;
import discordbot.commands.PingCommand;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandManager() {
        commands.put("ping", new PingCommand());
        // Register other commands
    }

    public Command getCommand(String name) {
        return commands.get(name.toLowerCase());
    }
}
