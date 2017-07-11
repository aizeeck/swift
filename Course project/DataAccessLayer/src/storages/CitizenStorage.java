package storages;

import address.Address;
import exceptions.DALException;
import personaldetails.Citizen;

import java.util.List;

/**
 * Created by aizeeck on 24.05.17.
 */
public interface CitizenStorage {
    int insert(Citizen citizen) throws DALException;
    List<Citizen> select(int id) throws DALException;
    boolean update();
    boolean delete();
}
