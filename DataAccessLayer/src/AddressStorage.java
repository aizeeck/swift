import address.Address;
import insurance.SocialInsuranceRecord;

import java.util.List;

/**
 * Created by aizeeck on 24.05.17.
 */
public interface AddressStorage {
    int insert(Address socialAddresRecord, int id) throws DALException;
    List<Address> select(int id) throws DALException;
    boolean update();
    boolean delete();
}
