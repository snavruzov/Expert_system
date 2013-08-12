package edu.expert.ai.pulman.model;

import edu.expert.ai.pulman.dao.ContentDAO;

/**
 * Created by Intellij IDEA.
 * User: Sardor Navruzov
 * Date: 7/17/13
 * Time: 4:42 PM
 */
public class ClassDistinctionImpl implements ClassDistinction
{
    public Integer GDCT(Integer alias, Integer symp, Integer clazz, ContentDAO dao)
    {
        return dao.getPulmanGradationValuesByField(alias, symp, clazz).intValue();
    }

    public Integer DP(Integer alias, Integer symp, Integer clazz, ContentDAO dao)
    {
        return dao.getPulmanXorGradationValuesByField(alias, symp, clazz).intValue();
    }

    public Integer thetaDC(Integer clazz, Integer alias, ContentDAO dao)
    {
        return dao.getPulmanNeNullGradationValues(alias, clazz).intValue();
    }

    public Integer LDC(Integer clazz, Integer alias, ContentDAO dao)
    {
        int cnt = 0;
        for (int i = 1; i <= dao.getPulmanNominalTableCount(alias); i++)
        {
            if (dao.getPulmanGradationValuesByField(alias, i, clazz) != 0)
            {
                cnt++;
            }
        }
        //System.out.println("ALIAS: "+alias+" CNT: "+cnt+" class: "+clazz);
        return cnt;
    }

    public Integer DP_THETA(Integer alias, Integer symp, Integer clazz, ContentDAO dao)
    {
        int cnt = 0;
        for (int i = 1; i <= dao.getPulmanNominalTableCount(alias); i++)
        {
            if (dao.getPulmanXorGradationValuesByField(alias, i, clazz) != 0)
            {
                cnt++;
            }
        }
        return cnt;
    }

    public Integer DP_THETA_NE_NUL(Integer alias, Integer symp, Integer clazz, ContentDAO dao)
    {
        return dao.getPulmanNeNullCLGradationValues(alias, clazz).intValue();
    }
}
