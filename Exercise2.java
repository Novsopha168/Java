import java.util.Scanner;

public class Exercise2 {

    public interface DiscountRate {
        double getServiceMemberDiscount();

        double getProductMemberDiscount();
    }

    public static class Customer implements DiscountRate {
        private String customerName;
        private String customerType;

        public Customer(String customerName, String customerType) {
            this.customerName = customerName;
            this.customerType = customerType;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerType() {
            return customerType;
        }

        public void setCustomerType(String customerType) {
            this.customerType = customerType;
        }

        @Override
        public double getServiceMemberDiscount() {
            switch (customerType) {
                case "Premium":
                    return 0.2;
                case "Gold":
                    return 0.15;
                case "Silver":
                    return 0.1;
                default:
                    return 0;
            }
        }

        @Override
        public double getProductMemberDiscount() {
            switch (customerType) {
                case "Premium":
                    return 0.1;
                case "Gold":
                    return 0.1;
                case "Silver":
                    return 0.1;
                default:
                    return 0;
            }
        }
    }

    public static class Sale {
        private Customer customer;
        private String date;
        private double serviceExpense;
        private double productExpense;

        public Sale(Customer customer, String date) {
            this.customer = customer;
            this.date = date;
        }

        public String getDate() {
            return date;
        }

        public double getServiceExpense() {
            return serviceExpense;
        }

        public void setServiceExpense(double serviceExpense) {
            this.serviceExpense = serviceExpense;
        }

        public double getProductExpense() {
            return productExpense;
        }

        public void setProductExpense(double productExpense) {
            this.productExpense = productExpense;
        }

        public double getTotalExpense() {
            return serviceExpense + productExpense;
        }

        public double getDiscountedExpense() {
            double serviceDiscount = serviceExpense * customer.getServiceMemberDiscount();
            double productDiscount = productExpense * customer.getProductMemberDiscount();
            return serviceExpense - serviceDiscount + productExpense - productDiscount;
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();

        System.out.println("Enter customer type (Premium, Gold, Silver):");
        String customerType = scanner.nextLine();

        Customer customer = new Customer(customerName, customerType);

        System.out.println("Enter sale date (yyyy-mm-dd):");
        String date = scanner.nextLine();

        System.out.println("Enter service expense:");
        double serviceExpense = scanner.nextDouble();

        System.out.println("Enter product expense:");
        double productExpense = scanner.nextDouble();

        Sale sale = new Sale(customer, date);
        sale.setServiceExpense(serviceExpense);
        sale.setProductExpense(productExpense);

        System.out.println("Date for customer: "+date);
        System.out.println("Total expense: " + sale.getTotalExpense());
        System.out.println("Discounted expense: " + sale.getDiscountedExpense());

    }
}