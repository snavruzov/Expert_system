package edu.expert.ai.pulman.dao;


public class AIDao
{
    private static ContentDAO instance;

    public static synchronized ContentDAO getInstance() {
        if(instance == null)
		{
			synchronized(ContentDAO.class)
			{
				if(instance == null)
				{
					instance = new ContentDAOImpl();
				}
			}
		}

		return instance;
    }

    private AIDao() {
    }
}
