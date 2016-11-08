package com.pefier.powercristalrings.utility;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

/**
 * Created by Pefier on 03.11.2016.
 */
public class OreDic {
    public List<String> names;
    public List<ItemStack> stacks;
    private List<ItemStack>  getstacks;

    public OreDic(){

        this.names= new ArrayList<String>();
        this.stacks = new ArrayList<ItemStack>();
        this.getstacks = new ArrayList<ItemStack>();
    }

    public void initOres(){
        for(int i=0;i<OreDictionary.getOreNames().length;i++){
            if(OreDictionary.getOreNames()[i].contains("ore"))
            names.add(OreDictionary.getOreNames()[i]);

        }

        for (int i=0;i < names.size();i++) {
            getstacks.addAll(OreDictionary.getOres(names.get(i)));

            if(getstacks.get(0).getItem() instanceof ItemBlock){
                stacks.add(getstacks.get(0));
                getstacks.clear();

            }



        }

    }


    }
