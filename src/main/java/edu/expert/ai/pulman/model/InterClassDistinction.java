package edu.expert.ai.pulman.model;

import edu.expert.ai.pulman.api.constants.AI;
import edu.expert.ai.pulman.dao.ContentDAO;

import java.util.*;

/**
 * Created by Intellij IDEA.
 * User: Sardor Navruzov
 * Date: 7/11/13
 * Time: 12:28 PM
 */
public class InterClassDistinction extends ClassDistinctionImpl
{
    private HashMap<Integer,Integer> lambda_up;
    private HashMap<Integer,Integer> lambda_down;
    private static LinkedHashMap<Integer,Double> lambda;

    public InterClassDistinction()
    { }

    public InterClassDistinction(LinkedHashMap<Integer,Integer> grd, ContentDAO dao)
    {
        this.lambda_up = new HashMap<>();
        this.lambda_down = new HashMap<>();
        lambda= new LinkedHashMap<>();
        calculate(grd,dao);
    }

    public static LinkedHashMap<Integer,Double> LAMBDA()
    {
        return lambda;
    }

    public HashMap<Integer, Integer> getLambda_up()
    {
        return lambda_up;
    }

    public void setLambda_up(HashMap<Integer, Integer> lambda_up)
    {
        this.lambda_up = lambda_up;
    }

    public HashMap<Integer, Integer> getLambda_down()
    {
        return lambda_down;
    }

    public void setLambda_down(HashMap<Integer, Integer> lambda_down)
    {
        this.lambda_down = lambda_down;
    }

    private void calculate(LinkedHashMap<Integer,Integer> grd, ContentDAO dao)
    {
        LinkedList<Integer> fld,flClass;
        Integer gcnt = 0;
        //Integer patientCount = dao.getPulmanPatientTableCount().intValue();
        Integer sumJ = 0;

        for(Integer c:grd.keySet())
        {
            for(int i = 1; i<= AI.CLAZZ_CNT; i++)
            for(int t = 1; t<=grd.get(c); t++)
            {
                sumJ+=GDCT(c,t,i,dao)*DP(c,t,i,dao);
            }
            this.lambda_up.put(c,sumJ);
            sumJ = 0;
        }

        sumJ = 0;

        // Определение межклассовых различий признаков...
        for(Integer c:grd.keySet())
        {
            for(int i = 1; i<=AI.CLAZZ_CNT; i++)
            {
                int ldc = LDC(i,c,dao);
                int dp = DP_THETA(c,null,i,dao);
                sumJ+= (((thetaDC(i,c,dao)-ldc+1)*(DP_THETA_NE_NUL(c,null,i,dao)-dp+1))
                        +(Math.min(ldc,dp)-1));

            }
            this.lambda_down.put(c,sumJ);
            sumJ = 0;
        }

        //System.out.println(this.lambda_down.values());
        for(Integer c:grd.keySet())
        {
            lambda.put(c,(1-(this.lambda_up.get(c).doubleValue()/this.lambda_down.get(c).doubleValue())));
        }

    }
}