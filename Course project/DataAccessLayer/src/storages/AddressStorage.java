package storages;

import address.Address;
import exceptions.DALException;
import insurance.SocialInsuranceRecord;

import java.util.List;

/**
 * Created by aizeeck on 24.05.17.
 */
public interface AddressStorage {
    int insert(Address socialAddresRecord, int id) throws DALException, DALException;
    Address select(int id) throws DALException;
    boolean update();
    boolean delete();
}
