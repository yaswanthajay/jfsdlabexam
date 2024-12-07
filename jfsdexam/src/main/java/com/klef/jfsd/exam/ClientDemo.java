package com.klef.jfsd.exam;

	import org.hibernate.Session;
	import org.hibernate.Transaction;
	import org.hibernate.query.Query;

	import java.util.List;

	public class ClientDemo {
	    public static void main(String[] args) {
	        insertClients();
	        printAllClients();
	    }

	    // Insert records
	    public static void insertClients() {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();

	        client client1 = new client();
	        client1.setName("Alice");
	        client1.setGender("Female");
	        client1.setAge(25);
	        client1.setLocation("New York");
	        client1.setEmailAddress("alice@example.com");
	        client1.setMobileNumber("1234567890");

	        client client2 = new client();
	        client2.setName("Bob");
	        client2.setGender("Male");
	        client2.setAge(30);
	        client2.setLocation("Los Angeles");
	        client2.setEmailAddress("bob@example.com");
	        client2.setMobileNumber("9876543210");

	        session.save(client1);
	        session.save(client2);

	        transaction.commit();
	        session.close();

	        System.out.println("Clients inserted successfully.");
	    }

	    // Print all records
	    public static void printAllClients() {
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        Query<client> query = session.createQuery("from Client", client.class);
	        List<client> clients = query.list();

	        System.out.println("\nAll Clients:");
	        for (client client : clients) {
	            System.out.println("ID: " + client.getId() +
	                    ", Name: " + client.getName() +
	                    ", Gender: " + client.getGender() +
	                    ", Age: " + client.getAge() +
	                    ", Location: " + client.getLocation() +
	                    ", Email: " + client.getEmailAddress() +
	                    ", Mobile: " + client.getMobileNumber());
	        }

	        session.close();
	    }
	}

