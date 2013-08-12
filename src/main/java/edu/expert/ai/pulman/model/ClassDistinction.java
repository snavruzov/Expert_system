package edu.expert.ai.pulman.model;

import edu.expert.ai.pulman.dao.ContentDAO;

/**
 * Created by Intellij IDEA.
 * User: Sardor Navruzov
 * Date: 7/17/13
 * Time: 4:38 PM
 */
public interface ClassDistinction
{
    public Integer GDCT(Integer alias, Integer symp, Integer clazz, ContentDAO dao);
    public Integer DP(Integer alias, Integer symp, Integer clazz, ContentDAO dao);
    public Integer thetaDC(Integer clazz, Integer alias, ContentDAO dao);
    public Integer LDC(Integer clazz, Integer alias, ContentDAO dao);
    public Integer DP_THETA(Integer alias, Integer symp, Integer clazz, ContentDAO dao);
    public Integer DP_THETA_NE_NUL(Integer alias, Integer symp, Integer clazz, ContentDAO dao);

}
