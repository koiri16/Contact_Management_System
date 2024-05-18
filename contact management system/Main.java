import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();

        while (true) {
            System.out.println("Contact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addContact(scanner, contactManager);
                    break;
                case 2:
                    viewContacts(contactManager);
                    break;
                case 3:
                    editContact(scanner, contactManager);
                    break;
                case 4:
                    deleteContact(scanner, contactManager);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact(Scanner scanner, ContactManager contactManager) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        contactManager.addContact(contact);
        System.out.println("Contact added successfully.");
    }

    private static void viewContacts(ContactManager contactManager) {
        System.out.println("Contact List:");
        for (int i = 0; i < contactManager.getContacts().size(); i++) {
            System.out.println((i + 1) + ". " + contactManager.getContacts().get(i));
        }
    }

    private static void editContact(Scanner scanner, ContactManager contactManager) {
        viewContacts(contactManager);
        System.out.print("Enter the number of the contact to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume newline

        if (index >= 0 && index < contactManager.getContacts().size()) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();

            Contact newContact = new Contact(name, phoneNumber, email);
            contactManager.editContact(index, newContact);
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    private static void deleteContact(Scanner scanner, ContactManager contactManager) {
        viewContacts(contactManager);
        System.out.print("Enter the number of the contact to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume newline

        if (index >= 0 && index < contactManager.getContacts().size()) {
            contactManager.deleteContact(index);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Invalid contact number.");
        }
    }
}
