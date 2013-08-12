package edu.expert.ai.pulman.beans;

import java.util.HashMap;

/**
 * Created by Intellij IDEA.
 * User: Sardor Navruzov
 * Date: 7/25/13
 * Time: 2:32 PM
 */
public class WeightMarks
{
    private Integer clazz;
    private Integer alias;
    private Double value;
    private HashMap<Integer,Double> obj;

    public WeightMarks(Integer clazz, Integer alias, Double value)
    {
        this.clazz = clazz;
        this.alias = alias;
        this.value = value;
    }

    public WeightMarks put(HashMap<Integer,Double> obj)
    {
        obj.put(alias,value);
        this.obj = obj;
        return this;
    }

    public HashMap<Integer,Double> get()
    {
        return this.obj;
    }

    public Integer getClazz()
    {
        return clazz;
    }

    public void setClazz(Integer clazz)
    {
        this.clazz = clazz;
    }

    public Integer getAlias()
    {
        return alias;
    }

    public void setAlias(Integer alias)
    {
        this.alias = alias;
    }

    public String toString()
    {
        return "[val: "+value+" alias: "+alias+" class: "+clazz+"]";
    }
}
