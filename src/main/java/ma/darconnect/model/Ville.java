package ma.darconnect.model;

public enum Ville {
    CASABLANCA, RABAT, NADOR, OUJDA;

    public String label() {
        String n = name().toLowerCase().replace('_', ' ');
        return Character.toUpperCase(n.charAt(0)) + n.substring(1);
    }
}
