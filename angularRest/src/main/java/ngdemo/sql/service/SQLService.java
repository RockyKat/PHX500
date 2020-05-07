package ngdemo.sql.service;

import java.io.IOException;

import ngdemo.sql.domain.SQL;
import ngdemo.tools.console.StartUp;

public class SQLService 
{

	StartUp startUpLog;
	int indexType;
	String strOutLog = null;

	
    public SQL getDefaultSQL(StartUp start, int index) {
    	
       	startUpLog = start;
    	indexType = index;

    	try 
    	{
			strOutLog = startUpLog.readStdOutLogFile(indexType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
        SQL sql = new SQL();
        sql.setFirstName("My SQL Server");
        sql.setLastName("Demo Database Access.");
        sql.setBmp("mysql.png");
        sql.setStrOutLog(strOutLog);

        return sql;
    }

	public SQL getDefaultSQL() {
        SQL sql = new SQL();
        sql.setFirstName("My SQL Server");
        sql.setLastName("Demo Database Access.");
        sql.setBmp("mysql.png");		
        
        return sql;
	}
}