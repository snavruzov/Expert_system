package edu.expert.ai.pulman.api.listener;

import edu.expert.ai.pulman.api.Config;
import edu.expert.ai.pulman.dao.AIDao;
import edu.expert.ai.pulman.dao.ContentDAO;
import edu.expert.ai.pulman.model.InnerClassDistinction;
import edu.expert.ai.pulman.model.InterClassDistinction;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class LoggerListener
 * 
 */
public class Log4jListener implements ServletContextListener
{
	private static final Logger	logger	= LoggerFactory.getLogger(Log4jListener.class);
	
	/**
	 * Default constructor.
	 */
	public Log4jListener()
	{
	}
	
	/**
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce)
	{
		PropertyConfigurator.configure(Config.LOG4J);
		
		logger.info("**********************************************");
		logger.info("----------------------------------------------");
		logger.info("----------------------------------------------");
		logger.info("----------------------------------------------");
		logger.info("---------------AI EXPERT SYSTEM---------------");
		logger.info("----------------------------------------------");
		logger.info("----------------------------------------------");
		logger.info("**********************************************");

	}

	public void contextDestroyed(ServletContextEvent sce)
	{
	}


}
