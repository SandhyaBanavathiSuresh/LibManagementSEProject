public class librarian extends User {
    private String searchString;

    public librarian(String name, String id, String searchString) {
        super(name, id);
        this.searchString = searchString;
    }

    public void verifyLibrarian() { /* implementation */ }
    public void search() { /* implementation */ }
    public String getSearchString() { return searchString; }
    public void setSearchString(String searchString) { this.searchString = searchString; }
}
