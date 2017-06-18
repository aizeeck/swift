package storages;

import exceptions.DALException;
import insurance.SocialInsuranceRecord;

import java.util.List;

/**
 * Created by aizeeck on 24.05.17.
 */
public interface SocialInsuranceStorage {
    int insert(SocialInsuranceRecord socialInsuranceRecord, int id) throws DALException;
    List<SocialInsuranceRecord> select(int id) throws DALException;
    boolean update();
    boolean delete();
}
