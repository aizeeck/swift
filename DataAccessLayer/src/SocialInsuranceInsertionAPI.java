import insurance.SocialInsuranceRecord;

import java.util.List;

/**
 * Created by aizeeck on 29.05.17.
 */
public interface SocialInsuranceInsertionAPI {
    void insert(List<SocialInsuranceRecord> records, int citizenId) throws DALException;
}
