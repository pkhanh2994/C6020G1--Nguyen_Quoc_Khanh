package CaseStudy.controllers;

import CaseStudy.commons.*;
import CaseStudy.exception.*;
import CaseStudy.models.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static CaseStudy.commons.WriteCSV.writeCSV;
import static CaseStudy.commons.WriteCSVCustomer.writeCSVCustomer;

public class MainController {
    public static Scanner scanner = new Scanner(System.in);
    final static String VILA = "C:\\C0620G1- Nguyen Quoc Khanh\\module2\\src\\CaseStudy\\data\\vila.csv";
    final static String HOUSE = "C:\\C0620G1- Nguyen Quoc Khanh\\module2\\src\\CaseStudy\\data\\house.csv";
    final static String ROOM = "C:\\C0620G1- Nguyen Quoc Khanh\\module2\\src\\CaseStudy\\data\\room1.csv";
    final static String CUSTOMER = "C:\\C0620G1- Nguyen Quoc Khanh\\module2\\src\\CaseStudy\\data\\customer.csv";
    final static String CUSTOMER_SORT = "C:\\C0620G1- Nguyen Quoc Khanh\\module2\\src\\CaseStudy\\data\\customer_sort.txt";
    final static String BOOKING_CSV = "C:\\C0620G1- Nguyen Quoc Khanh\\module2\\src\\CaseStudy\\data\\booking.csv";

    public static List<Customer> arrCustomer=new ArrayList<>();
    public static Queue<Customer> customerQueue = new LinkedList<>();
    public static int ticket = 2;

