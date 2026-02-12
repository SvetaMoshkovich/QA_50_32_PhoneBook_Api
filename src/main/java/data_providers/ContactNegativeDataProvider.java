package data_providers;

import dto.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactNegativeDataProvider {

    @DataProvider(name = "dataProviderFromNegativeFile")
    public Object[][] dataProviderFromNegativeFile() {
        List<Object[]> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/test/resources/data_csv/data_contacts_negative.csv"))) {

            String line = reader.readLine(); // пропускаем заголовок

            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");

                Contact contact = Contact.builder()
                        .name(split[0])
                        .lastName(split[1])
                        .email(split[2])
                        .phone(split[3])
                        .address(split[4])
                        .description(split[5])
                        .build();

                list.add(new Object[]{contact});
            }

        } catch (IOException e) {
            throw new RuntimeException("IO exception");
        }

        return list.toArray(new Object[0][]);
    }
}