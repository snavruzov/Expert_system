package edu.expert.ai.pulman.beans;

/**
 * Created by Intellij IDEA.
 * User: Sardor Navruzov
 * Date: 7/10/13
 * Time: 5:01 PM
 */
public class PulmanMarks
{
    private Integer clazz;
    private Integer alias;
    private Double value;

    public PulmanMarks(){}

    public PulmanMarks(Integer clazz, Integer alias)
    {
        this.clazz = clazz;
        this.alias = alias;
    }

    public PulmanMarks put(Double value)
    {
        this.value = value;
        return this;
    }

    public Double val()
    {
        return this.value;
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
