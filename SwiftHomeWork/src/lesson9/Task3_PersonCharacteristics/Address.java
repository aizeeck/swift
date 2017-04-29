package lesson9.Task3_PersonCharacteristics;

/**
 * Created by aizeeck on 27.04.17.
 */
public class Address {
    private String country;
    private String city;
    private String municipality;
    private String postalCode;
    private String street;
    private String number;
    private String flor;
    private String apartmentNo;

    public Address(String country, String city, String municipality, String postalCode, String street, String number, String flor, String apartmentNo) {
        this.country = country;
        this.city = city;
        this.municipality = municipality;
        this.postalCode = postalCode;
        this.street = street;
        this.number = number;
        this.flor = flor;
        this.apartmentNo = apartmentNo;
    }

    @Override
    public String toString() {
        String result = String.format(
                "%s %s Street " +
                "\nfl.%s, ap.%s" +
                "\n%s %s " +
                "\n%s, %s",
                number, street,
                flor, apartmentNo,
                postalCode, municipality,
                city, country);
        return result;
    }
}
