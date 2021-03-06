package peace.minecraftserver.Entity;

import lk.vexview.api.VexViewAPI;
import lk.vexview.tag.TagDirection;
import lk.vexview.tag.components.VexImageTag;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import peace.minecraftserver.MinecraftServer;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.UUID;

public class ShopChest {
    //private Chest chest;
    private static HashMap<Location,Boolean> chestMap = new HashMap<Location, Boolean>();
    private static HashMap<Location,UUID> chest2Player = new HashMap<>();

    //设置该区域的箱子是地摊
    public static void setShopChest(Location location, Player player){
        if(location.getBlock().getType()== Material.CHEST){
            chestMap.put(location,true);
            chest2Player.put(location,player.getUniqueId());
//            TagDirection td = new TagDirection(0,180,0,true,false);
//            VexImageTag vit2 = new VexImageTag("成就",location.getBlockX(),location.getBlockY()+1,location.getBlockZ(),"[local]gonggao.png",2,2,1,1,td);
//            VexViewAPI.addWorldTag(player.getWorld(),vit2);
            player.sendMessage("设置成功");
        }
    }
    public static boolean isOwner(Location location,Player player){
        if(chest2Player.get(location)==player.getUniqueId()){
            player.sendMessage("这个店主是："+chest2Player.get(location));
            player.sendMessage("你是："+player);
            return true;
        }else{
            player.sendMessage("这个店主是："+chest2Player.get(location));
            player.sendMessage("你是："+player);
            return false;
        }
    }
    public static Player getOwner(Location location){
        return MinecraftServer.plugin.getServer().getPlayer(chest2Player.get(location));
    }

}
