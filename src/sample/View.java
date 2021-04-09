package sample;

public enum View {
    Admin("Admin.fxml"),
    Login("Login.fxml"),
    Admin("Admin.fxml"),

    SceneOne("SceneOne.fxml"),
    SceneTwo("SceneTwo.fxml");
    public final String label;
    View(String label) {
        this.label=label;
    }
    public String getFileName() {
        return label;
    }
}
