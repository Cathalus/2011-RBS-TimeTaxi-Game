package Racing.Controllers;
import java.sql.*;

public class HighscoreController{
	Connection conn;	
	
	public HighscoreController() throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:punkte.db");
	    /* Falls keine Datenbank vorhanden -> auskommentieren 
	    Statement stat = conn.createStatement();
	    stat.executeUpdate("create table punkte(name varchar(25),punktzahl int(15));");*/
	}
	
	/* Score speichern */
	public void insertScore(String name, int punkte) throws SQLException
	{
		Statement stat = conn.createStatement();
		stat.execute("INSERT INTO punkte (name, punktzahl) VALUES ('"+name+"',"+punkte+");");
	}
	
	/* Die Top Ten in einem zweidimensionalen Array ausgeben */
	public String[][] getTopTen() throws SQLException
	{
		String[][] ret = new String[10][2];
		int count = 0;
		Statement stat = conn.createStatement();
	    ResultSet rs = stat.executeQuery("SELECT * FROM punkte ORDER BY punktzahl DESC LIMIT 10;");
	    while (rs.next())
	    {
	    	ret[count][0] = rs.getString("name");
	    	ret[count][1] = rs.getString("punktzahl");
	    	count++;
	    }
	    rs.close();
		return ret;
	}
}
