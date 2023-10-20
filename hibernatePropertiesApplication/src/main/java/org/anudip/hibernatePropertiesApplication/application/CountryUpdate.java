package org.anudip.hibernatePropertiesApplication.application;
import java.util.List;
import java.util.Scanner;
import org.anudip.hibernatePropertiesApplication.bean.Country;
import org.anudip.hibernatePropertiesApplication.dao.DatabaseHandler;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CountryUpdate {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the country code: ");
        int code = Integer.parseInt(scanner.nextLine());

        // Create a DatabaseHandler instance
        DatabaseHandler dbHandler = DatabaseHandler.getDatabaseHandler();

        // Create a Hibernate session
        Session session = dbHandler.createSession();
        Transaction transaction = null;

        try {
            // Create an HQL query to fetch countries by code
            String queryStatement = "FROM Country WHERE countryCode = :code";
            Query<Country> query = session.createQuery(queryStatement);
            query.setParameter("code", code);

            // Execute the query and get the list of matching countries
            List<Country> countryList = query.list();

            if (countryList.isEmpty()) {
                System.out.println("Country not found for code: " + code);
            } else {
                // Assuming there's only one matching country
                Country country = countryList.get(0);

                // Display all details of the country
                System.out.println("Current details for " + country.getCountryName() + ":");
                System.out.println("Country Code: " + country.getCountryCode());
                System.out.println("Country Name: " + country.getCountryName());
                System.out.println("Current GDP: " + country.getGdp());

                // Prompt the user to enter the new GDP
                System.out.println("Enter the new GDP for " + country.getCountryName() + ": ");
                double newGDP = Double.parseDouble(scanner.nextLine());

                // Update the GDP of the country
                country.setGdp(newGDP);

                // Begin a transaction
                transaction = session.beginTransaction();

                // Save the updated country object to the database
                session.update(country);

                // Commit the transaction
                transaction.commit();

                System.out.println("GDP for " + country.getCountryName() + " updated successfully.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