    public static void displayMainMenu() {
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please select your option");
            System.out.println("1. Add New Services\n" + "2. Show Services\n" + "3. Add New Customer\n" + "4. Show Information of Customer\n" +
                    "5. Show Customer Information UpdateSort\n" + "6. Add new booking\n" + "7.Show information employee\n" + "8.Buy ticket\n" + "9.Find employee\n" + "10.Exit");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    addNewServices();
                    break;
                case "2":
                    showServices();
                    break;
                case "3":
                    try {
                        addNewCustomer();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "4":
                    try {
                        showInformationOfCustomer();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case "5":
                    showInformationUpdateSort();
                    break;
                case "6":
                    addNewBooking();
                    break;
                case "7":
                    try {
                        showInformationOfEmployee();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case "8":
                    try {
                        buyTicket();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "9":
                    try {
                        findEmployee();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case "10":
                    check = false;
                    break;
            }

        } while (check);
    }

    public static void addNewServices() {
        boolean check = true;
        do {
            System.out.println("Please select your option");
            System.out.println("1.\tAdd New Villa\n" + "2.\tAdd New House\n" + "3.\tAdd New Room\n" + "4.\tBack to menu\n" + "5.\tExit");
            Scanner scanner = new Scanner(System.in);
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    try {
                        addNewVilla();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    try {
                        addNewHouse();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    try {
                        addNewRoom();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "4":
                    displayMainMenu();
                    break;
                case "5":
                    check = false;
                    break;
            }
        } while (check);

    }

    public static void showServices() {

        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please select your option");
            System.out.println("1.Show all villa\n" + "2.Show all house\n" + "3.Show all room\n" + "4.Show All Name Villa Not Duplicate\n" +
                    "5.Show All Name House Not Duplicate\n" + "6.Show All Name Room Not Duplicate\n" + "7. Back to menu\n" + "8.Exit");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    try {
                        showAllVilla();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        showAllHouse();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        showAllRoom();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        showAllNameVillaNotDuplicate();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        showAllNameHouseNotDuplicate();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 6:
                    try {
                        showAllNameRoomNotDuplicate();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    displayMainMenu();
                    break;
                case 8:
                    check = false;
                    break;

            }

        } while (check);
    }

    public static void showAllVilla() throws IOException {
        FileReader fileReader = new FileReader(VILA);
        int i = 1;
        String line;
        try (fileReader; BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Villa: " + i + " : " + line);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showAllHouse() throws FileNotFoundException {
        FileReader fileReader = new FileReader(HOUSE);
        int i = 1;
        String line;
        try (fileReader; BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("House: " + i + " : " + line);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showAllRoom() throws FileNotFoundException {
        FileReader fileReader = new FileReader(ROOM);
        int i = 1;
        String line;
        try (fileReader; BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Room " + i + " : " + line);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void showAllNameVillaNotDuplicate() throws IOException {
        List<Villa> arrayList = (ArrayList) ReadCSVVilla.readCSV(VILA);
        if (arrayList.isEmpty()) {
            System.out.println("The list of villa is empty");
        } else {
            TreeSet<String> treeSet = new TreeSet<>();
            System.out.println("The name of villa in list");
            for (Villa villa : arrayList) {
                treeSet.add(villa.getServicesType());
            }
            int i = 1;
            for (String name : treeSet) {
                System.out.println(i + ":" + name);
                i++;
            }
        }

    }

    public static void showAllNameHouseNotDuplicate() throws IOException {
        List<Villa> arrayList = (ArrayList) ReadCSVHouse.readCSVHouse(HOUSE);
        if (arrayList.isEmpty()) {
            System.out.println("The list of house is empty");
        } else {
            TreeSet<String> treeSet = new TreeSet<>();
            System.out.println("The name of house in list");
            for (Villa villa : arrayList) {
                treeSet.add(villa.getServicesType());
            }
            int i = 1;
            for (String name : treeSet) {
                System.out.println(i + ":" + name);
                i++;
            }
        }

    }

    public static void showAllNameRoomNotDuplicate() throws IOException {
        List<Villa> arrayList = (ArrayList) ReadCSVRoom.readCSVRoom(HOUSE);
        if (arrayList.isEmpty()) {
            System.out.println("The list of room is empty");
        } else {
            TreeSet<String> treeSet = new TreeSet<>();
            System.out.println("The name of room in list");
            for (Villa villa : arrayList) {
                treeSet.add(villa.getServicesType());
            }
            int i = 1;
            for (String name : treeSet) {
                System.out.println(i + ":" + name);
                i++;
            }
        }

    }


    public static void showInformationOfCustomer() throws FileNotFoundException {
        FileReader fileReader = new FileReader(CUSTOMER);
        int i = 1;
        String line;
        try (fileReader; BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Customer" + i + " : " + line);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showInformationUpdateSort() {

        try {
            arrCustomer = ReadCustomerCSV.readCSVCustomer();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Collections.sort(arrCustomer, new Customer());
            int i = 1;
            for (Customer customer : arrCustomer) {
                System.out.println("Customer " + i + " :" + customer.toString());
                i++;
            }


    }

    public static void showInformationOfEmployee() throws FileNotFoundException {
        List<Employee> arrlist = ReadCSVEmployee.readCSVEmployee();
        Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : arrlist) {
            employeeMap.put(employee.getId(), employee);
        }
        System.out.println("The employee in list");
        for (Map.Entry<String, Employee> employeeEntry : employeeMap.entrySet()) {
            System.out.println(employeeEntry.toString());
        }
    }

    public static void buyTicket() throws IOException {
        if (ticket > 0) {
            showInformationUpdateSort();
            System.out.println("Select customer for buy ticket");
            int chooseCustomer = scanner.nextInt() - 1;
            Customer customer = null;
            for (int i = 0; i < arrCustomer.size(); i++) {
                customer = arrCustomer.get(chooseCustomer);
            }
            System.out.println(customer);
            customerQueue.offer(customer);
            System.out.println("The ticket was bought");
            ticket--;
        } else {
            System.out.println("The ticket was sold out");
            System.out.println("The list of customer who bought the ticket");
            int i = 1;
            for (Customer customer : customerQueue) {
                System.out.println(i + ": " + customer.toString());
                i++;
            }
        }

    }

    public static void addNewVilla() throws IOException {

        String id = inputID("VL");
        String servicesType = inputServicesType();
        double poolArea = inputPool();
        int rentCost = inputRentCost();
        int guestAmount = inputGuestAmount();
        String rentType = inputRentType();
        String standardRoom = inputStandardRoom();
        int floors = inputFloors();
        scanner.skip("\\R");
        System.out.println("Enter the  other exclusives");
        String otherExclusives = scanner.nextLine();
        double area = inputArea();
        Villa villa = new Villa();
        villa.setId(id);
        villa.setServicesType(servicesType);
        villa.setRentCost(rentCost);
        villa.setGuestAmount(guestAmount);
        villa.setRentType(rentType);
        villa.setArea(area);
        villa.setStandardRoom(standardRoom);
        villa.setPoolArea(poolArea);
        villa.setOtherExclusives(otherExclusives);
        villa.setFloors(floors);

        writeCSV(VILA, villa);

    }

    public static void addNewHouse() throws IOException {
        String id = inputID("HO");
        String servicesType = inputServicesType();
        int rentCost = inputRentCost();
        int guestAmount = inputGuestAmount();
        String rentType = inputRentType();
        String standardRoom = inputStandardRoom();
        int floors = inputFloors();
        scanner.skip("\\R");
        System.out.println("Enter the  other exclusives");
        String otherExclusives = scanner.nextLine();
        double area = inputArea();
        House house = new House();
        house.setId(id);
        house.setServicesType(servicesType);
        house.setRentCost(rentCost);
        house.setGuestAmount(guestAmount);
        house.setRentType(rentType);
        house.setArea(area);
        house.setStandardRoom(standardRoom);
        house.setOtherExclusives(otherExclusives);
        house.setFloors(floors);
        writeCSV(HOUSE, house);
    }

    public static void addNewRoom() throws IOException {
        String id = inputID("RO");
        String servicesType = inputServicesType();
        int rentCost = inputRentCost();
        int guestAmount = inputGuestAmount();
        String rentType = inputRentType();
        double area = inputArea();
        scanner.skip("\\R");
        String freeServiceIncluded;
        Matcher matcher;
        final String FREE_REGEX = "^karaoke$|^massage$|^food$|^drink$|^car$";

        do {
            Pattern pattern = Pattern.compile(FREE_REGEX);
            System.out.println("Enter the free service included");
            freeServiceIncluded = scanner.nextLine();
            matcher = pattern.matcher(freeServiceIncluded);
            if (!matcher.matches()) {
                System.out.println("The free services must be karaoke/massage/drink/food/car");
            }
        } while (!matcher.matches());
        Room room = new Room();
        room.setId(id);
        room.setServicesType(servicesType);
        room.setRentCost(rentCost);
        room.setGuestAmount(guestAmount);
        room.setRentType(rentType);
        room.setArea(area);
        room.setFreeServiceIncluded(freeServiceIncluded);
        writeCSV(ROOM, room);

    }

    public static void addNewCustomer() throws IOException {
        Customer customer = new Customer();
        String name = inputName();
        String email = inputEmail();
        String gender = inputGender();
        String identifyCard = inputIdentifyCard();
        String birthday = inputBirthday();
        System.out.println("Enter the type guest");
        String typeGuest = scanner.nextLine();
        System.out.println("Enter the address");
        String address = scanner.nextLine();
        customer.setName(name);
        customer.setBirthday(birthday);
        customer.setGender(gender);
        customer.setIdentifyCard(identifyCard);
        String phoneNumber = inputPhoneNumber();
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);
        customer.setTypeGuest(typeGuest);
        customer.setAddress(address);
        writeCSVCustomer(CUSTOMER, customer);


    }

    public static void addNewBooking() {
        showInformationUpdateSort();
        System.out.println("Select customer for booking");
        int chooseCustomer = scanner.nextInt() - 1;
        Customer customer = null;
        for (int i = 0; i < arrCustomer.size(); i++) {
            customer = arrCustomer.get(chooseCustomer);
        }
        System.out.println(customer);
        boolean check = true;
        do {
            System.out.println("Select services to booking\n" +
                    "1.Booking villa\n" + "2.Booking house\n" + "3.Booking Room\n" + "4.Exit");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    try {
                        showAllVilla();
                        ArrayList arrayList = (ArrayList) ReadCSVVilla.readCSV(VILA);
                        System.out.println("Select the  villa to booking");
                        int chooseType = scanner.nextInt();
                        Services service = (Services) arrayList.get(chooseType - 1);
                        assert customer != null;
                        customer.setServices(service);
                        writeCSVCustomer(BOOKING_CSV, customer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        showAllHouse();
                        ArrayList arrayList = (ArrayList) ReadCSVHouse.readCSVHouse(HOUSE);
                        System.out.println("Select the  villa to booking");
                        int chooseType = scanner.nextInt();
                        Services service = (Services) arrayList.get(chooseType - 1);
                        System.out.println(service);
                        assert customer != null;
                        customer.setServices(service);
                        writeCSVCustomer(BOOKING_CSV, customer);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        showAllRoom();
                        ArrayList arrayList = (ArrayList) ReadCSVRoom.readCSVRoom(ROOM);
                        System.out.println("Select the  room to booking");
                        int chooseType = scanner.nextInt();
                        Services service = (Services) arrayList.get(chooseType - 1);
                        System.out.println(service);
                        assert customer != null;
                        customer.setServices(service);
                        writeCSVCustomer(BOOKING_CSV, customer);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    check = false;
                    break;
            }
        } while (check);


    }


    private static String inputPhoneNumber() {
        String phoneNumber;
        Matcher matcher;
        final String PHONE_REGEX = "^\\d{2}-0\\d{8}$";
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        System.out.println("Enter the phone number");
        phoneNumber = scanner.nextLine();
        matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches()) {
            try {
                throw new PhoneNumberException();
            } catch (PhoneNumberException e) {
                System.out.println("The phone number must be number and following this format: xx-0xxxxxxxx. With x is a number from 1 to 9");
                return inputPhoneNumber();
            }
        }
        return phoneNumber;

    }

    private static String inputEmail() {
        String email;
        final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        Matcher matcher;
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        System.out.println("Enter the email");
        email = scanner.nextLine();
        matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            try {
                throw new EmailException();
            } catch (EmailException e) {
                System.out.println("The email is invalid");
                return inputEmail();
            }
        }
        return email;

    }

    private static String inputName() {
        String name;
        final String NAME_REGEX = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}*)+$";
        Matcher matcher;

        Pattern pattern = Pattern.compile(NAME_REGEX);
        System.out.println("Enter the customer's name");
        name = scanner.nextLine();
        matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            try {
                throw new NameException();
            } catch (NameException e) {
                System.out.println("The name is invalid");
                return inputName();
            }

        }
        return name;
    }

    public static String inputGender() {
        String gender;
        final String GENDER_REGEX = "^Male$|^Female$|^Unknown$";
        Matcher matcher;
        Pattern pattern = Pattern.compile(GENDER_REGEX);
        System.out.println("Enter the gender");
        gender = scanner.nextLine();
        gender = gender.toLowerCase();
        gender = Character.toUpperCase(gender.charAt(0)) + gender.substring(1);
        matcher = pattern.matcher(gender);
        if (!matcher.matches()) {
            try {
                throw new GenderException();
            } catch (GenderException e) {
                System.out.println("The gender is invalid");
                return inputGender();
            }
        }
        return gender;

    }

    public static String inputIdentifyCard() {
        String identifyCard;
        final String ID_REGEX = "^\\d{3}\\s\\d{3}\\s\\d{3}$";
        Matcher matcher;
        Pattern pattern = Pattern.compile(ID_REGEX);
        System.out.println("Enter the identify card number");
        identifyCard = scanner.nextLine();
        matcher = pattern.matcher(identifyCard);
        if (!matcher.matches()) {
            try {
                throw new IdCardException();
            } catch (IdCardException e) {
                System.out.println(" Id Card must have 9 digits and be in the format XXX XXX XXX");
                return inputIdentifyCard();
            }
        }
        return identifyCard;

    }

    public static String inputBirthday() {
        String birthday;
        final String BIRTHDAY_REGEX = "^((0[1-9])|([1-2][0-9])|(3[0-1]))\\/(([0][1-9])|1[0-2])\\/(19[0-9]{2}|20[0-1][0-9]|2002)$";
        Matcher matcher;
        Pattern pattern = Pattern.compile(BIRTHDAY_REGEX);
        System.out.println("Enter the day of birth");
        birthday = scanner.nextLine();
        matcher = pattern.matcher(birthday);
        if (!matcher.matches()) {
            try {
                throw new BirthdayException();
            } catch (BirthdayException e) {
                System.out.println("The year of birth must be greater than 1900 and less than the current year 18 years, dd / mm / yyyy in the correct format");
                return inputBirthday();
            }
        }
        return birthday;
    }

    public static String inputID(String type) {
        String id;
        Matcher matcher;
        final String ID_REGEX = "^SV" + type + "-\\d{4}$";
        do {
            Pattern pattern = Pattern.compile(ID_REGEX);
            System.out.println("Enter the ID");
            id = scanner.nextLine();
            matcher = pattern.matcher(id);
            if (!matcher.matches())
                System.out.println("Invalid ID. Correct ID: SV" + type + "-XXXX with X is number from 0-9");
        } while (!matcher.matches());
        return id;
    }

    public static String inputServicesType() {


        System.out.println("Enter the services type ");
        String servicesType = scanner.next();
        servicesType = servicesType.toLowerCase();
        servicesType = Character.toUpperCase(servicesType.charAt(0)) + servicesType.substring(1);
        return servicesType;

    }

    public static double inputPool() {

        double poolArea;
        do {
            System.out.println("Enter the pool area");
            poolArea = scanner.nextDouble();
            if (poolArea < 30) {
                System.out.println("The area must be larger than 30 square meters");

            }
        } while (poolArea < 30);
        return poolArea;
    }

    public static int inputRentCost() {
        int rentCost;
        do {
            System.out.println("Enter the rent cost");
            rentCost = scanner.nextInt();
            if (rentCost < 0) {
                System.out.println("The rent must be positive");
            }
        } while (rentCost < 0);
        return rentCost;

    }

    public static int inputGuestAmount() {
        int guestAmount;
        do {
            System.out.println("Enter the guest amount");
            guestAmount = scanner.nextInt();
            if (guestAmount < 0 || guestAmount > 20) {
                System.out.println("The maximum number of guests must be greater than 0 and less than 20");
            }
        } while (guestAmount < 0 || guestAmount > 20);
        return guestAmount;
    }

    private static String inputRentType() {
        System.out.println("Input rent type");
        String rentType = scanner.next();
        rentType = rentType.toLowerCase();
        rentType = Character.toUpperCase(rentType.charAt(0)) + rentType.substring(1);
        return rentType;
    }

    public static String inputStandardRoom() {
        System.out.println("Enter the standard roome ");
        String standardRoom = scanner.next();
        standardRoom = standardRoom.toLowerCase();
        standardRoom = Character.toUpperCase(standardRoom.charAt(0)) + standardRoom.substring(1);
        return standardRoom;
    }

    public static int inputFloors() {
        int floors;
        do {
            System.out.println("Enter the floors");
            floors = scanner.nextInt();
            if (floors < 0) {
                System.out.println("The floors must be integer and greater than 0");
            }
        } while (floors < 0);
        return floors;
    }

    public static double inputArea() {
        double area;
        do {
            System.out.println("Enter the area");
            area = scanner.nextDouble();
            if (area < 30) {
                System.out.println("The area must be larger than 30 square meters");
            }
        } while (area < 30);
        return area;
    }

    public static void findEmployee() throws FileNotFoundException {
        Cabinet cabinet = new Cabinet();
        boolean check = true;
        System.out.println("Enter the id of employee to find information");
        String id = scanner.nextLine();
        while (!Cabinet.employeesStack.empty()) {
            Employee employee = Cabinet.employeesStack.pop();
            if (id.equals(employee.getId())) {
                System.out.println("The information of employee is: " + employee);
                check = false;
            }
        }
        if (check) {
            System.out.println("The employee was not found");
        }

    }

}
