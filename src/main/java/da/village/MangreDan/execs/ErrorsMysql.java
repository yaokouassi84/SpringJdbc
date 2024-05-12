package da.village.MangreDan.execs;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

@SuppressWarnings("deprecation")
public class ErrorsMysql extends SQLErrorCodeSQLExceptionTranslator {

	public DataAccessException errors(String tache,String sql,SQLException ex) {
		if(ex.getErrorCode() == -12345)
			return new DeadlockLoserDataAccessException(sql, ex);
		return null;
	}
}
