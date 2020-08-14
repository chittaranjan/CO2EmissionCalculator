package model;

public enum Profile {
    DRIVING_CAR("driving-car"),
    DRIVING_HGV("driving-hgv");

    private String profileName;
    private Profile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}
