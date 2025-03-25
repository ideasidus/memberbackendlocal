package edu.ssafy.etc;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServerInitListener
 *
 */
@WebListener
public class ServerInitListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public ServerInitListener() {
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// 써-버가 실행될 때 contextInit 하며 DB를 처음 초기화해 Connection Pool 생성
		DBUtil.getUtil();
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
