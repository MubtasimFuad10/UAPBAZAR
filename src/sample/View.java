package sample;

public enum View {
    Home("Home.fxml"),
    Login("Login.fxml");

    public final String label;
    View(String label) {
        this.label=label;
    }
    public String getFileName() {
        return label;
    }
}
