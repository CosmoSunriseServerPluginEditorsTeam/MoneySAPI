package net.comorevi.moneyapi.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class GiveMoneyCommand extends Command {
    public GiveMoneyCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        return false;
    }
}
