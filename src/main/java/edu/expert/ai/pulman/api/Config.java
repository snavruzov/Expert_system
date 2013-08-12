package edu.expert.ai.pulman.api;

public class Config
{
	private static final boolean	IS_PRODUCTION	= System.getProperty("user.name").indexOf("root") != -1;
	private static final String		PREFIX			= "/opt/config/";
	public static final String		LOG4J			= PREFIX + "pulman_ai.log4j.properties";

    private static final String		WINDOWS_PREFIX								= "c:/ai/";
	private static final String		UNIX_PREFIX									= "/ai/";
	private static final String		DEVELOPMENT_PREFIX							= "/home/pulman/ai/";


	public static final String		hibernate_file								= PREFIX + "ai_pulman.cfg.xml";

	public static final String		MESSAGE_ERROR_SESSION						= "Error in session";


}
