package utils;

import Pages.AddEmployeePage;
import Pages.LoginPage;

public class PageInitialiser {

    public static LoginPage loginPage;
    public static AddEmployeePage addEmployeePage;

    public static void initilizePageObjects() {
        loginPage = new LoginPage();
        addEmployeePage=new AddEmployeePage();
    }
}