package me.DamianeK.JoinAndQuitMessage;
 
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
 
public class Main extends JavaPlugin{
   
    public void onEnable(){
        Bukkit.getConsoleSender().sendMessage("§6----Turning On plugin----");
       
        Bukkit.getPluginManager().registerEvents(new Chat(), this);
    }
   
    public void onDisable(){
        Bukkit.getConsoleSender().sendMessage("§6----Turning Off plugin----");
    }
    
    public class Chat implements Listener {
        
    	@EventHandler
    	public void onJoin(PlayerJoinEvent e){
            Player p = e.getPlayer();
            e.setJoinMessage("§7" + getConfig().getString("Join.Message") +" §6"+ p.getName() +" §7"+ getConfig().getString("Join.Message2"));
        }
    	
        @EventHandler
        public void onQuit(PlayerQuitEvent e){
            Player p = e.getPlayer();
            e.setQuitMessage("§7" + getConfig().getString("Quit.Message") +" §6"+ p.getName() +" §7"+ getConfig().getString("Quit.Message2"));
        }
    }
}