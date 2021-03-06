package net.comorevi.np.moneys;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import net.comorevi.np.moneys.util.ConfigManager;
import net.comorevi.np.moneys.util.MessageManager;
import net.comorevi.np.moneys.util.TextValues;

public class EventListener implements Listener{
    private final MessageManager message = MessageManager.getInstance();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        if(!MoneySAPI.getInstance().existsAccount(event.getPlayer())){
        	MoneySAPI.getInstance().registerAccount(event.getPlayer());
        	event.getPlayer().sendMessage(TextValues.INFO + message.translateString("player-account-add", event.getPlayer().getName()));
        }else{
            event.getPlayer().sendMessage(TextValues.INFO + message.translateString("player-account-load", event.getPlayer().getName(), String.valueOf(MoneySAPI.getInstance().getMoney(event.getPlayer())), MoneySAPI.UNIT));
        }

        if (ConfigManager.getInstance().enabledShowRank()) {
            MoneySystemPlugin.getInstance().showMoneyRank(event.getPlayer());
        }
    }
}