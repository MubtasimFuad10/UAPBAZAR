package sample;

public enum View {
    Login("Login.fxml"),
    SignUp("SignUp.fxml"),

    AdminPanel("AdminPanel.fxml"),
    Admin("Admin.fxml"),

    Home("Home.fxml"),
    Food("Food.fxml"),
    Clothing("Clothing.fxml"),
    Electronic("Electronic.fxml"),


    Cart("Cart.fxml");

    public final String label;
    View(String label) {
        this.label=label;
    }
    public String getFileName() {
        return label;
    }
}
