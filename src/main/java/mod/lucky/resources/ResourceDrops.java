package mod.lucky.resources;

import mod.lucky.drop.DropFull;
import mod.lucky.resources.loader.BaseLoader;
import mod.lucky.util.LuckyReader;

public class ResourceDrops extends BaseResource {
    @Override
    public void process(LuckyReader reader, BaseLoader loader) {
        try {
            String curLine;
            while ((curLine = reader.readLine()) != null) {
                DropFull drop = new DropFull();
                drop.readFromString(curLine);
                loader.getBlock().getDropProcessor().registerDrop(drop);
            }
        } catch (Exception e) { this.logError(e); }
    }

    @Override
    public String getPath() { return "drops.txt"; }
}
