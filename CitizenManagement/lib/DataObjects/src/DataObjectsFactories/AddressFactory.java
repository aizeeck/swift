package DataObjectsFactories;

import address.Address;

/**
 * Created by aizeeck on 27.05.17.
 */
public class AddressFactory {

    private AddressFactory() {}

    public static Address createAddress(String[] personSplit) {
        if (personSplit.length < 13 || (personSplit[12].equals("") || personSplit[13].equals(""))) {
            Address address = new Address(
                    personSplit[6],
                    personSplit[7],
                    personSplit[8],
                    personSplit[9],
                    personSplit[10],
                    personSplit[11]
            );
            return address;
        } else {
            Address address = new Address(
                    personSplit[6],
                    personSplit[7],
                    personSplit[8],
                    personSplit[9],
                    personSplit[10],
                    personSplit[11],
                    Integer.parseInt(personSplit[12]),
                    Integer.parseInt(personSplit[13])
            );
            return address;
        }
    }
}

